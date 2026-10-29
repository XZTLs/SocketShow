package com.xztl.socketshow;

import java.io.BufferedReader;
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
        
        String command = "";

        try (
            BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));

            PrintWriter out = new PrintWriter(
                        socket.getOutputStream(), true);
        ) {

            while (command != null && !command.equals("ESCI")) {
                
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
