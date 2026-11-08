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
        this.show = show;
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
            do {
                try {
                    cmd.insert(in.readLine());

                    switch (cmd.getCommand()) {
                        case "DISPONIBILI":
                            out.println("OK;Posti disponibili: " + show.getSeats());
                            break;
                        case "PRENOTA":
                            boolean bp = show.book(cmd.getValue());
                            out.println(bp ? "OK;Prenotazione effettuata;Disponibili " + show.getSeats() : "ERRORE;Posti insufficienti;Disponibili: " + show.getSeats());
                            break;
                        case "ANNULLA":
                            boolean ba = show.cancel(cmd.getValue());
                            out.println(ba ? "OK;Annullamento effettuato;Disponibili: " + show.getSeats() : "ERRORE;Annullamento non consentito;Disponibili: " + show.getSeats());
                            break;
                        case "ESCI":
                            out.println("OK;Connessione in chiusura");
                            break;
                    }
                } catch (InvalidSyntaxException e) {
                    out.println("ERRORE;Sintassi non valida");
                } catch (InvalidQuantityException e) {
                    out.println("ERRORE;Quantità non valida");
                } catch (UnrecognizedCommandException e) {
                    out.println("ERRORE;Comando sconosciuto");
                } catch (NegativeValueException e) {
                    out.println("ERRORE;La quantità deve essere positiva");
                }
            } while (!cmd.canExit());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
