package CoolPack;
/*
 This is a modified JApplet to demonstrate a JListDemo
 using a JFrame.
*/

import javax.swing.*;
import java.awt.*;
public class JListDemo extends JFrame {
    JList<String> jlst;
    JLabel jlab;
    JScrollPane jscrlp;
    // Create an array of cities.
    String[] Cities = {"Joburg", "Cape Town", "Gqeberha",
            "Gcuwa", "eMthatha", "Cofimvaba",
            "East London", "Pretoria", "Queenstown",
            "eQonce", "eDutywa", "George"};

    public JListDemo() {
        super("JList Demo");
        setLayout(new FlowLayout());

        // Create a JList.
        jlst = new JList<>(Cities);
// Set the list selection mode to single selection.
        jlst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
// Add the list to a scroll pane.
        jscrlp = new JScrollPane(jlst);
// Set the preferred size of the scroll pane.
        jscrlp.setPreferredSize(new Dimension(120, 90));
// Make a label that displays the selection.
        jlab = new JLabel("Choose a City");
// Add selection listener for the list.
        jlst.addListSelectionListener(le -> {
// Get the index of the changed item.
            int idx = jlst.getSelectedIndex();
// Display selection, if item was selected.
            if (idx != -1)
                jlab.setText("Current selection: " + Cities[idx]);
            else // Otherwise, reprompt.
                jlab.setText("Choose a City");
        });
        // Add the list and label to the content pane.
        add(jscrlp);
        add(jlab);
    }

    public static void main(String... args) {
        SwingUtilities.invokeLater(() -> {
            JListDemo demo = new JListDemo();
            demo.setSize(200, 100);
            demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            demo.setLocationRelativeTo(null); // Center the JFrame
            demo.setVisible(true);
        });
    }
}

