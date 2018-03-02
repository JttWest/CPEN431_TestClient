package CPEN431_8A;


import com.google.protobuf.ByteString;

public class Response {
    ByteString messageId;
    Enums.ResponseCode code;
    ByteString value;
    Integer version;
    Integer pid;
    Integer overloadWaitTime;
    Integer membershipCount;
}