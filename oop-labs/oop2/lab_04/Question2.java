import java.util.*;

public class Question2 {
    public static void addListToHashSet(List<Integer> list, Set<Integer> hashSet) {
        // Adding elements of the list to the HashSet
        for (Integer value : list) {
            hashSet.add(value);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        // Adding 5 values to the list
        System.out.println("Enter 5 values:");
        for (int i = 0; i < 5; i++) {
            int value = scanner.nextInt();
            list.add(value);
        }

        // Displaying the list
        System.out.println("List: " + list);

        // Creating a HashSet
        Set<Integer> hashSet = new HashSet<>();
        addListToHashSet(list, hashSet);

        // Displaying the HashSet
        System.out.println("HashSet: " + hashSet);
    }
}
