package CoolPack;
/*
 This is a modified JApplet to demonstrate a JComboBoxDemo
 using a JFrame.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class JComboBoxDemo extends JFrame {
    JLabel jlab;
    ImageIcon hourglass, analog, digital, stopwatch;
    JComboBox<String> jcb;
    String[] timepieces = { "Hourglass", "Analog", "Digital", "Stopwatch" };

    public JComboBoxDemo() {
        super("JComboBox Demo");
        setLayout(new FlowLayout());

        // Instantiate a combo box and add it to the content pane.
        jcb = new JComboBox<String>(timepieces);
        add(jcb);
// Handle selections.
        jcb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String s = (String) jcb.getSelectedItem();
                jlab.setIcon(new ImageIcon(s + ".png"));
            }
        });
// Create a label and add it to the content pane.
        jlab = new JLabel(new ImageIcon("hourglass.png"));
        add(jlab);
    }
    public static void main(String... args) {
        SwingUtilities.invokeLater(() -> {
            JComboBoxDemo demo = new JComboBoxDemo();
            demo.setSize(200, 100);
            demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            demo.setLocationRelativeTo(null); // Center the JFrame
            demo.setVisible(true);
        });
    }
}
