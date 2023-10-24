package CoolPack;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
/*
<applet code="KeyEvents" width=300 height=100>
</applet>
*/

// Demonstrating virtual key codes.
public class KeyEvents extends Applet implements KeyListener {
    String msg = "";
    int X = 10, Y = 20; // output coordinates
    public void init() {
        addKeyListener(this);
    }
    public void keyPressed(KeyEvent ke) {
        showStatus("Key Down");
        int key = ke.getKeyCode();
        switch (key) {
            case KeyEvent.VK_F1 -> msg += "<F1>";
            case KeyEvent.VK_F2 -> msg += "<F2>";
            case KeyEvent.VK_F3 -> msg += "<F3>";
            case KeyEvent.VK_PAGE_DOWN -> msg += "<PgDn>";
            case KeyEvent.VK_PAGE_UP -> msg += "<PgUp>";
            case KeyEvent.VK_LEFT -> msg += "<Left Arrow>";
            case KeyEvent.VK_RIGHT -> msg += "<Right Arrow>";
        }
        repaint();
    }
    public void keyReleased(KeyEvent ke) {
        showStatus("Key Up");
    }
    public void keyTyped(KeyEvent ke) {
        msg += ke.getKeyChar();
        repaint();
    }
    // Display keystrokes.
    public void paint(Graphics g) {
        g.drawString(msg, X, Y);
    }
}
