package mustafaeftekin;

public class Faculty {
    public void displayDepartment(String department) {
        if (department.equals("CEN")) {
            System.out.println("You are directed to the Department of Computer Engineering");
        } else if (department.equals("SEN")) {
            System.out.println("You are directed to the Department of Software Engineering");
        } else {
            System.out.println("You are directed to the Faculty Secretariat");
        }
    }
}
