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

            String choice = "";
            boolean valid = false;

            do {

                valid = true;

                System.out.println();

                System.out.println("1. Consulta i posti disponibili");
                System.out.println("2. Prenota posti");
                System.out.println("3. Annulla posti");
                System.out.println("0. Esci");
                System.out.print("Choice: ");
                choice = scanner.nextLine();

                System.out.println();

                switch (choice.trim()) {
                    case "1":
                        out.println("DISPONIBILI");
                       break;
                    case "2":
                        System.out.print("Inserisci il numero di posti da prenotare: ");
                        String np = scanner.nextLine();
                        out.println("PRENOTA " + np);
                        break;
                    case "3":
                        System.out.print("Inserisci il numero di posti da annullare: ");
                        String na = scanner.nextLine();
                        out.println("ANNULLA " + na);
                        break;
                    case "0":
                        out.println("ESCI");
                        break;
                    default:
                        System.out.println("L'opzione " + choice + " non è disponibile");
                        valid = false;
                        break;
                }

                if (valid) System.out.println(in.readLine());

            } while (!choice.trim().equals("0"));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
