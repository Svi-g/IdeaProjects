package CoolPack;
/*
 This is a modified JApplet to demonstrate a JTabbedPaneDemo
 using a JFrame.
*/

import javax.swing.*;
import java.awt.*;

public class JTabbedPaneDemo extends JFrame {

    public JTabbedPaneDemo() {
        super("JTabbedPane Demo");
        setLayout(new FlowLayout());

        JTabbedPane jtp = new JTabbedPane();
        jtp.addTab("Cities", new CitiesPanel());
        jtp.addTab("Colors", new ColorsPanel());
        jtp.addTab("Flavors", new FlavorsPanel());
        add(jtp);
    }
    // Make the panels that will be added to the tabbed pane.
    static class CitiesPanel extends JPanel {
        public CitiesPanel() {
            JButton b1 = new JButton("New York");
            add(b1);
            JButton b2 = new JButton("London");
            add(b2);
            JButton b3 = new JButton("Hong Kong");
            add(b3);
            JButton b4 = new JButton("Tokyo");
            add(b4);
        }
    }
    static class ColorsPanel extends JPanel {
        public ColorsPanel() {
            JCheckBox cb1 = new JCheckBox("Red");
            add(cb1);
            JCheckBox cb2 = new JCheckBox("Green");
            add(cb2);
            JCheckBox cb3 = new JCheckBox("Blue");
            add(cb3);
        }
    }

    static class FlavorsPanel extends JPanel {
        public FlavorsPanel() {
            JComboBox<String> jcb = new JComboBox<>();
            jcb.addItem("Vanilla");
            jcb.addItem("Chocolate");
            jcb.addItem("Strawberry");
            add(jcb);
        }
    }
        public static void main(String... args) {
            SwingUtilities.invokeLater(() -> {
                JTabbedPaneDemo demo = new JTabbedPaneDemo();
                demo.setSize(400, 100);
                demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                demo.setLocationRelativeTo(null); // Center the JFrame
                demo.setVisible(true);
            });
        }
}
