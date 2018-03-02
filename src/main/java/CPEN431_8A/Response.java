package CPEN431_8A;


import com.google.protobuf.ByteString;

public class Response {
    Enums.ResponseCode code;
    ByteString value;
    Integer version;
    Integer pid;
    Integer overloadWaitTime;
}