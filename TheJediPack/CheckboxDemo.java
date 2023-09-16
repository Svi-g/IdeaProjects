package CoolPack;

import java.awt.*;
import java.awt.event.*;

/*
Sendiyi betha isiDyani le wei
 */
public class CheckboxDemo extends Frame implements ItemListener {
    String msg = "";
    Checkbox windows, android, solaris, mac;
    CheckboxGroup cbg;

    public CheckboxDemo() {
        super("Checkbox Demo");

        // shaya iFlowLayout to display icheckboxes
        setLayout(new FlowLayout(FlowLayout.LEADING));

        // CheckboxGroup
        cbg = new CheckboxGroup();

        // betha iCheckbox zakho
        windows = new Checkbox("Windows", cbg, true);
        android = new Checkbox("Android", cbg, false);
        solaris = new Checkbox("Solaris", cbg, false);
        mac = new Checkbox("Mac OS", cbg, false);

        add(windows);
        add(android);
        add(solaris);
        add(mac);

        // Add item listeners
        windows.addItemListener(this);
        android.addItemListener(this);
        solaris.addItemListener(this);
        mac.addItemListener(this);

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

    // Display current state of the checkboxes
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        msg = "Current selection: ";
        msg += cbg.getSelectedCheckbox().getLabel();
        g.drawString(msg, 6, 100);

        /*
        msg = " Windows: " + windows.getState();
        g.drawString(msg, 6, 100);
        msg = " Android: " + android.getState();
        g.drawString(msg, 6, 120);
        msg = " Solaris: " + solaris.getState();
        g.drawString(msg, 6, 140);
        msg = " Mac OS: " + mac.getState();
        g.drawString(msg, 6, 160);
         */
    }

    public static void main(String... args) {
        CheckboxDemo appWindow = new CheckboxDemo();
    }
}
