import g71.stub.SalutationGrpc;
import g71.stub.TpStream.*;
import io.grpc.ServerServiceDefinition;
import io.grpc.stub.StreamObserver;

public class MessageService extends SalutationGrpc.SalutationImplBase {


    @Override
    public StreamObserver<NomRequest> message(StreamObserver<NomResponse> responseObserver) {
        return new StreamObserver<>(){
            StringBuilder names = new StringBuilder();
            @Override
            public void onNext(NomRequest request) {
// Traite chaque message envoyé par le client
                names.append(request.getNom()).append(", ");
            }
            @Override
            public void onError(Throwable t) {
                System.err.println("Erreur reçue : " + t.getMessage());
            }
            @Override
            public void onCompleted() {
// Envoie une réponse au client une fois que tous les messages sont reçus
                String responseMessage = "Salut à tous : " + names.toString();
                NomResponse response = NomResponse.newBuilder()
                        .setMessage(responseMessage)
                        .build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }
        };
    }
}
