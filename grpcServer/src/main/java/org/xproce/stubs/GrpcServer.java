package org.xproce.stubs;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.xproce.stubs.BankGrpcService;
import java.io.IOException;

public class GrpcServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Création du serveur sur le port 5555
        Server server = ServerBuilder.forPort(5555)
                .addService(new BankGrpcService())
                .build();

        // Démarrage du serveur
        server.start();
        System.out.println("gRPC Server started on port 5555...");

        // Attend la terminaison du serveur
        server.awaitTermination();
    }
}
