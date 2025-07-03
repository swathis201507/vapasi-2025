import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class BookingTask implements Runnable {
    private final int bookingId;

    public BookingTask(int bookingId) {
        this.bookingId = bookingId;
    }

    public void run() {
        System.out.println("Booking received for id: " + bookingId);
        processPayment();
        confirmTicket();
    }

    private void processPayment() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
        System.out.println("Payment processing for id: " + bookingId);
    }

    private void confirmTicket() {
        System.out.println("Ticket confirmed for id: " + bookingId);
    }
}

public class TicketBooking {
    public static void main(String[] args) {
        int noOfBookingReq = 5;
        try (ExecutorService pool = Executors.newFixedThreadPool(3)) {

            for (int i = 1; i <= noOfBookingReq; i++) {
                BookingTask t1 = new BookingTask(i);
                pool.execute(t1);
            }

            pool.shutdown();
        }
    }
}
