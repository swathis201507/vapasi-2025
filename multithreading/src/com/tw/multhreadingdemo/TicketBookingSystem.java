import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

class BookingTask implements Runnable {
    private static final Logger logger = Logger.getLogger(BookingTask.class.getName());
    private final int bookingId;

    public BookingTask(int bookingId) {
        this.bookingId = bookingId;
    }

    public void run() {
        logger.info("Booking received for id: " + bookingId);
        processPayment();
        confirmTicket();
    }

    private void processPayment() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            logger.log(Level.SEVERE, "Payment interrupted for id: " + bookingId, e);
            Thread.currentThread().interrupt(); // Preserve interrupt status
        }
        logger.info("Payment processing for id: " + bookingId);
    }

    private void confirmTicket() {
        logger.info("Ticket confirmed for id: " + bookingId);
    }
}

public class TicketBooking {
    private static final Logger logger = Logger.getLogger(TicketBooking.class.getName());

    public static void main(String[] args) {
        int noOfBookingReq = 5;
        ExecutorService pool = Executors.newFixedThreadPool(3);

        try {
            for (int i = 1; i <= noOfBookingReq; i++) {
                BookingTask t1 = new BookingTask(i);
                pool.execute(t1);
            }
        } finally {
            pool.shutdown();
            logger.info("All booking tasks submitted. Thread pool shutting down.");
        }
    }
}
