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
    // encodes a request to be send to the nodes
    public static byte[] encodeRequest(Request request) {
        KeyValueRequest.KVRequest.Builder requestBuilder =
                KeyValueRequest.KVRequest.newBuilder()
                        .setCommand(request.command.value());

        if (request.key != null) requestBuilder.setKey(request.key);
        if (request.value != null) requestBuilder.setValue(request.value);
        requestBuilder.setVersion(request.version);

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

    public static Response decodeResponse(byte[] rawResponse) throws
            InvalidProtocolBufferException,
            InvalidChecksumException {
        // create the Message
        Message.Msg msg = Message.Msg.parseFrom(rawResponse);

        // validate the uniqueId
        // if (!isCorrectUniqueId(uniqueId, replyId))
        //     throw new MismatchUniqueIdException("UniqueId in reply is incorrect.");

        // validate checksum
        byte[] replyId = msg.getMessageID().toByteArray();
        long checksum = msg.getCheckSum();
        if (checksum != generateChecksum(concatByteArrays(replyId, msg.getPayload().toByteArray())))
            throw new InvalidChecksumException("Checksum from id and payload is wrong");

        // payload should be good at this point
        KeyValueResponse.KVResponse resPayload = KeyValueResponse.KVResponse.parseFrom(msg.getPayload());

        Response response = new Response();

        if (resPayload.hasErrCode()) response.code = Enums.ResponseCode.fromInteger(resPayload.getErrCode());
        if (resPayload.hasValue()) response.value = resPayload.getValue();
        if (resPayload.hasVersion()) response.version = resPayload.getVersion();
        if (resPayload.hasPid()) response.pid = resPayload.getPid();
        if (resPayload.hasOverloadWaitTime()) response.overloadWaitTime = resPayload.getOverloadWaitTime();

        return response;
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
