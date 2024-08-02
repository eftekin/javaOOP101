package mustafaeftekin;

public class Student {
    private long studentId;
    private String name;
    private String surname;

    public Student(long studentId, String name, String surname) {
        this.studentId = studentId;
        this.name = name;
        this.surname = surname;
    }

    public void displayStudentInfo() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Surname: " + surname);
    }
}
