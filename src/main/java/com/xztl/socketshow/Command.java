package com.xztl.socketshow;

import java.util.HashMap;
import java.util.Map;

public class Command {
    private final Map<String, Integer> valid = new HashMap<>(Map.of(
            "DISPONIBILI", 1,
            "PRENOTA", 2,
            "ANNULLA", 2,
            "ESCI", 1
    ));

    private String cmd;
    private String val;

    public Command() {
        this.cmd = "";
        this.val = "";
    }

    public Command(String cmd, String val) {
        this.cmd = cmd;
        this.val = val;
    }

    public String getCommand() { return this.cmd; }
    public int getValue() { return Integer.parseInt(this.val); }

    public boolean canExit() { return this.cmd.equals("ESCI"); }

    private String[] sanitize(String command) throws InvalidSyntaxException, InvalidQuantityException, UnrecognizedCommandException {
        if (command == null) throw new InvalidSyntaxException();
        if (command.isEmpty()) throw new InvalidSyntaxException();

        String[] c = command.trim().split("\\s+");
        if (!valid.containsKey(c[0])) throw new UnrecognizedCommandException();
        if (c.length != valid.get(c[0])) throw new InvalidSyntaxException();
        if (c.length == 2) try { Integer.parseInt(c[1]); } catch(Exception e) { throw new InvalidQuantityException(); }

        return c;
    }

    public void insert(String command) throws InvalidSyntaxException, UnrecognizedCommandException, InvalidQuantityException {
        String[] c = sanitize(command);

        this.cmd = c[0];
        this.val = (c.length > 1) ? c[1] : "";
    }
}
