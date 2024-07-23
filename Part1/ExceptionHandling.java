package Part1;

import java.util.Scanner;

public class ExceptionHandling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {

            System.out.print("Enter a number to divide: ");
            int userNumber = scanner.nextInt();


            int result = 10 / userNumber;
            System.out.println("Result: 10 / " + userNumber + " = " + result);
        } catch (ArithmeticException e) {

            System.out.println("Error: Division by zero is not allowed.");
        } catch (Exception e) {

            System.out.println("Error: An unexpected error occurred. " + e.getMessage());
        } finally {

            scanner.close();
            System.out.println("Cleanup: Scanner resource closed.");
        }
    }
}
