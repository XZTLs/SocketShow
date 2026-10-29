package com.xztl.socketshow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public Client(String host, int port) {

        System.out.println("Started client on: " + host + ":" + port);

        try (
                Socket socket = new Socket(host, port);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));

                PrintWriter out = new PrintWriter(
                        socket.getOutputStream(), true);
                Scanner scanner = new Scanner(System.in);
        ) {

            String input = scanner.nextLine();

            out.println(input);

            System.out.println(in.readLine());

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}
