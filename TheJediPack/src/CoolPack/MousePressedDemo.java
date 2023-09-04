package CoolPack;
// This applet does NOT use an inner class.
import java.applet.*;
import java.awt.event.*;
/*
<applet code="MousePressedDemo" width=200 height=100>
</applet>
*/
public class MousePressedDemo extends Applet {
    public void init() {
        addMouseListener(new NewMouseAdapter(this));
    }
}

class NewMouseAdapter extends MouseAdapter {
    MousePressedDemo mousePressedDemo;
    public NewMouseAdapter(MousePressedDemo mousePressedDemo) {
        this.mousePressedDemo = mousePressedDemo;
    }
    public void mousePressed(MouseEvent me) {
        mousePressedDemo.showStatus("Mouse Pressed.");
    }
}
