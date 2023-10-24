package CoolPack;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AppWindowDemo10 extends Frame {

    public AppWindowDemo10() {
        setSize(250, 150);
        setTitle("Button Demo");
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        // This is the Panel to hold the buttons
        Panel buttonPanel = new Panel();
        buttonPanel.setLayout(new FlowLayout());

        // Create ButtonDemo canvas and add it to the frame
        ButtonDemo buttonDemo = new ButtonDemo();
        add(buttonDemo);

        // Create buttons and add them to the buttonPanel
        Button yes = new Button("Yes");
        Button no = new Button("No");
        Button maybe = new Button("Undecided");
        yes.addActionListener(buttonDemo);
        no.addActionListener(buttonDemo);
        maybe.addActionListener(buttonDemo);
        buttonPanel.add(yes);
        buttonPanel.add(no);
        buttonPanel.add(maybe);

        // Add the buttonPanel to the frame
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String... args) {
        AppWindowDemo10 appWindow = new AppWindowDemo10();
        appWindow.setVisible(true);
    }
}

class ButtonDemo extends Canvas implements ActionListener {
    String msg = "";

    public ButtonDemo() {
    }

    public void actionPerformed(ActionEvent ae) {
        String str = ae.getActionCommand();
        if (str.equals("Yes")) {
            msg = "You pressed Yes.";
        } else if (str.equals("No")) {
            msg = "You pressed No.";
        } else {
            msg = "You pressed Undecided.";
        }
        repaint();
    }

    public void paint(Graphics g) {
        g.drawString(msg, 6, 100);
    }
}
