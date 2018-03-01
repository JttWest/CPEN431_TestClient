package CPEN431_8A;

import ca.NetSysLab.ProtocolBuffers.KeyValueRequest;
import ca.NetSysLab.ProtocolBuffers.KeyValueResponse;
import ca.NetSysLab.ProtocolBuffers.Message;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.zip.CRC32;
import java.util.zip.Checksum;

public class Codec {

    public static Request decodeRequest(byte[] rawRequest) throws
            InvalidChecksumException,
            InvalidProtocolBufferException,
            UnknownHostException {

        // parse the request into Protobuf object
        Message.Msg requestMsg = Message.Msg.parseFrom(rawRequest);

        // validate checksum
        long msgChecksum = requestMsg.getCheckSum();
        byte[] genChecksumInput = concatByteArrays(requestMsg.getMessageID().toByteArray(), requestMsg.getPayload().toByteArray());
        if (msgChecksum != generateChecksum(genChecksumInput))
            throw new InvalidChecksumException("Checksum from id and payload is wrong");

        // get command and return proper Request
        ByteString messageId = requestMsg.getMessageID();

        KeyValueRequest.KVRequest kvRequest = KeyValueRequest.KVRequest.parseFrom(requestMsg.getPayload());
        Enums.CommandCode command = Enums.CommandCode.fromInteger(kvRequest.getCommand());
        ByteString key = kvRequest.getKey();
        ByteString value = kvRequest.getValue();
        int version = kvRequest.getVersion();
        int senderNodeId = kvRequest.hasSenderNodeId() ? kvRequest.getSenderNodeId() : -1;
        int nodeId = kvRequest.hasNodeId() ? kvRequest.getNodeId() : -1;

        // packet was forwarded by one of the nodes
        if (kvRequest.hasOriginAddress()) {
            InetAddress address = InetAddress.getByName(kvRequest.getOriginAddress());
            int port = kvRequest.getOriginPort();

            return new Request(messageId, command, key, value, version, senderNodeId, nodeId, address, port);
        }

        return new Request(messageId, command, key, value, version, senderNodeId, nodeId);
    }

    // encodes a request for forwarding to a different node
    public static byte[] encodeRequest(Request request) {
    	KeyValueRequest.KVRequest.Builder requestBuilder;
    	if(request.messageId == ByteString.EMPTY) {
    		//if epidemic
			if (request.command == Enums.CommandCode.EPIDEMIC) {
				requestBuilder = KeyValueRequest.KVRequest.newBuilder()
		                .setCommand(request.command.value())
		                .setNodeId(request.nodeId);
			}
			//else is healthcheck/heartbeat request
			else {
				requestBuilder = KeyValueRequest.KVRequest.newBuilder()
							.setCommand(request.command.value())
			                .setSenderNodeId(request.senderNodeId);
			}	
    		 
    	}
    	else {
	    	requestBuilder = KeyValueRequest.KVRequest.newBuilder()
	                .setCommand(request.command.value())
	                .setKey(request.key)
	                .setValue(request.value)
	                .setVersion(request.version)
	                .setOriginAddress(request.originAddress.getHostAddress())
	                .setOriginPort(request.originPort);
    	}

        KeyValueRequest.KVRequest requestPayload = requestBuilder.build();

        // create the checksum as messageId +++ ResponsePayload
        long checksumValue = generateChecksum(
                concatByteArrays(request.messageId.toByteArray(), requestPayload.toByteArray()));

        // create Message
        Message.Msg msg = Message.Msg.newBuilder()
                .setMessageID(request.messageId)
                .setPayload(requestPayload.toByteString())
                .setCheckSum(checksumValue)
                .build();

        return msg.toByteArray();
    }

    public static byte[] encodeResponse(ByteString messageId, Response response) {
        KeyValueResponse.KVResponse.Builder responseBuilder = KeyValueResponse.KVResponse.newBuilder()
                .setErrCode(response.code.value());

        if (response.body != null)
            response.body.setBody(responseBuilder);

        KeyValueResponse.KVResponse responsePayload = responseBuilder.build();

        // create the checksum as messageId +++ ResponsePayload
        long checksumValue = generateChecksum(
                concatByteArrays(messageId.toByteArray(), responsePayload.toByteArray()));

        // create Message
        Message.Msg msg = Message.Msg.newBuilder()
                .setMessageID(messageId)
                .setPayload(responsePayload.toByteString())
                .setCheckSum(checksumValue)
                .build();

        return msg.toByteArray();
    }

    private static long generateChecksum(byte[] bytes) {
        Checksum checksum = new CRC32();
        checksum.update(bytes, 0, bytes.length);

        return checksum.getValue();
    }

    private static byte[] concatByteArrays(byte[] a, byte[] b) {
        byte[] c = new byte[a.length + b.length];
        System.arraycopy(a, 0, c, 0, a.length);
        System.arraycopy(b, 0, c, a.length, b.length);

        return c;
    }

    public static class InvalidChecksumException extends Exception {
        public InvalidChecksumException(String message) {
            super(message);
        }
    }
}
