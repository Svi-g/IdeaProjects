package CoolPack;
import java.awt.*;
import java.awt.event.*;

public class CardLayoutDemo extends Frame implements ActionListener, MouseListener {
    Checkbox windowsXP, windows7, windows8, android, solaris, mac;
    Panel osCards;
    CardLayout cardLO;
    Button Win, Other;

    public CardLayoutDemo() {
        super("Card Layout Demo");
        Win = new Button("Windows");
        Other = new Button("Other");
        setLayout(new FlowLayout());
        // Set the visibility of buttons
        Win.setVisible(true);
        Other.setVisible(true);

        add(Win);
        add(Other);
        cardLO = new CardLayout();
        osCards = new Panel();
        osCards.setLayout(cardLO); // set panel layout to card layout
        windowsXP = new Checkbox("Windows XP", null, true);
        windows7 = new Checkbox("Windows 7", null, false);
        windows8 = new Checkbox("Windows 8", null, false);
        android = new Checkbox("Android");
        solaris = new Checkbox("Solaris");
        mac = new Checkbox("Mac OS");

        // add Windows check boxes to a panel
        Panel winPan = new Panel();
        winPan.add(windowsXP);
        winPan.add(windows7);
        winPan.add(windows8);

        // Add other OS check boxes to a panel
        Panel otherPan = new Panel();
        otherPan.add(android);
        otherPan.add(solaris);
        otherPan.add(mac);

        // add panels to card deck panel
        osCards.add(winPan, "Windows");
        osCards.add(otherPan, "Other");

        // add cards to the main applet panel
        add(osCards);

        // register to receive action events
        Win.addActionListener(this);
        Other.addActionListener(this);

        // register mouse events
        addMouseListener(this);

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
    // Cycle through panels.
    public void mousePressed(MouseEvent me) {
        cardLO.next(osCards);
    }

    // Provide empty implementations for the other MouseListener methods.
    public void mouseClicked(MouseEvent me) {
    }
    public void mouseEntered(MouseEvent me) {
    }
    public void mouseExited(MouseEvent me) {
    }
    public void mouseReleased(MouseEvent me) {
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == Win) {
            cardLO.show(osCards, "Windows");
        }
        else {
            cardLO.show(osCards, "Other");
        }

    }

    public static void main(String... args) {
        CardLayoutDemo appWindow = new CardLayoutDemo();
    }

}
