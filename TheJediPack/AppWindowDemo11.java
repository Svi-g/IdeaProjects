package CoolPack;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AppWindowDemo11 extends Frame {
    public AppWindowDemo11() {
        setSize(250, 150);
        setTitle("Button List Demo");

        // Create a ButtonList canvas and add it to the frame
        ButtonList buttonList = new ButtonList();
        add(buttonList);

        // Add buttons to the frame
        add(buttonList.getYesButton());
        add(buttonList.getNoButton());
        add(buttonList.getUndecidedButton());

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        // Set layout to FlowLayout to display buttons
        setLayout(new FlowLayout());

        setVisible(true);
    }

    public static void main(String... args) {
        AppWindowDemo11 appWindow = new AppWindowDemo11();
    }
}

class ButtonList extends Canvas implements ActionListener {
    String msg = "";
    Button yes, no, undecided;

    public ButtonList() {
        // Create buttons
        yes = new Button("Yes");
        no = new Button("No");
        undecided = new Button("Undecided");

        // Register to receive action events
        yes.addActionListener(this);
        no.addActionListener(this);
        undecided.addActionListener(this);
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

    public Button getYesButton() {
        return yes;
    }

    public Button getNoButton() {
        return no;
    }

    public Button getUndecidedButton() {
        return undecided;
    }

    public void paint(Graphics g) {
        g.drawString(msg, 6, 100);
    }
}
