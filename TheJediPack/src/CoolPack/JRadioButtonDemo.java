package CoolPack;
/*
 This is a modified JApplet to demonstrate a JRadioButtonDemo
 using a JFrame.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JRadioButtonDemo extends JFrame implements ActionListener {
    JLabel jlab;
    JRadioButton b1, b2, b3;
    public JRadioButtonDemo() {
        super("JRadioButton Demo");
        setLayout(new FlowLayout());

        b1 = new JRadioButton("A"); // Declare b1 and initialize it
        b1.addActionListener(this);
        add(b1);
        b2 = new JRadioButton("B");
        b2.addActionListener(this);
        add(b2);
        b3 = new JRadioButton("C");
        b3.addActionListener(this);
        add(b3);

        // Define a button group.
        ButtonGroup bg = new ButtonGroup();
        bg.add(b1);
        bg.add(b2);
        bg.add(b3);

        // Create a label and add it to the content pane.
        jlab = new JLabel("Select One");
        add(jlab);
    }

    // Handle button selection.
    public void actionPerformed(ActionEvent ae) {
        jlab.setText("You selected " + ae.getActionCommand());
    }

    public static void main(String... args) {
        SwingUtilities.invokeLater(() -> {
            JRadioButtonDemo demo = new JRadioButtonDemo();
            demo.setSize(300, 100);
            demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            demo.setLocationRelativeTo(null); // Center the JFrame
            demo.setVisible(true);
        });
    }
}
