package CPEN431_8A;

import com.google.protobuf.ByteString;

import java.net.InetAddress;
import java.security.SecureRandom;


public class Request {
    private static final int MESSAGEID_SIZE = 16;
    private static final SecureRandom random = new SecureRandom();

    ByteString messageId;
    Enums.CommandCode command;
    ByteString key;
    ByteString value;
    int version;

    public Request() {
        byte[] messageIdBytes = new byte[MESSAGEID_SIZE];
        this.messageId = ByteString.copyFrom(messageIdBytes);
    }

    public boolean routable() {
        return command == Enums.CommandCode.GET ||
                command == Enums.CommandCode.PUT ||
                command == Enums.CommandCode.REMOVE;
    }
}
