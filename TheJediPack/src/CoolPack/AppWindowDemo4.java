package CoolPack;
import java.awt.*;
import java.awt.event.*;

/*
This is a modified applet that runs on an
AppWindow that extends Frame. Instead of the ShowFonts2
class to extend Applet, it extends Canvas so that
it is a component of the Window.
 */
public class AppWindowDemo4 extends Frame {
    public AppWindowDemo4() {
        setTitle("Sample Fonts");
        setSize(200, 100);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        ShowFonts2 showFonts2 = new ShowFonts2();
        showFonts2.init();
        showFonts2.start();

        add(showFonts2);
    }

    public static void main(String... args) {
        AppWindowDemo4 appWindow = new AppWindowDemo4();
        appWindow.setVisible(true);
    }
}

class ShowFonts2 extends Canvas {
    int next = 0;
    Font f;
    String msg;

    public void init() {
        f = new Font("Dialog", Font.PLAIN, 12);
        msg = "Dialog";
        setFont(f);
        addMouseListener(new MyMouseAdapter(this));
    }

    public void paint(Graphics g) {
        g.drawString(msg, 4, 20);
    }

    public void start() {
    }
}

class MyMouseAdapter extends MouseAdapter {
    ShowFonts2 showFonts;

    public MyMouseAdapter(ShowFonts2 showFonts) {
        this.showFonts = showFonts;
    }

    public void mousePressed(MouseEvent me) {
        // Switch fonts with each mouse click.
        showFonts.next++;
        switch (showFonts.next) {
            case 0 -> {
                showFonts.f = new Font("Dialog", Font.PLAIN, 12);
                showFonts.msg = "Dialog";
            }
            case 1 -> {
                showFonts.f = new Font("DialogInput", Font.PLAIN, 12);
                showFonts.msg = "DialogInput";
            }
            case 2 -> {
                showFonts.f = new Font("SansSerif", Font.PLAIN, 12);
                showFonts.msg = "SansSerif";
            }
            case 3 -> {
                showFonts.f = new Font("Serif", Font.PLAIN, 12);
                showFonts.msg = "Serif";
            }
            case 4 -> {
                showFonts.f = new Font("Monospaced", Font.PLAIN, 12);
                showFonts.msg = "Monospaced";
            }
        }
        if (showFonts.next == 4)
            showFonts.next = -1;
        showFonts.setFont(showFonts.f);
        showFonts.repaint();
    }
}

