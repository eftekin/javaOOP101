import javax.swing.*;
import java.awt.*;

public class JListGUI {
    private JList<String> list1;
    private JList<String> list2;
    private JPanel mainPanel;
    private JButton removeFromListButton;
    private JButton addToListButton;
    private JTextField courseTextField;
    private final DefaultListModel<String> list1Model;
    private final DefaultListModel<String> list2Model;

    public JListGUI() {
        list1Model = new DefaultListModel<>();
        list2Model = new DefaultListModel<>();
        list1.setModel(list1Model);
        list2.setModel(list2Model);

        addToListButton.addActionListener(e -> {
            String courseName = courseTextField.getText().trim();
            if (!courseName.isEmpty()) {
                list1Model.addElement(courseName);
                courseTextField.setText("");
            }
        });

        removeFromListButton.addActionListener(e -> {
            String selectedCourse = list1.getSelectedValue();
            if (selectedCourse != null) {
                list1Model.removeElement(selectedCourse);
                list2Model.addElement(selectedCourse);
                list1.setBackground(Color.RED);
                list2.setBackground(Color.GREEN);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("JList App");
        JListGUI jListGUI = new JListGUI();
        frame.setContentPane(jListGUI.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(600, 500);
        frame.setVisible(true);
        frame.setMinimumSize(new Dimension(600,500));
    }
}
