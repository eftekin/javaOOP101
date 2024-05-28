import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class UniversityGUI {
    private JFrame frame;
    private JTable table;
    private JTextField nameField;
    private JTextField surnameField;
    private JTextField courseField;
    private JRadioButton studentRadio;
    private JRadioButton academicianRadio;
    private DefaultTableModel tableModel;
    private Connection connection;

    public UniversityGUI() {
        initialize();
        connectToDatabase();
        loadTableData();  // Başlangıçta verileri yükleyin
    }

    private void connectToDatabase() {
        connection = DatabaseConnection.connect();
        if (connection == null) {
            JOptionPane.showMessageDialog(frame, "Database connection failed.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 10, 400, 200);
        frame.getContentPane().add(scrollPane);

        table = new JTable();
        tableModel = new DefaultTableModel(
                new Object[][]{},
                new String[]{"ID", "Name", "Surname", "Course"}
        );
        table.setModel(tableModel);
        scrollPane.setViewportView(table);

        studentRadio = new JRadioButton("Student");
        studentRadio.setBounds(10, 220, 100, 30);
        frame.getContentPane().add(studentRadio);

        academicianRadio = new JRadioButton("Academician");
        academicianRadio.setBounds(120, 220, 100, 30);
        frame.getContentPane().add(academicianRadio);

        ButtonGroup group = new ButtonGroup();
        group.add(studentRadio);
        group.add(academicianRadio);

        // Radiobutton'lara ActionListener ekleyin
        studentRadio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadTableData();
            }
        });

        academicianRadio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadTableData();
            }
        });

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(10, 260, 80, 25);
        frame.getContentPane().add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(100, 260, 165, 25);
        frame.getContentPane().add(nameField);

        JLabel surnameLabel = new JLabel("Surname:");
        surnameLabel.setBounds(10, 290, 80, 25);
        frame.getContentPane().add(surnameLabel);

        surnameField = new JTextField();
        surnameField.setBounds(100, 290, 165, 25);
        frame.getContentPane().add(surnameField);

        JLabel courseLabel = new JLabel("Course:");
        courseLabel.setBounds(10, 320, 80, 25);
        frame.getContentPane().add(courseLabel);

        courseField = new JTextField();
        courseField.setBounds(100, 320, 165, 25);
        frame.getContentPane().add(courseField);

        JButton insertButton = new JButton("INSERT");
        insertButton.setIcon(new ImageIcon("assets/insert-icon.png"));
        insertButton.setBounds(450, 170, 100, 40);
        insertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                insertRecord();
            }
        });
        frame.getContentPane().add(insertButton);

        JButton updateButton = new JButton("UPDATE");
        updateButton.setIcon(new ImageIcon("assets/update-icon.png"));
        updateButton.setBounds(450, 210, 100, 40);
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateRecord();
            }
        });
        frame.getContentPane().add(updateButton);

        JButton deleteButton = new JButton("DELETE");
        deleteButton.setIcon(new ImageIcon("assets/delete-icon.png"));
        deleteButton.setBounds(450, 250, 100, 40);
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteRecord();
            }
        });
        frame.getContentPane().add(deleteButton);
    }

    private void loadTableData() {
        String tableName = studentRadio.isSelected() ? "Student" : "Academician";
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + tableName);
            tableModel.setRowCount(0);
            while (rs.next()) {
                tableModel.addRow(new Object[]{
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
            JOptionPane.showMessageDialog(frame, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!courseExists(course)) {
            JOptionPane.showMessageDialog(frame, "Course does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
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

                if (name.isEmpty() || surname.isEmpty() || course.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!courseExists(course)) {
                    JOptionPane.showMessageDialog(frame, "Course does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
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
                JOptionPane.showMessageDialog(frame, "Please select a record to update.", "Error", JOptionPane.ERROR_MESSAGE);
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
                JOptionPane.showMessageDialog(frame, "Please select a record to delete.", "Error", JOptionPane.ERROR_MESSAGE);
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
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UniversityGUI window = new UniversityGUI();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
