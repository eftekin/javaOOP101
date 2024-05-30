import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class UniversityUI {
    private JTable table;
    private JTextField surnameField;
    private JTextField nameField;
    private JTextField courseField;
    private JRadioButton studentRadio;
    private JRadioButton academicianRadio;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton insertButton;
    private JLabel nameLabel;
    private JLabel surnameLabel;
    private JLabel courseLabel;
    private DefaultTableModel tableModel;
    private Connection connection;
    private JPanel mainPanel;

    public UniversityUI() {
        initialize();
        connectToDatabase();
        loadTableData();
    }

    private void connectToDatabase() {
        connection = DatabaseConnection.connect();
        if (connection == null) {
            JOptionPane.showMessageDialog(mainPanel, "Database connection failed.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void initialize() {
        tableModel = new DefaultTableModel(
                new Object[][] {},
                new String[] { "ID", "Name", "Surname", "Course" }
        );
        table.setModel(tableModel);

        studentRadio.addActionListener(e -> loadTableData());
        academicianRadio.addActionListener(e -> loadTableData());

        insertButton.addActionListener(e -> insertRecord());
        updateButton.addActionListener(e -> updateRecord());
        deleteButton.addActionListener(e -> deleteRecord());
    }

    private void loadTableData() {
        String tableName = studentRadio.isSelected() ? "Student" : "Academician";
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + tableName);
            tableModel.setRowCount(0); // Reset table data
            while (rs.next()) {
                tableModel.addRow(new Object[] {
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insertRecord() {
        String name = nameField.getText();
        String surname = surnameField.getText();
        String course = courseField.getText();

        if (name.isEmpty() || surname.isEmpty() || course.isEmpty()) {
            JOptionPane.showMessageDialog(mainPanel, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (courseExists(course)) {
            JOptionPane.showMessageDialog(mainPanel, "Course does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String tableName = studentRadio.isSelected() ? "Student" : "Academician";
        try {
            String query = "INSERT INTO " + tableName + " (Name, Surname, CourseCode) VALUES (?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, name);
            pstmt.setString(2, surname);
            pstmt.setString(3, course);
            pstmt.executeUpdate();
            loadTableData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateRecord() {
        String name = nameField.getText();
        String surname = surnameField.getText();
        String course = courseField.getText();
        String tableName = studentRadio.isSelected() ? "Student" : "Academician";
        String idColumn = studentRadio.isSelected() ? "StudentID" : "AcademicianID";
        try {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                int id = (int) table.getValueAt(selectedRow, 0);
                if (name.isEmpty()) {
                    name = (String) table.getValueAt(selectedRow, 1);
                }
                if (surname.isEmpty()) {
                    surname = (String) table.getValueAt(selectedRow, 2);
                }
                if (course.isEmpty()) {
                    course = (String) table.getValueAt(selectedRow, 3);
                }

                if (courseExists(course)) {
                    JOptionPane.showMessageDialog(mainPanel, "Course does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String query = "UPDATE " + tableName + " SET Name=?, Surname=?, CourseCode=? WHERE " + idColumn + "=?";
                PreparedStatement pstmt = connection.prepareStatement(query);
                pstmt.setString(1, name);
                pstmt.setString(2, surname);
                pstmt.setString(3, course);
                pstmt.setInt(4, id);
                pstmt.executeUpdate();
                loadTableData();
            } else {
                JOptionPane.showMessageDialog(mainPanel, "Please select a record to update.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void deleteRecord() {
        String tableName = studentRadio.isSelected() ? "Student" : "Academician";
        String idColumn = studentRadio.isSelected() ? "StudentID" : "AcademicianID";
        try {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                int id = (int) table.getValueAt(selectedRow, 0);
                String query = "DELETE FROM " + tableName + " WHERE " + idColumn + "=?";
                PreparedStatement pstmt = connection.prepareStatement(query);
                pstmt.setInt(1, id);
                pstmt.executeUpdate();
                loadTableData();
            } else {
                JOptionPane.showMessageDialog(mainPanel, "Please select a record to delete.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean courseExists(String courseCode) {
        try {
            String query = "SELECT 1 FROM Courses WHERE CourseCode = ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, courseCode);
            ResultSet rs = pstmt.executeQuery();
            return !rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return true;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UniversityUI window = new UniversityUI();
                JFrame frame = new JFrame("University Management");
                frame.setContentPane(window.mainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(900, 600); // Set the frame size
                frame.setResizable(false); // Make the frame non-resizable
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
