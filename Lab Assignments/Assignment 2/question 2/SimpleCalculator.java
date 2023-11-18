import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first value: ");
        double value1 = scanner.nextDouble();

        System.out.print("Enter the second value: ");
        double value2 = scanner.nextDouble();

        System.out.println("Select the operation:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");

        int operation = scanner.nextInt();

        double result = 0;

        switch (operation) {
            case 1:
                result = value1 + value2;
                break;
            case 2:
                result = value1 - value2;
                break;
            case 3:
                result = value1 * value2;
                break;
            case 4:
                if (value2 != 0) {
                    result = value1 / value2;
                } else {
                    System.out.println("Error: Division by zero is not allowed");
                    return;
                }
                break;
            default:
                System.out.println("Error: Invalid operation");
                return;
        }

        System.out.println("Result: " + result);

        scanner.close();
    }
}
