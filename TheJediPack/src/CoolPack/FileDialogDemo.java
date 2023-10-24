package CoolPack;
/* Demonstrate File Dialog box.
This is an application, not an applet.
*/
import java.awt.*;
import java.awt.event.*;
// Create a subclass of Frame.
class CoolFrame extends Frame {
    CoolFrame(String title) {
        super(title);
// remove the window when closed
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }
}
// Demonstrate FileDialog.
class FileDialogDemo {
    public static void main(String... args) {
// create a frame that owns the dialog
        Frame f = new CoolFrame("File Dialog Demo");
        f.setVisible(true);
        f.setSize(100, 100);
        FileDialog fd = new FileDialog(f, "File Dialog");
        fd.setVisible(true);
    }
}