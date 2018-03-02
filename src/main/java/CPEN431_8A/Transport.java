package CPEN431_8A;

import com.google.protobuf.InvalidProtocolBufferException;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Transport {
    DatagramSocket socket = new DatagramSocket();
    int REQUEST_TIMEOUT = 500;

    byte[] responseBuffer = new byte[13000];

    public Transport() throws SocketException {
        socket.setSoTimeout(REQUEST_TIMEOUT);
    }

    public Response sendRequest(ServerNodes.Node destNode, Request request, int maxTries) {
        byte[] requestBytes = Codec.encodeRequest(request);

        DatagramPacket requestPacket = new DatagramPacket(
                requestBytes,
                requestBytes.length,
                destNode.address,
                destNode.port);

        DatagramPacket responsePacket;
        Response response = null;

        boolean hasResponse = false;
        int tries = 0;

        while (!hasResponse && tries < maxTries) {
            tries++;

            try {
                socket.send(requestPacket);

                responsePacket = new DatagramPacket(responseBuffer, responseBuffer.length);
                socket.receive(responsePacket);

                byte[] trimmedResponse = trimByteArray(responsePacket.getData(), responsePacket.getLength());
                response = Codec.decodeResponse(trimmedResponse);

                // messageId doesn't match, might be some old delayed packet
                if (!response.messageId.equals(request.messageId)) {
                    System.out.println("messageId doesn't match, might be some old delayed packet");
                    continue;
                }

                hasResponse = true;
            } catch (IOException | Codec.InvalidChecksumException e) {
                // e.printStackTrace();
            }
        }

        return response;
    }

    private static byte[] trimByteArray(byte[] bytes, int n) {
        byte[] res = new byte[n];
        System.arraycopy(bytes, 0, res,0, n);

        return res;
    }
}
