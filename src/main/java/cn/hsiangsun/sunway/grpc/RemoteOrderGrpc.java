package cn.hsiangsun.sunway.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: order.proto")
public final class RemoteOrderGrpc {

  private RemoteOrderGrpc() {}

  public static final String SERVICE_NAME = "wallet.RemoteOrder";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<cn.hsiangsun.sunway.grpc.OrderProto.OrderRequest,
      cn.hsiangsun.sunway.grpc.OrderProto.OrderResponse> getPrintOrderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PrintOrder",
      requestType = cn.hsiangsun.sunway.grpc.OrderProto.OrderRequest.class,
      responseType = cn.hsiangsun.sunway.grpc.OrderProto.OrderResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cn.hsiangsun.sunway.grpc.OrderProto.OrderRequest,
      cn.hsiangsun.sunway.grpc.OrderProto.OrderResponse> getPrintOrderMethod() {
    io.grpc.MethodDescriptor<cn.hsiangsun.sunway.grpc.OrderProto.OrderRequest, cn.hsiangsun.sunway.grpc.OrderProto.OrderResponse> getPrintOrderMethod;
    if ((getPrintOrderMethod = RemoteOrderGrpc.getPrintOrderMethod) == null) {
      synchronized (RemoteOrderGrpc.class) {
        if ((getPrintOrderMethod = RemoteOrderGrpc.getPrintOrderMethod) == null) {
          RemoteOrderGrpc.getPrintOrderMethod = getPrintOrderMethod = 
              io.grpc.MethodDescriptor.<cn.hsiangsun.sunway.grpc.OrderProto.OrderRequest, cn.hsiangsun.sunway.grpc.OrderProto.OrderResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "wallet.RemoteOrder", "PrintOrder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.hsiangsun.sunway.grpc.OrderProto.OrderRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.hsiangsun.sunway.grpc.OrderProto.OrderResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new RemoteOrderMethodDescriptorSupplier("PrintOrder"))
                  .build();
          }
        }
     }
     return getPrintOrderMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RemoteOrderStub newStub(io.grpc.Channel channel) {
    return new RemoteOrderStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RemoteOrderBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new RemoteOrderBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RemoteOrderFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new RemoteOrderFutureStub(channel);
  }

  /**
   */
  public static abstract class RemoteOrderImplBase implements io.grpc.BindableService {

    /**
     */
    public void printOrder(cn.hsiangsun.sunway.grpc.OrderProto.OrderRequest request,
        io.grpc.stub.StreamObserver<cn.hsiangsun.sunway.grpc.OrderProto.OrderResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getPrintOrderMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getPrintOrderMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                cn.hsiangsun.sunway.grpc.OrderProto.OrderRequest,
                cn.hsiangsun.sunway.grpc.OrderProto.OrderResponse>(
                  this, METHODID_PRINT_ORDER)))
          .build();
    }
  }

  /**
   */
  public static final class RemoteOrderStub extends io.grpc.stub.AbstractStub<RemoteOrderStub> {
    private RemoteOrderStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RemoteOrderStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RemoteOrderStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RemoteOrderStub(channel, callOptions);
    }

    /**
     */
    public void printOrder(cn.hsiangsun.sunway.grpc.OrderProto.OrderRequest request,
        io.grpc.stub.StreamObserver<cn.hsiangsun.sunway.grpc.OrderProto.OrderResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPrintOrderMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RemoteOrderBlockingStub extends io.grpc.stub.AbstractStub<RemoteOrderBlockingStub> {
    private RemoteOrderBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RemoteOrderBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RemoteOrderBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RemoteOrderBlockingStub(channel, callOptions);
    }

    /**
     */
    public cn.hsiangsun.sunway.grpc.OrderProto.OrderResponse printOrder(cn.hsiangsun.sunway.grpc.OrderProto.OrderRequest request) {
      return blockingUnaryCall(
          getChannel(), getPrintOrderMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RemoteOrderFutureStub extends io.grpc.stub.AbstractStub<RemoteOrderFutureStub> {
    private RemoteOrderFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RemoteOrderFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RemoteOrderFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RemoteOrderFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<cn.hsiangsun.sunway.grpc.OrderProto.OrderResponse> printOrder(
        cn.hsiangsun.sunway.grpc.OrderProto.OrderRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getPrintOrderMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PRINT_ORDER = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RemoteOrderImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RemoteOrderImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PRINT_ORDER:
          serviceImpl.printOrder((cn.hsiangsun.sunway.grpc.OrderProto.OrderRequest) request,
              (io.grpc.stub.StreamObserver<cn.hsiangsun.sunway.grpc.OrderProto.OrderResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class RemoteOrderBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RemoteOrderBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return cn.hsiangsun.sunway.grpc.OrderProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RemoteOrder");
    }
  }

  private static final class RemoteOrderFileDescriptorSupplier
      extends RemoteOrderBaseDescriptorSupplier {
    RemoteOrderFileDescriptorSupplier() {}
  }

  private static final class RemoteOrderMethodDescriptorSupplier
      extends RemoteOrderBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RemoteOrderMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (RemoteOrderGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RemoteOrderFileDescriptorSupplier())
              .addMethod(getPrintOrderMethod())
              .build();
        }
      }
    }
    return result;
  }
}
