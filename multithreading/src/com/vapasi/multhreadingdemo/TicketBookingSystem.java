package com.vapasi.multhreadingdemo;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Booking implements Runnable {
    private final int bookingId;

    public Booking(int bookingId) {
        this.bookingId = bookingId;
    }

    @Override
    public void run() {
        System.out.println("Booking received for RequestID:" + bookingId);
        System.out.println("Payment processed for RequestID:" + bookingId);
        System.out.println("Ticket confirmed for RequestID:" + bookingId);

    }
}

public class TicketBookingSystem {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(3);

        pool.execute(new Booking(1));
        pool.execute(new Booking(2));
        pool.execute(new Booking(3));
        pool.execute(new Booking(4));
        pool.execute(new Booking(5));
        pool.shutdown();
        ;
    }
}
