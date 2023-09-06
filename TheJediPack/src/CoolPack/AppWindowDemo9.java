package CoolPack;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AppWindowDemo9 extends Frame {
    public AppWindowDemo9() {
        setTitle("Menu Layout");
        setSize(400, 400); // window size
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        LabelDemo labelDemo = new LabelDemo();
        add(labelDemo);
    }

    public static void main(String... args) {
        AppWindowDemo9 appWindow = new AppWindowDemo9();
        appWindow.setVisible(true);
    }
}

class LabelDemo extends Canvas {
    public void paint(Graphics g) {
        // Use Graphics object to draw labels or text
        g.drawString("One", 50, 50);
        g.drawString("Two", 50, 80);
        g.drawString("Three", 50, 110);
    }


   /*

    public LabelDemo() {
        PopupMenu labelMenu = new PopupMenu(); // Create a PopupMenu to hold the Labels
        MenuItem one = new MenuItem("One");
        MenuItem two = new MenuItem("Two");
        MenuItem three = new MenuItem("Three");

        labelMenu.add(one);
        labelMenu.add(two);
        labelMenu.add(three);

        add(labelMenu); // Add the PopupMenu to the Canvas
    }

    */
}
