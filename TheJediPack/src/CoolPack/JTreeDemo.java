package CoolPack;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
public class JTreeDemo extends JFrame {
    JTree tree;
    JLabel jlab;

    public JTreeDemo() {
        super("JTree Demo");
        setLayout(new BorderLayout());

        // Create top node of tree.
        DefaultMutableTreeNode top = new DefaultMutableTreeNode("Options");
// Create subtree of "A".
        DefaultMutableTreeNode a = new DefaultMutableTreeNode("A");
        top.add(a);
        DefaultMutableTreeNode a1 = new DefaultMutableTreeNode("A1");
        a.add(a1);
        DefaultMutableTreeNode a2 = new DefaultMutableTreeNode("A2");
        a.add(a2);
// Create subtree of "B"
        DefaultMutableTreeNode b = new DefaultMutableTreeNode("B");
        top.add(b);
        DefaultMutableTreeNode b1 = new DefaultMutableTreeNode("B1");
        b.add(b1);
        DefaultMutableTreeNode b2 = new DefaultMutableTreeNode("B2");
        b.add(b2);
        DefaultMutableTreeNode b3 = new DefaultMutableTreeNode("B3");
        b.add(b3);
// Create the tree.
        tree = new JTree(top);
// Add the tree to a scroll pane.
        JScrollPane jsp = new JScrollPane(tree);
// Add the scroll pane to the content pane.
        add(jsp);
// Add the label to the content pane.
        jlab = new JLabel();
        add(jlab, BorderLayout.SOUTH);

        // Handle tree selection events.
        tree.addTreeSelectionListener(tse -> jlab.setText("Selection is " + tse.getPath()));
}
    public static void main(String... args) {
        SwingUtilities.invokeLater(() -> {
            JTreeDemo demo = new JTreeDemo();
            demo.setSize(200, 100);
            demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            demo.setLocationRelativeTo(null); // Center the JFrame
            demo.setVisible(true);
        });
    }
}