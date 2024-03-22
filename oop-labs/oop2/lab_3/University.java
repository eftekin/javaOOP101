import mustafaeftekin.Faculty;
import mustafaeftekin.Student;
import java.util.Scanner;

public class University {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student ID: ");
        long studentId = Long.parseLong(scanner.next());

        System.out.print("Enter student name: ");
        String name = scanner.next();

        System.out.print("Enter student surname: ");
        String surname = scanner.next();

        Student student = new Student(studentId, name, surname);
        student.displayStudentInfo();

        System.out.print("Enter department (CEN/SEN/others): ");
        String department = scanner.next();

        Faculty faculty = new Faculty();
        faculty.displayDepartment(department);

        scanner.close();
    }
}
