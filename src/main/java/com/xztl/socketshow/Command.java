package com.xztl.socketshow;

import java.io.IOException;

public class Command {
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

    public boolean canExit() { return this.cmd.equals("ESCI"); }

    public String[] sanitize(String c) throws IOException {
        if (c.isEmpty() || c == null) throw new IOException();

        String[] cmd = c.trim().split(" ");

        return cmd;
    }
}
