import javax.swing.*;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        HashMap<String, Operation> operationMap = new HashMap<>();
        operationMap.put("+", (num1, num2) -> num1 + num2);
        operationMap.put("-", (num1, num2) -> num1 - num2);
        operationMap.put("*", (num1, num2) -> num1 * num2);
        operationMap.put("/", (num1, num2) -> {
            if (num2 == 0) {
                throw new ArithmeticException("Division by zero!");
            }
            return num1 / num2;
        });

        double result;
        try {
            double num1 = Double.parseDouble(JOptionPane.showInputDialog("Enter the first number:"));
            String operation = JOptionPane.showInputDialog("Enter the operation (+, -, *, /):");
            double num2 = Double.parseDouble(JOptionPane.showInputDialog("Enter the second number:"));

            if (!operationMap.containsKey(operation)) {
                throw new IllegalArgumentException("Invalid operation!");
            }

            result = operationMap.get(operation).apply(num1, num2);
            JOptionPane.showMessageDialog(null, "Result: " + result, "Result", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid number.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ArithmeticException e) {
            JOptionPane.showMessageDialog(null, "Division by zero is not allowed!",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Invalid operation! Please enter a valid operation (+, -, *, /).",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    interface Operation {
        double apply(double num1, double num2);
    }
}
