package com.xztl.socketshow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public Client(String host, int port) {

        try (
                Socket socket = new Socket(host, port);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));

                PrintWriter out = new PrintWriter(
                        socket.getOutputStream(), true);) {

            

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}
