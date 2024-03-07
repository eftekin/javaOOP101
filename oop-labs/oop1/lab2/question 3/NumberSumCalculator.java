import java.util.Scanner;

public class NumberSumCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of numbers to sum: ");
        int numberOfNumbers = scanner.nextInt();

        double sum = 0;

        int count = 0;
        do {
            System.out.print("Enter a number: ");
            double currentNumber = scanner.nextDouble();

            sum += currentNumber;
            count++;
        } while (count < numberOfNumbers);

        System.out.println("Sum of the entered numbers: " + sum);

        scanner.close();
    }
}
