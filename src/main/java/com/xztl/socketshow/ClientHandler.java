package com.xztl.socketshow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {

    Socket socket;
    Show show;

    public ClientHandler(Socket socket, Show show) {
        this.socket = socket;
    }

    @Override
    public void run() {
        
        Command cmd = new Command();

        try (
            BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));

            PrintWriter out = new PrintWriter(
                        socket.getOutputStream(), true);
        ) {

            try {
                
                while (!cmd.canExit()) {
                
                cmd.sanitize(in.readLine());

            }

            } catch (IOException e) {
                out.println("ERRORE;Sintassi non valida");
            }
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
