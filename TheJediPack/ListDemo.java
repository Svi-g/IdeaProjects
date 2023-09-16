package CoolPack;
import java.awt.*;
import java.awt.event.*;
public class ListDemo extends Frame implements ActionListener {
    List os, browser;
    String msg = "";

    public ListDemo() {
        super("List Demo");

        // shaya iFlowLayout to display icheckboxes
        setLayout(new FlowLayout());
        os = new List(4, true);
        browser = new List(4, false);
// add items to os list
        os.add("Windows");
        os.add("Android");
        os.add("Solaris");
        os.add("Mac OS");
// add items to browser list
        browser.add("Internet Explorer");
        browser.add("Firefox");
        browser.add("Chrome");
        browser.select(1);
// add lists to window
        add(os);
        add(browser);
// register to receive action events
        os.addActionListener(this);
        browser.addActionListener(this);

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
    public void actionPerformed(ActionEvent ae) {
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int[] idx;

        msg = "Current OS: ";
        idx = os.getSelectedIndexes();
        for (int j : idx) msg += os.getItem(j) + " ";
        g.drawString(msg, 6, 120);
        msg = "Current Browser: ";
        msg += browser.getSelectedItem();
        g.drawString(msg, 6, 140);
    }

    public static void main(String... args) {
        ListDemo appWindow = new ListDemo();
    }
}
