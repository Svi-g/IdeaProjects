package CoolPack;
/*
 This is a modified JApplet to demonstrate a JToggleButton
 using a JFrame.
*/


import javax.swing.*;
import java.awt.*;

public class JToggleButtonDemo extends JFrame {
    JLabel jlab;
    JToggleButton jtbn;

    public JToggleButtonDemo() {
        super("JToggleButton Demo");
        setLayout(new FlowLayout());

        jlab = new JLabel("Button is off.");
        // Make a toggle button.
        jtbn = new JToggleButton("On/Off");
// Add an item listener for the toggle button.
        jtbn.addItemListener(ie -> {
            if(jtbn.isSelected())
                jlab.setText("Button is on.");
            else
                jlab.setText("Button is off.");
        });
// Add the toggle button and label to the content pane.
        add(jtbn);
        add(jlab);
    }

    public static void main(String... args) {
        SwingUtilities.invokeLater(() -> {
            JToggleButtonDemo demo = new JToggleButtonDemo();
            demo.setSize(220, 100);
            demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            demo.setLocationRelativeTo(null); // Center the JFrame
            demo.setVisible(true);
        });
    }
}
