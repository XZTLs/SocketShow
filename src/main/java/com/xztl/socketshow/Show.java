package com.xztl.socketshow;

import java.util.concurrent.locks.ReentrantLock;

public class Show {
    private final ReentrantLock lock = new ReentrantLock();

    private final int MAX_SEATS = 30;
    private int seats;

    public Show() {
        this.seats = MAX_SEATS;
    }

    public int getMaxSeats() { return this.MAX_SEATS; }
    public int getSeats() {
        lock.lock();
        try {
            return this.seats;
        } finally {
            lock.unlock();
        }
    }
    
    private void increase(int n) { this.seats += n; }
    private void decrease(int n) { this.seats -= n; }

    public boolean book(int q) throws NegativeValueException {
        lock.lock();

        try {
            if (q < 0) throw new NegativeValueException();
            if (q > this.seats) return false;

            decrease(q);
            return true;
        } finally {
            lock.unlock();
        }
    }

    public boolean cancel(int q) throws NegativeValueException {
        lock.lock();

        try {
            if (q < 0) throw new NegativeValueException();
            if ((seats + q) > this.MAX_SEATS) return false;

            increase(q);
            return true;
        } finally {
            lock.unlock();
        }
    }
}
