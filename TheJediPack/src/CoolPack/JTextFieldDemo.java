package CoolPack;
/*
 This is a modified JApplet to demonstrate a JTextFieldDemo
 using a JFrame.
*/


import javax.swing.*;
import java.awt.*;

public class JTextFieldDemo extends JFrame {
    JTextField jtf;

    public JTextFieldDemo() {
        super("JTextField Demo");
        setLayout(new FlowLayout());

        // Add text field to content pane.
        jtf = new JTextField(15);
        add(jtf);
        jtf.addActionListener(ae -> {

            //showStatus(jtf.getText());
            // because this is a modified applet
            //this code will not work. Use the one below
            JOptionPane.showMessageDialog(null, jtf.getText());

        });
        setSize(220, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the JFrame
        setVisible(true);
    }
    public static void main(String... args) {
        SwingUtilities.invokeLater(JTextFieldDemo::new);
    }
}
