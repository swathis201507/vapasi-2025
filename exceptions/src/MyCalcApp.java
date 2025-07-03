import java.util.Scanner;

public class MyCalcApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calc = new Calculator();

        System.out.print("Enter an integer: ");
        int input = scanner.nextInt();

        try {
            double result = calc.caldouble(input);
            System.out.println("Double of the input: " + result);
        } catch (MyArithException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
