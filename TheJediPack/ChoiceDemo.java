package CoolPack;
import java.awt.*;
import java.awt.event.*;

public class ChoiceDemo extends Frame implements ItemListener {
    String msg = "";
    Choice os, browser;

    public ChoiceDemo() {
        super("Choice Demo");

        // shaya iFlowLayout to display icheckboxes
        setLayout(new FlowLayout());

        os = new Choice();
        browser = new Choice();
// add items to os list
        os.add("Windows");
        os.add("Android");
        os.add("Solaris");
        os.add("Mac OS");
// add items to browser list
        browser.add("Internet Explorer");
        browser.add("Firefox");
        browser.add("Chrome");
// add choice lists to window
        add(os);
        add(browser);
// register to receive item events
        os.addItemListener(this);
        browser.addItemListener(this);

        // Add a window listener to handle window closing
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        // Set Frame properties
        setSize(300, 200);
        setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        msg = "Current OS: ";
        msg += os.getSelectedItem();
        g.drawString(msg, 6, 120);
        msg = "Current Browser: ";
        msg += browser.getSelectedItem();
        g.drawString(msg, 6, 140);
    }

    public static void main(String... args) {
        ChoiceDemo appWindow = new ChoiceDemo();
    }
}
