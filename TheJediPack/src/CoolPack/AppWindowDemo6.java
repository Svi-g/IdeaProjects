package CoolPack;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*
This is a modified applet that runs on an
AppWindow that extends Frame. Instead of the MultiLine
class to extend Applet, it extends Canvas so that
it is a component of the Window.
 */
public class AppWindowDemo6 extends Frame {
    public AppWindowDemo6() {
        setTitle("Display Multiple Fonts");
        setSize(200, 100);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        MultiLine multiLine = new MultiLine();
        add(multiLine);
    }

    public static void main(String... args) {
        AppWindowDemo6 appWindow = new AppWindowDemo6();
        appWindow.setVisible(true);
    }
}

class MultiLine extends Canvas {
    int curX=0, curY=0; // current position
    public void init() {
        Font f = new Font("SansSerif", Font.PLAIN, 12);
        setFont(f);
    }

    public void paint(Graphics g) {
        FontMetrics fm = g.getFontMetrics();
        nextLine("This is on line one.", g);
        nextLine("This is on line two.", g);
        sameLine(" This is on same line.", g);
        sameLine(" This, too.", g);
        nextLine("This is on line three.", g);
        curX = curY = 0; // Reset coordinates for each repaint.
    }
    // Advance to next line.
    void nextLine(String s, Graphics g) {
        FontMetrics fm = g.getFontMetrics();
        curY += fm.getHeight(); // advance to next line
        curX = 0;
        g.drawString(s, curX, curY);
        curX = fm.stringWidth(s); // advance to end of line
    }
    // Display on same line.
    void sameLine(String s, Graphics g) {
        FontMetrics fm = g.getFontMetrics();
        g.drawString(s, curX, curY);
        curX += fm.stringWidth(s); // advance to end of line
    }
}