import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class ArrayListLab {

    public static void main(String[] args) {
        // initialize the necessary classes
        ArrayList<Integer> myList = new ArrayList<>();
        ArrayList<Integer> oddList = new ArrayList<>();
        ArrayList<Integer> evenList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // add 100 random rumbers into the ArrayList
        for (int i = 0; i < 100; i++) {
            myList.add(random.nextInt(100) + 1);
        }

        // print unsorted ArrayList
        System.out.println("The list with random numbers (1-100)");
        System.out.println(myList);

        // sort and print the sorted ArrayList
        Collections.sort(myList);
        System.out.println("\n\nSorted list ");
        System.out.println(myList);

        // take int from user to search in the list
        System.out.print("\nEnter a number to search for: ");
        int num = scanner.nextInt();

        // get evenList, oddList and the num to search
        int evenCounter = 0;
        int oddCounter = 0;
        int counter = 0;
        for (int i = 0; i < myList.size(); i++) {
            if (myList.get(i) % 2 == 0) {
                evenList.add(myList.get(i));
                evenCounter++;
            } else {
                oddList.add(myList.get(i));
                oddCounter++;
            }
            if (myList.get(i) == num) {
                counter++;
            }

        }

        // print even and odd numbers
        System.out.println(evenCounter + " even numbers in the list: " + evenList + "\n");
        System.out.println(oddCounter + " odd number s in the list: " + oddList + "\n");

        // print how many times the number repeated
        System.out.println("The number " + "(" + num + ")" + " occured " + counter + " times in the ArrayList.");
    }

}
