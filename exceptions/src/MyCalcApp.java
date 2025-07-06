import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyCalcApp {

    private static final Logger logger = Logger.getLogger(MyCalcApp.class.getName());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calc = new Calculator();

        System.out.print("Enter an integer: ");
        int input = scanner.nextInt();

        try {
            double result = calc.caldouble(input);
            logger.info("Double of the input: " + result);
        } catch (MyArithException e) {
            logger.log(Level.SEVERE, "Error: " + e.getMessage(), e);
        } finally {
            scanner.close();
            logger.info("Scanner closed, application ended.");
        }
    }
}
