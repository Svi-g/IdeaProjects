package CoolPack;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AppWindowDemo7 extends Frame {
    public AppWindowDemo7() {
        setTitle("Centre Text");
        setSize(200, 200);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        CenterText centerText = new CenterText();
        add(centerText);
    }

    public static void main(String... args) {
        AppWindowDemo7 appWindow = new AppWindowDemo7();
        appWindow.setVisible(true);
    }
}

class CenterText extends Canvas {
    final Font f = new Font("SansSerif", Font.BOLD, 18);
    public void paint(Graphics g) {
        Dimension d = this.getSize();
        g.setColor(Color.white);
        g.fillRect(0, 0, d.width,d.height);
        g.setColor(Color.black);
        g.setFont(f);
        drawCenteredString("This is centered.", d.width, d.height, g);
        g.drawRect(0, 0, d.width-1, d.height-1);
    }
    public void drawCenteredString(String s, int w, int h,
                                   Graphics g) {
        FontMetrics fm = g.getFontMetrics();
        int x = (w - fm.stringWidth(s)) / 2;
        int y = (fm.getAscent() + (h - (fm.getAscent()
                + fm.getDescent()))/2);
        g.drawString(s, x, y);
    }
}
