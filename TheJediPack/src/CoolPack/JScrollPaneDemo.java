package CoolPack;
/*
 This is a modified JApplet to demonstrate a JScrollPaneDemo
 using a JFrame.
*/

import javax.swing.*;
import java.awt.*;

public class JScrollPaneDemo extends JFrame {

    public JScrollPaneDemo() {
        super("JTabbedPane Demo");
        setLayout(new BorderLayout());

        // Add 400 buttons to a panel.
        JPanel jp = new JPanel();
        jp.setLayout(new GridLayout(20, 20));
        int b = 0;
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                jp.add(new JButton("Button " + b));
                ++b;
            }
        }
        // Create the scroll pane.
        JScrollPane jsp = new JScrollPane(jp);
        // Add the scroll pane to the content pane.
        // Because the default border layout is used,
        // the scroll pane will be added to the center.
        add(jsp, BorderLayout.CENTER);
    }

    public static void main(String... args) {
        SwingUtilities.invokeLater(() -> {
            JScrollPaneDemo demo = new JScrollPaneDemo();
            demo.setSize(400, 250);
            demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            demo.setLocationRelativeTo(null); // Center the JFrame
            demo.setVisible(true);
        });
    }
}
