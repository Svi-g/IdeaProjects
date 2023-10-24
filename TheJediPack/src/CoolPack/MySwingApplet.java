package CoolPack;

import javax.swing.*;
import java.awt.*;

public class MySwingApplet extends JFrame {
    private JButton jbtnAlpha;
    private JButton jbtnBeta;
    private JLabel jlab;

    public MySwingApplet() {
        // Set the JFrame title
        super("My Swing Applet");
        setLayout(new FlowLayout());

        // Create two buttons
        jbtnAlpha = new JButton("Alpha");
        jbtnBeta = new JButton("Beta");

        // Add action listener for Alpha
        jbtnAlpha.addActionListener(e -> jlab.setText("Alpha was pressed."));

        // Add action listener for Beta
        jbtnBeta.addActionListener(e -> jlab.setText("Beta was pressed."));

        // Create a text-based label
        jlab = new JLabel("Press a button.");

        // Add the components to the JFrame's content pane
        add(jbtnAlpha);
        add(jbtnBeta);
        add(jlab);

        // Set JFrame properties
        setSize(220, 90);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the JFrame
        setVisible(true);
    }
    public static void main(String... args) {
        SwingUtilities.invokeLater(MySwingApplet::new);
    }
}