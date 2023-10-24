package CoolPack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

// This was hard, but we did it joe
public class ImageFilterDemo extends JFrame implements ActionListener {
    Image img;
    Image fimg;
    LoadedImage lim;
    JLabel lab;
    JButton reset;
    JButton greyscaleButton;
    JButton invertButton;
    JButton contrastButton;
    JButton blurButton;
    JButton sharpenButton;

    public ImageFilterDemo() {
        super("Image Filter Demo");
        setLayout(new BorderLayout());

        JPanel p = new JPanel();
        add(p, BorderLayout.SOUTH);

        reset = new JButton("Reset");
        reset.addActionListener(this);
        p.add(reset);

        greyscaleButton = new JButton("Greyscale");
        greyscaleButton.addActionListener(this);
        p.add(greyscaleButton);

        invertButton = new JButton("Invert");
        invertButton.addActionListener(this);
        p.add(invertButton);

        contrastButton = new JButton("Contrast");
        contrastButton.addActionListener(this);
        p.add(contrastButton);

        blurButton = new JButton("Blur");
        blurButton.addActionListener(this);
        p.add(blurButton);

        sharpenButton = new JButton("Sharpen");
        sharpenButton.addActionListener(this);
        p.add(sharpenButton);

        lab = new JLabel("");
        add(lab, BorderLayout.NORTH);

        img = Toolkit.getDefaultToolkit().getImage("Siviwe_2.png");
        lim = new LoadedImage(img);
        add(lim, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String a = "";
        try {
            a = ae.getActionCommand();
            if (a.equals("Reset")) {
                lim.set(img);
                lab.setText("Normal");
            } else {
                switch (a) {
                    case "Greyscale":
                        fimg = applyGreyscaleFilter(img);
                        break;
                    case "Invert":
                        fimg = applyInvertFilter(img);
                        break;
                    case "Contrast":
                        fimg = applyContrastFilter(img);
                        break;
                    case "Blur":
                        fimg = applyBlurFilter(img);
                        break;
                    case "Sharpen":
                        fimg = applySharpenFilter(img);
                        break;
                }
                lim.set(fimg);
                lab.setText("Filtered: " + a);
            }
            repaint();
        } catch (Exception e) {
            lab.setText("Error: " + e.getMessage());
        }
    }

    public static void main(String... args) {
        SwingUtilities.invokeLater(() -> new ImageFilterDemo());
    }

    // Filter methods
    private Image applyGreyscaleFilter(Image in) {
        BufferedImage bufferedImage = new BufferedImage(in.getWidth(this), in.getHeight(this), BufferedImage.TYPE_BYTE_GRAY);
        Graphics2D g = bufferedImage.createGraphics();
        g.drawImage(in, 0, 0, this);
        g.dispose();
        return bufferedImage;
    }

    private Image applyInvertFilter(Image in) {
        BufferedImage bufferedImage = new BufferedImage(in.getWidth(this), in.getHeight(this), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = bufferedImage.createGraphics();
        g.drawImage(in, 0, 0, this);
        for (int x = 0; x < bufferedImage.getWidth(); x++) {
            for (int y = 0; y < bufferedImage.getHeight(); y++) {
                int rgba = bufferedImage.getRGB(x, y);
                int a = (rgba >> 24) & 0xFF;
                int r = 255 - ((rgba >> 16) & 0xFF);
                int gVal = 255 - ((rgba >> 8) & 0xFF);
                int b = 255 - (rgba & 0xFF);
                int invertedColor = (a << 24) | (r << 16) | (gVal << 8) | b;
                bufferedImage.setRGB(x, y, invertedColor);
            }
        }
        g.dispose();
        return bufferedImage;
    }

    private Image applyContrastFilter(Image in) {
        BufferedImage bufferedImage = new BufferedImage(in.getWidth(this), in.getHeight(this), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = bufferedImage.createGraphics();
        g.drawImage(in, 0, 0, this);

        // Adjust contrast here
        // Example: Multiply the RGB values by 1.5 (increase contrast)
        for (int x = 0; x < bufferedImage.getWidth(); x++) {
            for (int y = 0; y < bufferedImage.getHeight(); y++) {
                int rgba = bufferedImage.getRGB(x, y);
                int a = (rgba >> 24) & 0xFF;
                int r = (int) (1.5 * ((rgba >> 16) & 0xFF));
                int gVal = (int) (1.5 * ((rgba >> 8) & 0xFF));
                int b = (int) (1.5 * (rgba & 0xFF));
                r = Math.min(255, Math.max(0, r)); // Ensure values are in the range [0, 255]
                gVal = Math.min(255, Math.max(0, gVal));
                b = Math.min(255, Math.max(0, b));
                int contrastColor = (a << 24) | (r << 16) | (gVal << 8) | b;
                bufferedImage.setRGB(x, y, contrastColor);
            }
        }
        g.dispose();
        return bufferedImage;
    }

    private Image applyBlurFilter(Image in) {
        BufferedImage bufferedImage = new BufferedImage(in.getWidth(this), in.getHeight(this), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = bufferedImage.createGraphics();
        g.drawImage(in, 0, 0, this);

        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();

        // Define the blur kernel (3x3)
        float[] blurKernel = {
                1/9f, 1/9f, 1/9f,
                1/9f, 1/9f, 1/9f,
                1/9f, 1/9f, 1/9f
        };

        BufferedImageOp blurFilter = new ConvolveOp(new Kernel(3, 3, blurKernel));
        bufferedImage = blurFilter.filter(bufferedImage, null);

        g.dispose();
        return bufferedImage;
    }

    private Image applySharpenFilter(Image in) {
        BufferedImage bufferedImage = new BufferedImage(in.getWidth(this), in.getHeight(this), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = bufferedImage.createGraphics();
        g.drawImage(in, 0, 0, this);

        // Define the sharpen kernel (3x3)
        float[] sharpenKernel = {
                0, -1, 0,
                -1, 5,-1,
                0, -1, 0
        };

        BufferedImageOp sharpenFilter = new ConvolveOp(new Kernel(3, 3, sharpenKernel));
        bufferedImage = sharpenFilter.filter(bufferedImage, null);

        g.dispose();
        return bufferedImage;
    }
    class LoadedImage extends JPanel {
        private Image image;

        public LoadedImage(Image img) {
            image = img;
        }

        public void set(Image img) {
            image = img;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (image != null) {
                g.drawImage(image, 0, 0, this);
            }
        }

        @Override
        public Dimension getPreferredSize() {
            if (image != null) {
                return new Dimension(image.getWidth(this), image.getHeight(this));
            } else {
                return super.getPreferredSize();
            }
        }
    }
}