package CoolPack;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class MemoryImageGenerator extends Frame {
    Image img;

    public MemoryImageGenerator() {
        super("Memory Image Gen");
        setSize(400, 400);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        // Get the size of the frame after setting it.
        Dimension d = getSize();
        int w = d.width;
        int h = d.height;
        int[] pixels = new int[w * h];
        int i = 0;
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                int r = (x ^ y) & 0xff;
                int g = (x * 2 ^ y * 2) & 0xff;
                int b = (x * 4 ^ y * 4) & 0xff;
                pixels[i++] = (255 << 24) | (r << 16) | (g << 8) | b;
            }
        }
        img = createImage(new MemoryImageSource(w, h, pixels, 0, w));
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, this);
    }

    public static void main(String... args) {
        MemoryImageGenerator appWindow = new MemoryImageGenerator();
        appWindow.setVisible(true);
    }
}
