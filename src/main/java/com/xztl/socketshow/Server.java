package com.xztl.socketshow;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    Show show = new Show();

    public Server(int port) {

        ExecutorService pool = Executors.newFixedThreadPool(show.getMaxSeats());

        try (
            ServerSocket serverSocket = new ServerSocket(port);
        ) {
            System.out.println("Started server on port: " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Connected client: " + socket.getInetAddress());

                ClientHandler client = new ClientHandler(socket, show);
                pool.execute(client);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            pool.shutdown();
        }

    }

}
