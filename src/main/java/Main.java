import cn.hsiangsun.sunway.service.OrderService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(7777).addService(new OrderService()).build();
        server.start();

        System.out.println("server started....");

        server.awaitTermination();
    }
}
