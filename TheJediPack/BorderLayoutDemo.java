package CoolPack;

import java.awt.*;
import java.awt.event.*;
public class BorderLayoutDemo extends Frame {

    public BorderLayoutDemo() {
        super("Border Demo");
        // set background colour
        setBackground(Color.cyan);
        setLayout(new BorderLayout());


        add(new Button("This is across the top."),
                BorderLayout.NORTH);
        add(new Label("The footer message might go here."),
                BorderLayout.SOUTH);
        add(new Button("Right"), BorderLayout.EAST);
        add(new Button("Left"), BorderLayout.WEST);
        String msg = "The reasonable man adapts " +
                "himself to the world;\n" +
                "the unreasonable one persists in " +
                "trying to adapt the world to himself.\n" +
                "Therefore all progress depends " +
                "on the unreasonable man.\n\n" +
                " - George Bernard Shaw\n\n";
        add(new TextArea(msg), BorderLayout.CENTER);

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

    // add insets
    public Insets getInsets() {
        return new Insets(10, 10, 10, 10);
    }

    public static void main(String... args) {
        BorderLayoutDemo appWindow = new BorderLayoutDemo();
    }

}
