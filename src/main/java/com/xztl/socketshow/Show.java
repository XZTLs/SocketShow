package com.xztl.socketshow;

public class Show {
    private final int MAX_SEATS = 30;
    private int seats;

    public Show() {
        this.seats = MAX_SEATS;
    }

    public int getMaxSeats() { return this.MAX_SEATS; }
    public int getSeats() { return this.seats; }
    
    public void setSeats(int seats) { this.seats = seats; }

    public void increase() { this.seats += 1; }
    public void increase(int n) { this.seats += n; }

    public void decrease() { this.seats -= 1; }
    public void decrease(int n) { this.seats -= n; }
}
