package CoolPack;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*
This is a modified applet that runs on an
AppWindow that extends Frame. Instead of the FontsInfo
class to extend Applet, it extends Canvas so that
it is a component of the Window.
 */
public class AppDemoWindow5 extends Frame {
    public AppDemoWindow5() {
        setTitle("Display Fonts");
        setSize(200, 100);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        FontsInfo fontsInfo = new FontsInfo();
        add(fontsInfo);
    }

    public static void main(String... args) {
        AppDemoWindow5 appWindow = new AppDemoWindow5();
        appWindow.setVisible(true);
    }
}

class FontsInfo extends Canvas {
    public void paint(Graphics g) {
        Font f = g.getFont();
        String fontName = f.getName();
        String fontFamily = f.getFamily();
        int fontSize = f.getSize();
        int fontStyle = f.getStyle();
        String msg = "Family: " + fontName;
        msg += ", Font: " + fontFamily;
        msg += ", Size: " + fontSize + ", Style: ";
        if((fontStyle & Font.BOLD) == Font.BOLD)
            msg += "Bold ";
        if((fontStyle & Font.ITALIC) == Font.ITALIC)
            msg += "Italic ";
        if((fontStyle & Font.PLAIN) == Font.PLAIN)
            msg += "Plain ";
        g.drawString(msg, 4, 16);
    }
}
