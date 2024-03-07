// Define an array in which you give the value received from user as a dimension.
// Assign random values between 10 and 100 to this array using the for loop and print it on the screen
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(91) + 10; // Random value between 10 and 100
        }

        System.out.println("Array values:");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
