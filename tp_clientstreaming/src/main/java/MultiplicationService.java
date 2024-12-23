import g71.stub.MultiplicationGrpc;
import g71.stub.TpStream.*;
import io.grpc.stub.StreamObserver;

public class MultiplicationService extends MultiplicationGrpc.MultiplicationImplBase {

    @Override
    public void getMultiplicationTable(MultiplicationRequest request, StreamObserver<MultiplicationResponse> responseObserver) {
        int nombre = request.getNombre();
        int limite = request.getLimite();
        for (int i = 1; i <= limite; i++) {
            String result = nombre + " x " + i + " = " + (nombre * i);
            MultiplicationResponse response = MultiplicationResponse.newBuilder()
                    .setResultat(result)
                    .build();
            responseObserver.onNext(response);
        }
        responseObserver.onCompleted();
    }
}
