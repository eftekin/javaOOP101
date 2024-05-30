import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberDisplayForm {
    private JPanel panel;
    private JTextArea textArea;
    private JRadioButton multiplesOf3And5RadioButton;
    private JRadioButton primeNumbersRadioButton;
    private JButton showButton;

    public NumberDisplayForm() {
        // Radio button group
        ButtonGroup group = new ButtonGroup();
        group.add(multiplesOf3And5RadioButton);
        group.add(primeNumbersRadioButton);

        // Button action listener
        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(""); // Clear text area
                if(multiplesOf3And5RadioButton.isSelected()){
                    displayPrimeNumbers();
                }
            }
        });
    }

    private void displayMultiplesOf3And5() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                sb.append(i).append(" ");
            }
        }
        textArea.setText(sb.toString());
    }

    private void displayPrimeNumbers() {
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= 100; i++) {
            if (isPrime(i)) {
                sb.append(i).append(" ");
            }
        }
        textArea.setText(sb.toString());
    }

    private boolean isPrime(int number) {
        if (number < 2) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Number Display Form");
        frame.setContentPane(new NumberDisplayForm().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
