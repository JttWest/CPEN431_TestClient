// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: KeyValueResponse.proto

package ca.NetSysLab.ProtocolBuffers;

public final class KeyValueResponse {
  private KeyValueResponse() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface KVResponseOrBuilder extends
      // @@protoc_insertion_point(interface_extends:KVResponse)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>required uint32 errCode = 1;</code>
     */
    boolean hasErrCode();
    /**
     * <code>required uint32 errCode = 1;</code>
     */
    int getErrCode();

    /**
     * <code>optional bytes value = 2;</code>
     */
    boolean hasValue();
    /**
     * <code>optional bytes value = 2;</code>
     */
    com.google.protobuf.ByteString getValue();

    /**
     * <code>optional int32 pid = 3;</code>
     */
    boolean hasPid();
    /**
     * <code>optional int32 pid = 3;</code>
     */
    int getPid();

    /**
     * <code>optional int32 version = 4;</code>
     */
    boolean hasVersion();
    /**
     * <code>optional int32 version = 4;</code>
     */
    int getVersion();

    /**
     * <code>optional int32 overloadWaitTime = 5;</code>
     */
    boolean hasOverloadWaitTime();
    /**
     * <code>optional int32 overloadWaitTime = 5;</code>
     */
    int getOverloadWaitTime();
  }
  /**
   * Protobuf type {@code KVResponse}
   */
  public static final class KVResponse extends
      com.google.protobuf.GeneratedMessage implements
      // @@protoc_insertion_point(message_implements:KVResponse)
      KVResponseOrBuilder {
    // Use KVResponse.newBuilder() to construct.
    private KVResponse(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    private KVResponse(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    private static final KVResponse defaultInstance;
    public static KVResponse getDefaultInstance() {
      return defaultInstance;
    }

    public KVResponse getDefaultInstanceForType() {
      return defaultInstance;
    }

    private final com.google.protobuf.UnknownFieldSet unknownFields;
    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    private KVResponse(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      initFields();
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 8: {
              bitField0_ |= 0x00000001;
              errCode_ = input.readUInt32();
              break;
            }
            case 18: {
              bitField0_ |= 0x00000002;
              value_ = input.readBytes();
              break;
            }
            case 24: {
              bitField0_ |= 0x00000004;
              pid_ = input.readInt32();
              break;
            }
            case 32: {
              bitField0_ |= 0x00000008;
              version_ = input.readInt32();
              break;
            }
            case 40: {
              bitField0_ |= 0x00000010;
              overloadWaitTime_ = input.readInt32();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e.getMessage()).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ca.NetSysLab.ProtocolBuffers.KeyValueResponse.internal_static_KVResponse_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ca.NetSysLab.ProtocolBuffers.KeyValueResponse.internal_static_KVResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ca.NetSysLab.ProtocolBuffers.KeyValueResponse.KVResponse.class, ca.NetSysLab.ProtocolBuffers.KeyValueResponse.KVResponse.Builder.class);
    }

    public static com.google.protobuf.Parser<KVResponse> PARSER =
        new com.google.protobuf.AbstractParser<KVResponse>() {
      public KVResponse parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new KVResponse(input, extensionRegistry);
      }
    };

    @java.lang.Override
    public com.google.protobuf.Parser<KVResponse> getParserForType() {
      return PARSER;
    }

    private int bitField0_;
    public static final int ERRCODE_FIELD_NUMBER = 1;
    private int errCode_;
    /**
     * <code>required uint32 errCode = 1;</code>
     */
    public boolean hasErrCode() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required uint32 errCode = 1;</code>
     */
    public int getErrCode() {
      return errCode_;
    }

    public static final int VALUE_FIELD_NUMBER = 2;
    private com.google.protobuf.ByteString value_;
    /**
     * <code>optional bytes value = 2;</code>
     */
    public boolean hasValue() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>optional bytes value = 2;</code>
     */
    public com.google.protobuf.ByteString getValue() {
      return value_;
    }

    public static final int PID_FIELD_NUMBER = 3;
    private int pid_;
    /**
     * <code>optional int32 pid = 3;</code>
     */
    public boolean hasPid() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>optional int32 pid = 3;</code>
     */
    public int getPid() {
      return pid_;
    }

    public static final int VERSION_FIELD_NUMBER = 4;
    private int version_;
    /**
     * <code>optional int32 version = 4;</code>
     */
    public boolean hasVersion() {
      return ((bitField0_ & 0x00000008) == 0x00000008);
    }
    /**
     * <code>optional int32 version = 4;</code>
     */
    public int getVersion() {
      return version_;
    }

    public static final int OVERLOADWAITTIME_FIELD_NUMBER = 5;
    private int overloadWaitTime_;
    /**
     * <code>optional int32 overloadWaitTime = 5;</code>
     */
    public boolean hasOverloadWaitTime() {
      return ((bitField0_ & 0x00000010) == 0x00000010);
    }
    /**
     * <code>optional int32 overloadWaitTime = 5;</code>
     */
    public int getOverloadWaitTime() {
      return overloadWaitTime_;
    }

    private void initFields() {
      errCode_ = 0;
      value_ = com.google.protobuf.ByteString.EMPTY;
      pid_ = 0;
      version_ = 0;
      overloadWaitTime_ = 0;
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      if (!hasErrCode()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeUInt32(1, errCode_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeBytes(2, value_);
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        output.writeInt32(3, pid_);
      }
      if (((bitField0_ & 0x00000008) == 0x00000008)) {
        output.writeInt32(4, version_);
      }
      if (((bitField0_ & 0x00000010) == 0x00000010)) {
        output.writeInt32(5, overloadWaitTime_);
      }
      getUnknownFields().writeTo(output);
    }

    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeUInt32Size(1, errCode_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(2, value_);
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(3, pid_);
      }
      if (((bitField0_ & 0x00000008) == 0x00000008)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(4, version_);
      }
      if (((bitField0_ & 0x00000010) == 0x00000010)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(5, overloadWaitTime_);
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }

    public static ca.NetSysLab.ProtocolBuffers.KeyValueResponse.KVResponse parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static ca.NetSysLab.ProtocolBuffers.KeyValueResponse.KVResponse parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static ca.NetSysLab.ProtocolBuffers.KeyValueResponse.KVResponse parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static ca.NetSysLab.ProtocolBuffers.KeyValueResponse.KVResponse parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static ca.NetSysLab.ProtocolBuffers.KeyValueResponse.KVResponse parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static ca.NetSysLab.ProtocolBuffers.KeyValueResponse.KVResponse parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static ca.NetSysLab.ProtocolBuffers.KeyValueResponse.KVResponse parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static ca.NetSysLab.ProtocolBuffers.KeyValueResponse.KVResponse parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static ca.NetSysLab.ProtocolBuffers.KeyValueResponse.KVResponse parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static ca.NetSysLab.ProtocolBuffers.KeyValueResponse.KVResponse parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(ca.NetSysLab.ProtocolBuffers.KeyValueResponse.KVResponse prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code KVResponse}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:KVResponse)
        ca.NetSysLab.ProtocolBuffers.KeyValueResponse.KVResponseOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return ca.NetSysLab.ProtocolBuffers.KeyValueResponse.internal_static_KVResponse_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return ca.NetSysLab.ProtocolBuffers.KeyValueResponse.internal_static_KVResponse_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                ca.NetSysLab.ProtocolBuffers.KeyValueResponse.KVResponse.class, ca.NetSysLab.ProtocolBuffers.KeyValueResponse.KVResponse.Builder.class);
      }

      // Construct using ca.NetSysLab.ProtocolBuffers.KeyValueResponse.KVResponse.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessage.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        }
      }
      private static Builder create() {
        return new Builder();
      }

      public Builder clear() {
        super.clear();
        errCode_ = 0;
        bitField0_ = (bitField0_ & ~0x00000001);
        value_ = com.google.protobuf.ByteString.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000002);
        pid_ = 0;
        bitField0_ = (bitField0_ & ~0x00000004);
        version_ = 0;
        bitField0_ = (bitField0_ & ~0x00000008);
        overloadWaitTime_ = 0;
        bitField0_ = (bitField0_ & ~0x00000010);
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return ca.NetSysLab.ProtocolBuffers.KeyValueResponse.internal_static_KVResponse_descriptor;
      }

      public ca.NetSysLab.ProtocolBuffers.KeyValueResponse.KVResponse getDefaultInstanceForType() {
        return ca.NetSysLab.ProtocolBuffers.KeyValueResponse.KVResponse.getDefaultInstance();
      }

      public ca.NetSysLab.ProtocolBuffers.KeyValueResponse.KVResponse build() {
        ca.NetSysLab.ProtocolBuffers.KeyValueResponse.KVResponse result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public ca.NetSysLab.ProtocolBuffers.KeyValueResponse.KVResponse buildPartial() {
        ca.NetSysLab.ProtocolBuffers.KeyValueResponse.KVResponse result = new ca.NetSysLab.ProtocolBuffers.KeyValueResponse.KVResponse(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.errCode_ = errCode_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.value_ = value_;
        if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
          to_bitField0_ |= 0x00000004;
        }
        result.pid_ = pid_;
        if (((from_bitField0_ & 0x00000008) == 0x00000008)) {
          to_bitField0_ |= 0x00000008;
        }
        result.version_ = version_;
        if (((from_bitField0_ & 0x00000010) == 0x00000010)) {
          to_bitField0_ |= 0x00000010;
        }
        result.overloadWaitTime_ = overloadWaitTime_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof ca.NetSysLab.ProtocolBuffers.KeyValueResponse.KVResponse) {
          return mergeFrom((ca.NetSysLab.ProtocolBuffers.KeyValueResponse.KVResponse)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(ca.NetSysLab.ProtocolBuffers.KeyValueResponse.KVResponse other) {
        if (other == ca.NetSysLab.ProtocolBuffers.KeyValueResponse.KVResponse.getDefaultInstance()) return this;
        if (other.hasErrCode()) {
          setErrCode(other.getErrCode());
        }
        if (other.hasValue()) {
          setValue(other.getValue());
        }
        if (other.hasPid()) {
          setPid(other.getPid());
        }
        if (other.hasVersion()) {
          setVersion(other.getVersion());
        }
        if (other.hasOverloadWaitTime()) {
          setOverloadWaitTime(other.getOverloadWaitTime());
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }

      public final boolean isInitialized() {
        if (!hasErrCode()) {
          
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        ca.NetSysLab.ProtocolBuffers.KeyValueResponse.KVResponse parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (ca.NetSysLab.ProtocolBuffers.KeyValueResponse.KVResponse) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private int errCode_ ;
      /**
       * <code>required uint32 errCode = 1;</code>
       */
      public boolean hasErrCode() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required uint32 errCode = 1;</code>
       */
      public int getErrCode() {
        return errCode_;
      }
      /**
       * <code>required uint32 errCode = 1;</code>
       */
      public Builder setErrCode(int value) {
        bitField0_ |= 0x00000001;
        errCode_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required uint32 errCode = 1;</code>
       */
      public Builder clearErrCode() {
        bitField0_ = (bitField0_ & ~0x00000001);
        errCode_ = 0;
        onChanged();
        return this;
      }

      private com.google.protobuf.ByteString value_ = com.google.protobuf.ByteString.EMPTY;
      /**
       * <code>optional bytes value = 2;</code>
       */
      public boolean hasValue() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <code>optional bytes value = 2;</code>
       */
      public com.google.protobuf.ByteString getValue() {
        return value_;
      }
      /**
       * <code>optional bytes value = 2;</code>
       */
      public Builder setValue(com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        value_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional bytes value = 2;</code>
       */
      public Builder clearValue() {
        bitField0_ = (bitField0_ & ~0x00000002);
        value_ = getDefaultInstance().getValue();
        onChanged();
        return this;
      }

      private int pid_ ;
      /**
       * <code>optional int32 pid = 3;</code>
       */
      public boolean hasPid() {
        return ((bitField0_ & 0x00000004) == 0x00000004);
      }
      /**
       * <code>optional int32 pid = 3;</code>
       */
      public int getPid() {
        return pid_;
      }
      /**
       * <code>optional int32 pid = 3;</code>
       */
      public Builder setPid(int value) {
        bitField0_ |= 0x00000004;
        pid_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional int32 pid = 3;</code>
       */
      public Builder clearPid() {
        bitField0_ = (bitField0_ & ~0x00000004);
        pid_ = 0;
        onChanged();
        return this;
      }

      private int version_ ;
      /**
       * <code>optional int32 version = 4;</code>
       */
      public boolean hasVersion() {
        return ((bitField0_ & 0x00000008) == 0x00000008);
      }
      /**
       * <code>optional int32 version = 4;</code>
       */
      public int getVersion() {
        return version_;
      }
      /**
       * <code>optional int32 version = 4;</code>
       */
      public Builder setVersion(int value) {
        bitField0_ |= 0x00000008;
        version_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional int32 version = 4;</code>
       */
      public Builder clearVersion() {
        bitField0_ = (bitField0_ & ~0x00000008);
        version_ = 0;
        onChanged();
        return this;
      }

      private int overloadWaitTime_ ;
      /**
       * <code>optional int32 overloadWaitTime = 5;</code>
       */
      public boolean hasOverloadWaitTime() {
        return ((bitField0_ & 0x00000010) == 0x00000010);
      }
      /**
       * <code>optional int32 overloadWaitTime = 5;</code>
       */
      public int getOverloadWaitTime() {
        return overloadWaitTime_;
      }
      /**
       * <code>optional int32 overloadWaitTime = 5;</code>
       */
      public Builder setOverloadWaitTime(int value) {
        bitField0_ |= 0x00000010;
        overloadWaitTime_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional int32 overloadWaitTime = 5;</code>
       */
      public Builder clearOverloadWaitTime() {
        bitField0_ = (bitField0_ & ~0x00000010);
        overloadWaitTime_ = 0;
        onChanged();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:KVResponse)
    }

    static {
      defaultInstance = new KVResponse(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:KVResponse)
  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_KVResponse_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_KVResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\026KeyValueResponse.proto\"d\n\nKVResponse\022\017" +
      "\n\007errCode\030\001 \002(\r\022\r\n\005value\030\002 \001(\014\022\013\n\003pid\030\003 " +
      "\001(\005\022\017\n\007version\030\004 \001(\005\022\030\n\020overloadWaitTime" +
      "\030\005 \001(\005B0\n\034ca.NetSysLab.ProtocolBuffersB\020" +
      "KeyValueResponse"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_KVResponse_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_KVResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_KVResponse_descriptor,
        new java.lang.String[] { "ErrCode", "Value", "Pid", "Version", "OverloadWaitTime", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
