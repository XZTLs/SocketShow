package com.xztl.socketshow;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {

    Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        
        try (
            BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));

            PrintWriter out = new PrintWriter(
                        socket.getOutputStream(), true);
        ) {
            
        } catch (Exception e) {
            
        }
        
    }

}
