package CoolPack;
/*
 This is a modified JApplet to demonstrate a JCheckBoxDemo
 using a JFrame.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JCheckBoxDemo extends JFrame implements ItemListener {
    JLabel jlab;

    public JCheckBoxDemo() {
        super("JCheckBoxDemo Demo");
        setLayout(new FlowLayout());

        // Add check boxes to the content pane.
        JCheckBox cb = new JCheckBox("C");
        cb.addItemListener(this);
        add(cb);
        cb = new JCheckBox("C++");
        cb.addItemListener(this);
        add(cb);

        cb = new JCheckBox("Java");
        cb.addItemListener(this);
        add(cb);
        cb = new JCheckBox("Perl");
        cb.addItemListener(this);
        add(cb);
// Create the label and add it to the content pane.
        jlab = new JLabel("Select languages");
        add(jlab);
    }
    // Handle item events for the checkboxes.
    public void itemStateChanged(ItemEvent ie) {
        JCheckBox cb = (JCheckBox)ie.getItem();
        if(cb.isSelected())
            jlab.setText(cb.getText() + " is selected");
        else
            jlab.setText(cb.getText() + " is cleared");
        }

    public static void main(String... args) {
        SwingUtilities.invokeLater(() -> {
            JCheckBoxDemo demo = new JCheckBoxDemo();
            demo.setSize(220, 100);
            demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            demo.setLocationRelativeTo(null); // Center the JFrame
            demo.setVisible(true);
        });
    }
}
