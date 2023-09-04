package CoolPack;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.StringTokenizer;

public class AppWindowDemo8 extends Frame {

    public AppWindowDemo8() {
        setTitle("Text Layout");
        setSize(400, 400); // window size
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        TextLayout textLayout = new TextLayout();
        add(textLayout);
    }

    public static void main(String... args) {
        AppWindowDemo8 appWindow = new AppWindowDemo8();
        appWindow.setVisible(true);
    }
}

class TextLayout extends Canvas {
    final int LEFT = 0;
    final int RIGHT = 1;
    final int CENTER = 2;
    final int LEFTRIGHT = 3;
    int align;

    Dimension d;
    Font f;
    FontMetrics fm;
    int fontSize;
    int fh, bl;
    int space;
    String text;

    public TextLayout() {
        init(); // Call init in the constructor
    }

    public void init() {
        f = new Font("Serif", Font.PLAIN, 14); // font initialization
        setBackground(Color.white);
        text = """
                Output to a Java window is actually
                quite easy.
                As you have seen, the AWT provides support for
                fonts, colors, text, and graphics. <P> Of course,
                you must effectively utilize these items
                if you are to achieve professional results""";
        align = LEFT;
        addMouseListener(new MyNewMouseAdapter(this));
    }

    public void paint(Graphics g) {
        update(g);
    }

    public void update(Graphics g) {
        d = getSize();
        g.setColor(getBackground());
        g.fillRect(0, 0, d.width, d.height);
        if (f == null) f = new Font("Serif", Font.PLAIN, fontSize);
        g.setFont(f);
        if (fm == null) {
            fm = g.getFontMetrics();
            bl = fm.getAscent();
            fh = bl + fm.getDescent();
            space = fm.stringWidth(" ");
        }
        g.setColor(Color.black);
        StringTokenizer st = new StringTokenizer(text);
        int x = 0;
        int nextx;
        int y = 0;
        String word, sp;
        int wordCount = 0;
        String line = "";
        while (st.hasMoreTokens()) {
            word = st.nextToken();
            if (word.equals("<P>")) {
                drawString(g, line, wordCount, fm.stringWidth(line), y + bl);
                line = "";
                wordCount = 0;
                x = 0;
                y = y + (fh * 2);
            } else {
                int w = fm.stringWidth(word);
                if ((nextx = (x + space + w)) > d.width) {
                    drawString(g, line, wordCount, fm.stringWidth(line), y + bl);
                    line = "";
                    wordCount = 0;
                    x = 0;
                    y = y + fh;
                }
                if (x != 0) {
                    sp = " ";
                } else {
                    sp = "";
                }
                line = line + sp + word;
                x = x + space + w;
                wordCount++;
            }
        }
        drawString(g, line, wordCount, fm.stringWidth(line), y + bl);
    }

    public void drawString(Graphics g, String line, int wc, int lineW, int y) {
        switch (align) {
            case LEFT:
                g.drawString(line, 0, y);
                break;
            case RIGHT:
                g.drawString(line, d.width - lineW, y);
                break;
            case CENTER:
                g.drawString(line, (d.width - lineW) / 2, y);
                break;
            case LEFTRIGHT:
                if (lineW < (int) (d.width * .75)) {
                    g.drawString(line, 0, y);
                } else {
                    int toFill = (d.width - lineW) / wc;
                    int nudge = d.width - lineW - (toFill * wc);
                    int s = fm.stringWidth(" ");
                    StringTokenizer st = new StringTokenizer(line);
                    int x = 0;
                    while (st.hasMoreTokens()) {
                        String word = st.nextToken();
                        g.drawString(word, x, y);
                        if (nudge > 0) {
                            x = x + fm.stringWidth(word) + space + toFill + 1;
                            nudge--;
                        } else {
                            x = x + fm.stringWidth(word) + space + toFill;
                        }
                    }
                }
                break;
        }
    }

    public static class MyNewMouseAdapter extends MouseAdapter {
        TextLayout tl;

        public MyNewMouseAdapter(TextLayout tl) {
            this.tl = tl;
        }

        public void mouseClicked(MouseEvent me) {
            tl.align = (tl.align + 1) % 4;
            tl.repaint();
        }
    }
}
