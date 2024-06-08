import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class TabbedPane {
    private JTabbedPane tabbedPane1;
    private JPanel mainPanel;
    public JTextField usernameTextField;
    private JPasswordField passwordField;
    private JButton enterButton;
    private JButton goToMenuBarButton;

    public TabbedPane() {
        goToMenuBarButton.setVisible(false);

        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameTextField.getText();
                String password = new String(passwordField.getPassword());

                // Assuming correct username and password are "admin"
                if (username.equals("admin") && password.equals("admin")) {
                    goToMenuBarButton.setVisible(true); // Giriş başarılıysa butonu görünür yap
                } else {
                    JOptionPane.showMessageDialog(mainPanel, "Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        goToMenuBarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuBar menuBar = new MenuBar();
                JFrame menuBarFrame = new JFrame("MenuBar");
                menuBarFrame.setContentPane(menuBar.getMainPanel());
                menuBarFrame.setJMenuBar(menuBar.getMenuBar());
                menuBarFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                menuBarFrame.pack();
                menuBarFrame.setVisible(true);
                menuBarFrame.setSize(250,250);
                menuBarFrame.setMinimumSize(new Dimension(250, 250));
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("TabbedPane");
        frame.setContentPane(new TabbedPane().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(650,500);
        frame.setMinimumSize(new Dimension(650, 500));

    }
}
