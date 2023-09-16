package CoolPack;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*
This is another modified applet that runs
on an AppWindow that extends Frame.
 */
public class AppWindowDemo2 extends Frame {
    public AppWindowDemo2() {
        setTitle("XOR Demo");
        setSize(400, 200);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        XOR xorDemo = new XOR();
        add(xorDemo);
    }

    public static void main(String... args) {
        AppWindowDemo2 appWindow = new AppWindowDemo2();
        appWindow.setVisible(true);
    }
}

class XOR extends Canvas {
    int chsX = 100, chsY = 100;

    public XOR() {
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseMoved(MouseEvent me) {
                int x = me.getX();
                int y = me.getY();
                chsX = x - 10;
                chsY = y - 10;
                repaint();
            }
        });
    }

    public void paint(Graphics g) {
        g.drawLine(0, 0, 100, 100);
        g.drawLine(0, 100, 100, 0);
        g.setColor(Color.blue);
        g.drawLine(40, 25, 250, 180);
        g.drawLine(75, 90, 400, 400);
        g.setColor(Color.green);
        g.drawRect(10, 10, 60, 50);
        g.fillRect(100, 10, 60, 50);
        g.setColor(Color.red);
        g.drawRoundRect(190, 10, 60, 50, 15, 15);
        g.fillRoundRect(70, 90, 140, 100, 30, 40);
        g.setColor(Color.cyan);
        g.drawLine(20, 150, 400, 40);

        // XOR crosshairs
        g.setXORMode(Color.black);
        g.drawLine(chsX - 10, chsY, chsX + 10, chsY);
        g.drawLine(chsX, chsY - 10, chsX, chsY + 10);
        g.setPaintMode();
    }
}
