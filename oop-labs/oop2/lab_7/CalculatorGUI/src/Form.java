import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Form extends JPanel {
    private JPanel Calculator;
    private JTextField operation;
    private JTextField num1;
    private JTextField num2;
    private JButton calculate;
    private JFormattedTextField result;

    public Form() {
        add(Calculator);

        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String op = operation.getText();
                    double number1 = Double.parseDouble(num1.getText());
                    double number2 = Double.parseDouble(num2.getText());

                    double res = 0;
                    switch (op) {
                        case "+":
                            res = number1 + number2;
                            break;
                        case "-":
                            res = number1 - number2;
                            break;
                        case "*":
                            res = number1 * number2;
                            break;
                        case "/":
                            if (number2 == 0) {
                                throw new ArithmeticException("Division by zero!");
                            }
                            res = number1 / number2;
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid operation!");
                    }

                    result.setValue(res);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid number format!", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (ArithmeticException ex) {
                    JOptionPane.showMessageDialog(null, "Division by zero is not allowed!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid operation!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Form().Calculator);
        frame.pack();
        frame.setVisible(true);
    }
}
