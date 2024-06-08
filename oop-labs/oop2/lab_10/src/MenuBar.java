import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuBar {
    private JPanel mainPanel;
    private JMenuBar menuBar;
    private JTextField textField1;
    private JTextField textField2;

    public MenuBar() {
        mainPanel = new JPanel(new GridLayout(2, 2));
        menuBar = new JMenuBar();

        // File menu
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        menuBar.add(fileMenu);

        // Edit menu
        JMenu editMenu = new JMenu("Edit");
        editMenu.setMnemonic(KeyEvent.VK_E);
        menuBar.add(editMenu);

        // Cut menu item
        JMenuItem cutMenuItem = new JMenuItem("Cut", KeyEvent.VK_T);
        cutMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        cutMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform cut action
                textField1.cut();
                textField2.cut();
            }
        });
        editMenu.add(cutMenuItem);

        // Copy menu item
        JMenuItem copyMenuItem = new JMenuItem("Copy", KeyEvent.VK_C);
        copyMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        copyMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform copy action
                textField1.copy();
                textField2.copy();
            }
        });
        editMenu.add(copyMenuItem);

        // Paste menu item
        JMenuItem pasteMenuItem = new JMenuItem("Paste", KeyEvent.VK_P);
        pasteMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        pasteMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform paste action only for the second textField
                textField2.paste();
            }
        });
        editMenu.add(pasteMenuItem);

        textField1 = new JTextField();
        textField2 = new JTextField();
        mainPanel.add(textField1);
        mainPanel.add(textField2);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("MenuBar");
        MenuBar example = new MenuBar();
        frame.setJMenuBar(example.getMenuBar());
        frame.setContentPane(example.getMainPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(250,250);
        frame.setMinimumSize(new Dimension(250, 250));

    }
}
