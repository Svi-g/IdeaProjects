package CoolPack;
// this is a modified applet
import javax.swing.*;
import java.awt.*;
public class JLabelDemo extends JFrame {
        public JLabelDemo() {
            super("JLabel Demo");
            setLayout(new FlowLayout());

            ImageIcon ii = new ImageIcon("Hourglass.png");

            // Create a label.
            JLabel jl = new JLabel("Hourglass", ii, JLabel.CENTER);

            // Add the label to the content pane.
            add(jl); // Set JFrame properties
            setSize(220, 90);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null); // Center the JFrame
            setVisible(true);
        }
    public static void main(String... args) {
        SwingUtilities.invokeLater(JLabelDemo::new);
    }
}
