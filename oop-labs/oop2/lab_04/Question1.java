import java.util.ArrayList;

public class Question1 {
    public static void main(String[] args) {
        ArrayList<Integer> randomArray = new ArrayList<>();

        // Adding 10 random integers between 10 and 100 to the ArrayList
        for (int i = 0; i < 10; i++) {
            randomArray.add(10 + (int) (Math.random() * 91)); // Generates a random number between 10 and 100
        }

        // Calculating the sum of all elements in the ArrayList
        int sum = 0;
        for (int value : randomArray) {
            sum += value;
        }

        // Displaying the sum
        System.out.println("Sum of all elements: " + sum);

        // Calculating the average of the sum
        double average = (double) sum / randomArray.size();

        // Displaying the average
        System.out.println("Average of the sum: " + average);
    }
}
