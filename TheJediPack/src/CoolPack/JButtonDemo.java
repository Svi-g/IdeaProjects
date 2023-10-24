package CoolPack;
/*
 This is a modified JApplet to demonstrate a JButtonDemo
 using a JFrame.
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JButtonDemo extends JFrame implements ActionListener {
    JLabel jlab;

    public JButtonDemo() {
        super("JButton Demo");
        setLayout(new FlowLayout());

        // Add buttons to content pane.
        ImageIcon hourglass = new ImageIcon("hourglass.png");
        JButton jb = new JButton(scaleImage(hourglass, 50, 50));
        jb.setActionCommand("Hourglass");
        jb.addActionListener(this);
        add(jb);

        ImageIcon analog = new ImageIcon("analog.png");
        jb = new JButton(scaleImage(analog, 50, 50));
        jb.setActionCommand("Analog Clock");
        jb.addActionListener(this);
        add(jb);

        ImageIcon digital = new ImageIcon("digital.png");
        jb = new JButton(scaleImage(digital, 50, 50));
        jb.setActionCommand("Digital Clock");
        jb.addActionListener(this);
        add(jb);

        ImageIcon stopwatch = new ImageIcon("Stopwatch.png");
        jb = new JButton(scaleImage(stopwatch, 50, 50));
        jb.setActionCommand("Stopwatch");
        jb.addActionListener(this);
        add(jb);

        // Create and add the label to content pane.
        jlab = new JLabel("Choose a Timepiece");
        add(jlab);
    }

    // Size the image icons to the specified width and height.
    private ImageIcon scaleImage(ImageIcon icon, int width, int height) {
        Image image = icon.getImage();
        Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }

    // Handle button events.
    public void actionPerformed(ActionEvent ae) {
        jlab.setText("You selected " + ae.getActionCommand());
    }

    public static void main(String... args) {
        SwingUtilities.invokeLater(() -> {
            JButtonDemo demo = new JButtonDemo();
            demo.setSize(220, 100);
            demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            demo.setLocationRelativeTo(null); // Center the JFrame
            demo.setVisible(true);
        });
    }
}
