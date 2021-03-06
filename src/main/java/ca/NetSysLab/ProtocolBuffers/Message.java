// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Message.proto

package ca.NetSysLab.ProtocolBuffers;

public final class Message {
  private Message() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface MsgOrBuilder extends
      // @@protoc_insertion_point(interface_extends:Msg)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>required bytes messageID = 1;</code>
     */
    boolean hasMessageID();
    /**
     * <code>required bytes messageID = 1;</code>
     */
    com.google.protobuf.ByteString getMessageID();

    /**
     * <code>required bytes payload = 2;</code>
     */
    boolean hasPayload();
    /**
     * <code>required bytes payload = 2;</code>
     */
    com.google.protobuf.ByteString getPayload();

    /**
     * <code>required fixed64 checkSum = 3;</code>
     */
    boolean hasCheckSum();
    /**
     * <code>required fixed64 checkSum = 3;</code>
     */
    long getCheckSum();
  }
  /**
   * Protobuf type {@code Msg}
   */
  public static final class Msg extends
      com.google.protobuf.GeneratedMessage implements
      // @@protoc_insertion_point(message_implements:Msg)
      MsgOrBuilder {
    // Use Msg.newBuilder() to construct.
    private Msg(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    private Msg(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    private static final Msg defaultInstance;
    public static Msg getDefaultInstance() {
      return defaultInstance;
    }

    public Msg getDefaultInstanceForType() {
      return defaultInstance;
    }

    private final com.google.protobuf.UnknownFieldSet unknownFields;
    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    private Msg(
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
            case 10: {
              bitField0_ |= 0x00000001;
              messageID_ = input.readBytes();
              break;
            }
            case 18: {
              bitField0_ |= 0x00000002;
              payload_ = input.readBytes();
              break;
            }
            case 25: {
              bitField0_ |= 0x00000004;
              checkSum_ = input.readFixed64();
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
      return ca.NetSysLab.ProtocolBuffers.Message.internal_static_Msg_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ca.NetSysLab.ProtocolBuffers.Message.internal_static_Msg_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ca.NetSysLab.ProtocolBuffers.Message.Msg.class, ca.NetSysLab.ProtocolBuffers.Message.Msg.Builder.class);
    }

    public static com.google.protobuf.Parser<Msg> PARSER =
        new com.google.protobuf.AbstractParser<Msg>() {
      public Msg parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new Msg(input, extensionRegistry);
      }
    };

    @java.lang.Override
    public com.google.protobuf.Parser<Msg> getParserForType() {
      return PARSER;
    }

    private int bitField0_;
    public static final int MESSAGEID_FIELD_NUMBER = 1;
    private com.google.protobuf.ByteString messageID_;
    /**
     * <code>required bytes messageID = 1;</code>
     */
    public boolean hasMessageID() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required bytes messageID = 1;</code>
     */
    public com.google.protobuf.ByteString getMessageID() {
      return messageID_;
    }

    public static final int PAYLOAD_FIELD_NUMBER = 2;
    private com.google.protobuf.ByteString payload_;
    /**
     * <code>required bytes payload = 2;</code>
     */
    public boolean hasPayload() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>required bytes payload = 2;</code>
     */
    public com.google.protobuf.ByteString getPayload() {
      return payload_;
    }

    public static final int CHECKSUM_FIELD_NUMBER = 3;
    private long checkSum_;
    /**
     * <code>required fixed64 checkSum = 3;</code>
     */
    public boolean hasCheckSum() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>required fixed64 checkSum = 3;</code>
     */
    public long getCheckSum() {
      return checkSum_;
    }

    private void initFields() {
      messageID_ = com.google.protobuf.ByteString.EMPTY;
      payload_ = com.google.protobuf.ByteString.EMPTY;
      checkSum_ = 0L;
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      if (!hasMessageID()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasPayload()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasCheckSum()) {
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
        output.writeBytes(1, messageID_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeBytes(2, payload_);
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        output.writeFixed64(3, checkSum_);
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
          .computeBytesSize(1, messageID_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(2, payload_);
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        size += com.google.protobuf.CodedOutputStream
          .computeFixed64Size(3, checkSum_);
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

    public static ca.NetSysLab.ProtocolBuffers.Message.Msg parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static ca.NetSysLab.ProtocolBuffers.Message.Msg parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static ca.NetSysLab.ProtocolBuffers.Message.Msg parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static ca.NetSysLab.ProtocolBuffers.Message.Msg parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static ca.NetSysLab.ProtocolBuffers.Message.Msg parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static ca.NetSysLab.ProtocolBuffers.Message.Msg parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static ca.NetSysLab.ProtocolBuffers.Message.Msg parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static ca.NetSysLab.ProtocolBuffers.Message.Msg parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static ca.NetSysLab.ProtocolBuffers.Message.Msg parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static ca.NetSysLab.ProtocolBuffers.Message.Msg parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(ca.NetSysLab.ProtocolBuffers.Message.Msg prototype) {
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
     * Protobuf type {@code Msg}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:Msg)
        ca.NetSysLab.ProtocolBuffers.Message.MsgOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return ca.NetSysLab.ProtocolBuffers.Message.internal_static_Msg_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return ca.NetSysLab.ProtocolBuffers.Message.internal_static_Msg_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                ca.NetSysLab.ProtocolBuffers.Message.Msg.class, ca.NetSysLab.ProtocolBuffers.Message.Msg.Builder.class);
      }

      // Construct using ca.NetSysLab.ProtocolBuffers.Message.Msg.newBuilder()
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
        messageID_ = com.google.protobuf.ByteString.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000001);
        payload_ = com.google.protobuf.ByteString.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000002);
        checkSum_ = 0L;
        bitField0_ = (bitField0_ & ~0x00000004);
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return ca.NetSysLab.ProtocolBuffers.Message.internal_static_Msg_descriptor;
      }

      public ca.NetSysLab.ProtocolBuffers.Message.Msg getDefaultInstanceForType() {
        return ca.NetSysLab.ProtocolBuffers.Message.Msg.getDefaultInstance();
      }

      public ca.NetSysLab.ProtocolBuffers.Message.Msg build() {
        ca.NetSysLab.ProtocolBuffers.Message.Msg result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public ca.NetSysLab.ProtocolBuffers.Message.Msg buildPartial() {
        ca.NetSysLab.ProtocolBuffers.Message.Msg result = new ca.NetSysLab.ProtocolBuffers.Message.Msg(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.messageID_ = messageID_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.payload_ = payload_;
        if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
          to_bitField0_ |= 0x00000004;
        }
        result.checkSum_ = checkSum_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof ca.NetSysLab.ProtocolBuffers.Message.Msg) {
          return mergeFrom((ca.NetSysLab.ProtocolBuffers.Message.Msg)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(ca.NetSysLab.ProtocolBuffers.Message.Msg other) {
        if (other == ca.NetSysLab.ProtocolBuffers.Message.Msg.getDefaultInstance()) return this;
        if (other.hasMessageID()) {
          setMessageID(other.getMessageID());
        }
        if (other.hasPayload()) {
          setPayload(other.getPayload());
        }
        if (other.hasCheckSum()) {
          setCheckSum(other.getCheckSum());
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }

      public final boolean isInitialized() {
        if (!hasMessageID()) {
          
          return false;
        }
        if (!hasPayload()) {
          
          return false;
        }
        if (!hasCheckSum()) {
          
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        ca.NetSysLab.ProtocolBuffers.Message.Msg parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (ca.NetSysLab.ProtocolBuffers.Message.Msg) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private com.google.protobuf.ByteString messageID_ = com.google.protobuf.ByteString.EMPTY;
      /**
       * <code>required bytes messageID = 1;</code>
       */
      public boolean hasMessageID() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required bytes messageID = 1;</code>
       */
      public com.google.protobuf.ByteString getMessageID() {
        return messageID_;
      }
      /**
       * <code>required bytes messageID = 1;</code>
       */
      public Builder setMessageID(com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        messageID_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required bytes messageID = 1;</code>
       */
      public Builder clearMessageID() {
        bitField0_ = (bitField0_ & ~0x00000001);
        messageID_ = getDefaultInstance().getMessageID();
        onChanged();
        return this;
      }

      private com.google.protobuf.ByteString payload_ = com.google.protobuf.ByteString.EMPTY;
      /**
       * <code>required bytes payload = 2;</code>
       */
      public boolean hasPayload() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <code>required bytes payload = 2;</code>
       */
      public com.google.protobuf.ByteString getPayload() {
        return payload_;
      }
      /**
       * <code>required bytes payload = 2;</code>
       */
      public Builder setPayload(com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        payload_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required bytes payload = 2;</code>
       */
      public Builder clearPayload() {
        bitField0_ = (bitField0_ & ~0x00000002);
        payload_ = getDefaultInstance().getPayload();
        onChanged();
        return this;
      }

      private long checkSum_ ;
      /**
       * <code>required fixed64 checkSum = 3;</code>
       */
      public boolean hasCheckSum() {
        return ((bitField0_ & 0x00000004) == 0x00000004);
      }
      /**
       * <code>required fixed64 checkSum = 3;</code>
       */
      public long getCheckSum() {
        return checkSum_;
      }
      /**
       * <code>required fixed64 checkSum = 3;</code>
       */
      public Builder setCheckSum(long value) {
        bitField0_ |= 0x00000004;
        checkSum_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required fixed64 checkSum = 3;</code>
       */
      public Builder clearCheckSum() {
        bitField0_ = (bitField0_ & ~0x00000004);
        checkSum_ = 0L;
        onChanged();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:Msg)
    }

    static {
      defaultInstance = new Msg(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:Msg)
  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Msg_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_Msg_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\rMessage.proto\";\n\003Msg\022\021\n\tmessageID\030\001 \002(" +
      "\014\022\017\n\007payload\030\002 \002(\014\022\020\n\010checkSum\030\003 \002(\006B\'\n\034" +
      "ca.NetSysLab.ProtocolBuffersB\007Message"
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
    internal_static_Msg_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Msg_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_Msg_descriptor,
        new java.lang.String[] { "MessageID", "Payload", "CheckSum", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
