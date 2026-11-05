package com.xztl.socketshow;

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

}
