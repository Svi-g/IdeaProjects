package CoolPack;
import java.awt.*;
import java.awt.event.*;

public class DoubleBuffer extends Frame {
    int gap = 3;
    int mx, my;
    boolean flicker = true;
    Image buffer = null;
    int w, h;

    public DoubleBuffer() {
        super("Image Demo");
        setLayout(new FlowLayout());

        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent me) {
                mx = me.getX();
                my = me.getY();
                flicker = false;
                repaint();
            }
            public void mouseMoved(MouseEvent me) {
                mx = me.getX();
                my = me.getY();
                flicker = true;
                repaint();
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        // Initialize the buffer in the componentResized method
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                w = getWidth();
                h = getHeight();
                buffer = createImage(w, h);
            }
        });

        setSize(400, 300); // Set an initial size for the frame
        setVisible(true);
    }

    // Rename this method to avoid overriding Frame's paint method
    public void draw(Graphics g) {
        Graphics screengc = null;
        if (!flicker) {
            screengc = g;
            g = buffer.getGraphics();
        }
        g.setColor(Color.blue);
        g.fillRect(0, 0, w, h);
        g.setColor(Color.red);
        for (int i = 0; i < w; i += gap)
            g.drawLine(i, 0, w - i, h);
        for (int i = 0; i < h; i += gap)
            g.drawLine(0, i, w, h - i);
        g.setColor(Color.black);
        g.drawString("Press mouse button to double buffer", 10, h / 2);
        g.setColor(Color.yellow);
        g.fillOval(mx - gap, my - gap, gap * 2 + 1, gap * 2 + 1);
        if (!flicker) {
            assert screengc != null;
            screengc.drawImage(buffer, 0, 0, null);
        }
    }

    public static void main(String... args) {
        DoubleBuffer appWindow = new DoubleBuffer();
    }

    @Override
    public void paint(Graphics g) {
        draw(g); // biza the custom draw method
    }
}
