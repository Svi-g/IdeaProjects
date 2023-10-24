package CoolPack;
import java.awt.*;
import java.awt.event.*;
public class SBDemo extends Frame implements AdjustmentListener, MouseMotionListener {
    String msg = "";
    Scrollbar vertSB, horzSB;

    public SBDemo() {
        super("Scroll Bar Demo");

        setLayout(new FlowLayout());

        int width = 500; // Provide a default width
        int height = 500; // Provide a default height
        vertSB = new Scrollbar(Scrollbar.VERTICAL,
                0, 1, 0, height);
        vertSB.setPreferredSize(new Dimension(20, 100));
        horzSB = new Scrollbar(Scrollbar.HORIZONTAL,
                0, 1, 0, width);
        horzSB.setPreferredSize(new Dimension(100, 20));
        add(vertSB);
        add(horzSB);
// register to receive adjustment events
        vertSB.addAdjustmentListener(this);
        horzSB.addAdjustmentListener(this);
        addMouseMotionListener(this);

        // Add a window listener to handle window closing
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        // Set Frame properties
        setSize(300, 200);
        setVisible(true);
    }

    @Override
    public void adjustmentValueChanged(AdjustmentEvent ae) {
        repaint();
    }
    // Update scroll bars to reflect mouse dragging.
    @Override
    public void mouseDragged(MouseEvent me) {
        int x = me.getX();
        int y = me.getY();
        vertSB.setValue(y);
        horzSB.setValue(x);
        repaint();
    }
    // Necessary for MouseMotionListener
    @Override
    public void mouseMoved(MouseEvent me) {
    }

    // Display current value of scroll bars.
    @Override
    public void paint(Graphics g) {
        msg = "Vertical: " + vertSB.getValue();
        msg += ", Horizontal: " + horzSB.getValue();
        g.drawString(msg, 6, 160);
// show current mouse drag position
        g.drawString("*", horzSB.getValue(),
                vertSB.getValue());
    }

    public static void main(String... args) {
        SBDemo appWindow = new SBDemo();
    }

}
