package CoolPack;
import java.awt.*;
import java.awt.event.*;

/*
Th
 */
public class AppWindow extends Frame {
    String keymsg = "";
    String mousemsg = "";
    int mouseX = 30, mouseY = 30;

    // Variables for drawing
    private boolean isDrawing = false;
    private int prevX, prevY;
    private final StringBuilder textToDraw = new StringBuilder();
    private boolean backspaceHandled = false;

    public AppWindow() {
        addKeyListener(new MyKeyAdapter(this));
        addMouseListener(new MyMouseAdapterDemo(this));
        addWindowListener(new NewWindowAdapter());
        setResizable(true); // Enable manual resizing
        setBackground(Color.WHITE);
        setForeground(Color.BLACK);
        setFocusable(true); // Allow the frame to receive keyboard events
        requestFocus(); // Request focus for the frame
    }

    public void paint(Graphics g) {
        g.drawString(keymsg, 10, 40);
        g.drawString(mousemsg, mouseX, mouseY);
        g.drawString(textToDraw.toString(), 50, 100);
    }

    static class MyKeyAdapter extends KeyAdapter {
        AppWindow appWindow;

        public MyKeyAdapter(AppWindow appWindow) {
            this.appWindow = appWindow;
        }

        public void keyTyped(KeyEvent ke) {
            char keyChar = ke.getKeyChar();
            if (keyChar == KeyEvent.VK_BACK_SPACE) {
                // Handle backspace to delete text
                if (appWindow.textToDraw.length() > 0) {
                    appWindow.textToDraw.deleteCharAt(appWindow.textToDraw.length() - 1);
                    appWindow.backspaceHandled = true;
                    appWindow.repaint();
                }
            } else if (Character.isLetterOrDigit(keyChar) || Character.isWhitespace(keyChar)) {
                // Ignore keyTyped events if backspace was handled
                if (!appWindow.backspaceHandled) {
                    appWindow.textToDraw.append(keyChar);
                    appWindow.repaint();
                } else {
                    appWindow.backspaceHandled = false; // Reset the flag
                }
            }
        }
    }

    static class MyMouseAdapterDemo extends MouseAdapter {
        AppWindow appWindow;

        public MyMouseAdapterDemo(AppWindow appWindow) {
            this.appWindow = appWindow;
        }

        public void mousePressed(MouseEvent me) {
            appWindow.mouseX = me.getX();
            appWindow.mouseY = me.getY();
            appWindow.mousemsg = "Mouse Down at " + appWindow.mouseX +
                    ", " + appWindow.mouseY;
            appWindow.repaint();
        }
    }

    static class NewWindowAdapter extends WindowAdapter {
        public void windowClosing(WindowEvent we) {
            System.exit(0);
        }
    }

    public void startDrawing(int x, int y) {
        isDrawing = true;
        prevX = x;
        prevY = y;
    }

    public void stopDrawing() {
        isDrawing = false;
    }

    public void drawLine(int x, int y) {
        if (isDrawing) {
            Graphics g = getGraphics();
            g.setColor(getForeground());
            g.drawLine(prevX, prevY, x, y);
            prevX = x;
            prevY = y;
        }
    }


    public static void main(String... args) {
        AppWindow appwin = new AppWindow();
        appwin.setSize(new Dimension(800, 600));
        appwin.setTitle("Text Demo");
        appwin.setVisible(true);

        appwin.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                appwin.startDrawing(e.getX(), e.getY());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                appwin.stopDrawing();
            }
        });

        appwin.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                appwin.drawLine(e.getX(), e.getY());
                appwin.repaint();
            }
        });
    }
}
