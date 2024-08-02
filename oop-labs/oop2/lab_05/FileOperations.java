import java.io.*;
import java.util.Scanner;

public class FileOperations {

    private static File getFile() {
        return new File(System.getProperty("user.dir") + "/myFile.txt");
    }

    private static void createTextFile() {
        File file = getFile();

        try {
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getAbsolutePath());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeToFile() {
        File file = getFile();

        try {
            FileWriter fileWriter = new FileWriter(file, true);
            Scanner scanner = new Scanner(System.in);
            System.out.print("Please enter some text: ");
            String input = scanner.nextLine();
            fileWriter.write(input);
            fileWriter.close();
            System.out.println("Data written to file: " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readTextFile() {
        File file = new File("myFile.txt");

        try {
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println("Content of the file: " + data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getAbsolutePath());
        }
    }

    private static void listFileInfo() {
        File file = getFile();

        System.out.println("Information about the file:");
        System.out.println("File name: " + file.getName());
        System.out.println("File path: " + file.getAbsolutePath());
        System.out.println("File size: " + file.length() + " bytes");
        System.out.println("Is file writable? " + file.canWrite());
        System.out.println("Is file readable? " + file.canRead());
    }

    private static void deleteFile() {
        File file = getFile();

        if (file.delete()) {
            System.out.println("File deleted: " + file.getAbsolutePath());
        } else {
            System.out.println("File could not be deleted.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("What operation would you like to perform?");
            System.out.println("1. Create a text file in the folder where the Java file is located");
            System.out.println("2. Write to the text file");
            System.out.println("3. Read the contents of the text file");
            System.out.println("4. List all information about the text file");
            System.out.println("5. Delete the text file");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createTextFile();
                    break;
                case 2:
                    writeToFile();
                    break;
                case 3:
                    readTextFile();
                    break;
                case 4:
                    listFileInfo();
                    break;
                case 5:
                    deleteFile();
                    break;
                case 6:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid operation.");
            }
        } while (choice != 6);
    }
}