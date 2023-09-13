package CoolPack;
import java.awt.*;
import java.awt.event.*;


public class TextAreaDemo extends Frame {

    public TextAreaDemo() {
        super("Text Area Demo");
        setLayout(new FlowLayout());
        String val =
                "Java 8 is the latest version of the most\n" +
                        "widely-used computer language for Internet programming.\n" +
                        "Building on a rich heritage, Java has advanced both\n" +
                        "the art and science of computer language design.\n\n" +
                        "One of the reasons for Java's ongoing success is its\n" +
                        "constant, steady rate of evolution. Java has never stood\n" +
                        "still. Instead, Java has consistently adapted to the\n" +
                        "rapidly changing landscape of the networked world.\n" +
                        "Moreover, Java has often led the way, charting the\n" +
                        "course for others to follow.";
        TextArea text = new TextArea(val, 10, 30);
        add(text);

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

    public static void main(String... args) {
        TextAreaDemo appWindow = new TextAreaDemo();
    }
}
