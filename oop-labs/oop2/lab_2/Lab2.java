import java.util.Scanner;

public class Lab2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first sentence: ");
        String FirstText = scanner.nextLine();
        System.out.print("Enter the second sentence to concat and compare: ");
        String SecondText = scanner.nextLine();

        if (FirstText.length() < 100) {
            System.out.println("The first text must be at least 100 characters. ");
        } else {
            System.out.println("The first text: " + FirstText);
            System.out.println("The second text: " + SecondText);

            System.out.println("The length of the first text: " + FirstText.length());

            System.out.println("The Index of 'i': " + FirstText.indexOf("i"));
            System.out.println("The Last Index of 'i': " + FirstText.lastIndexOf("i"));

            System.out.println("Char at index 10: " + FirstText.charAt(10));

            System.out.println("Upper-cased text: " + FirstText.toUpperCase());
            System.out.println("Lower-cased text: " + FirstText.toLowerCase());

            System.out.println("Sentences are equal? " + FirstText.equals(SecondText));

            System.out.println("Substring: " + FirstText.substring(0, 7));

            System.out.println("Concatted text: " + (FirstText.trim()).concat(SecondText));

            String[] FirstTextArr = FirstText.split(" ");
            System.out.println("Words of the first text:");
            for (String word : FirstTextArr) {
                System.out.println(word);
            }

        }
        scanner.close();
    }
}
