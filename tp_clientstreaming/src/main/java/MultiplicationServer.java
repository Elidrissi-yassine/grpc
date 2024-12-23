import g71.stub.TpStream;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import static java.lang.Thread.sleep;

public class MultiplicationServer {
    public static void main(String[] args) throws Exception{
        Server server= ServerBuilder.forPort(9096).addService(new MultiplicationService()).build();
        server.start();

        System.out.println("Server started");
        server.awaitTermination();
    }
}
