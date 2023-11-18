import java.util.Scanner;

public class FactorialCalculator {

    public static int calculateFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * calculateFactorial(n - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a non-negative integer: ");
        int inputValue = scanner.nextInt();

        if (inputValue < 0) {
            System.out.println("Error: Negative input is not allowed");
        } else {
            int result = calculateFactorial(inputValue);

            System.out.println("Factorial of " + inputValue + " is: " + result);
        }

        scanner.close();
    }

}
