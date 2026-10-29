package com.xztl.socketshow;

public class ClientMain {
    public static void main(String[] args) {
        final String HOST = "localhost";
        final int PORT = 12345;

        new Client(HOST, PORT);
    }
}