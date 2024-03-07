package Assignment;

import java.util.Scanner;

public class question5 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the first integer: ");
		int num1 = scanner.nextInt();
		System.out.print("Enter the second integer:");
		int num2 = scanner.nextInt();
		
		if ((3*num1) % (2*num2) == 0) {
            System.out.println("3 times the first number is a multiple of 2 times the second number.");
		}
		else {
            System.out.println("3 times the first number is not a multiple of 2 times the second number.");
		}
		
		scanner.close();
	}

}
