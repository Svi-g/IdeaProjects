package CoolPack;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*
This is a modified applet that runs on an
AppWindow that extends Frame.
 */
public class AppWindowDemo3 extends Frame {
    public AppWindowDemo3() {
        setTitle("ShowFonts Demo");
        setSize(400, 200);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        ShowFonts ShowFontsDemo = new ShowFonts();
        add(ShowFontsDemo);
    }

    public static void main(String... args) {
        AppWindowDemo3 appWindow = new AppWindowDemo3();
        appWindow.setVisible(true);
    }
}

class ShowFonts extends Canvas {

    public void paint(Graphics g) {
        String msg = "";
        String[] FontList;
        GraphicsEnvironment ge =
                GraphicsEnvironment.getLocalGraphicsEnvironment();
        FontList = ge.getAvailableFontFamilyNames();
        for (String s : FontList) msg += s + " ";
        g.drawString(msg, 4, 16);
    }
}
