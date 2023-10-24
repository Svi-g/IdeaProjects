package CoolPack;
/*
This is the updated version of the Menu Demo.
This version includes actions and other cool stuff the
OG demo didn't have.

Please see the notes for clarity.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuDemo2 implements ActionListener {
    /*
    Ukhumbule, you can make JFrame an instance variable,
    but for versatility, it is best to leave it as a
    local variable.
     */
    JLabel jlab;
    JMenuBar jmb;
    JToolBar jtb;
    JPopupMenu jpu;

    DebugAction setAct;
    DebugAction clearAct;
    DebugAction resumeAct;

    MenuDemo2() {
// Create a new JFrame container.
        JFrame jfrm = new JFrame("Menu Demo v2");
// Use default border layout.
// Give the frame an initial size.
        jfrm.setSize(360, 200);
// Terminate the program when the user closes the application.
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// Create a label that will display the menu selection.
        jlab = new JLabel();
// Create the menu bar.
        jmb = new JMenuBar();
// Make the File menu.
        makeFileMenu();
// Construct the Debug actions.
        makeActions();
// Make the toolbar.
        makeToolBar();
// Make the Options menu.
        makeOptionsMenu();
// Make the Help menu.
        makeHelpMenu();
// Make the Edit popup menu.
        makeEditPUMenu();
// Add a listener for the popup trigger.
        jfrm.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                if (me.isPopupTrigger())
                    jpu.show(me.getComponent(), me.getX(), me.getY());
            }

            public void mouseReleased(MouseEvent me) {
                if (me.isPopupTrigger())
                    jpu.show(me.getComponent(), me.getX(), me.getY());
            }
        });
// Add the label to the center of the content pane.
        jfrm.add(jlab, SwingConstants.CENTER);
// Add the toolbar to the north position of
// the content pane.
        jfrm.add(jtb, BorderLayout.NORTH);
// Add the menu bar to the frame.
        jfrm.setJMenuBar(jmb);
// Display the frame.
        jfrm.setVisible(true);
    }

    // Handle menu item action events.
// This does NOT handle events generated
// by the Debug options.
    public void actionPerformed(ActionEvent ae) {
// Get the action command from the menu selection.
        String comStr = ae.getActionCommand();
// If user chooses Exit, then exit the program.
        if (comStr.equals("Exit")) System.exit(0);
// Otherwise, display the selection.
        jlab.setText(comStr + " Selected");
    }

    // An action class for the Debug menu
// and toolbar.
    class DebugAction extends AbstractAction {
        public DebugAction(String name, Icon image, int mnem,
                           int accel, String tTip) {
            super(name, image);
            putValue(ACCELERATOR_KEY,
                    KeyStroke.getKeyStroke(accel,
                            InputEvent.CTRL_DOWN_MASK));
            putValue(MNEMONIC_KEY, new Integer(mnem));
            putValue(SHORT_DESCRIPTION, tTip);
        }

        // Handle events for both the toolbar and the
// Debug menu.
        public void actionPerformed(ActionEvent ae) {
            String comStr = ae.getActionCommand();
            jlab.setText(comStr + " Selected");
// Toggle the enabled status of the
// Set and Clear Breakpoint options.
            if (comStr.equals("Set Breakpoint")) {
                clearAct.setEnabled(true);
                setAct.setEnabled(false);
            } else if (comStr.equals("Clear Breakpoint")) {
                clearAct.setEnabled(false);
                setAct.setEnabled(true);
            }
        }
    }

    // Create the File menu with mnemonics and accelerators.
    void makeFileMenu() {
        JMenu jmFile = new JMenu("File");
        jmFile.setMnemonic(KeyEvent.VK_F);
        JMenuItem jmiOpen = new JMenuItem("Open",
                KeyEvent.VK_O);
        jmiOpen.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_O,
                        InputEvent.CTRL_DOWN_MASK));
        JMenuItem jmiClose = new JMenuItem("Close",
                KeyEvent.VK_C);
        jmiClose.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_C,
                        InputEvent.CTRL_DOWN_MASK));
        JMenuItem jmiSave = new JMenuItem("Save",
                KeyEvent.VK_S);
        jmiSave.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_S,
                        InputEvent.CTRL_DOWN_MASK));

        JMenuItem jmiExit = new JMenuItem("Exit",
                KeyEvent.VK_E);
        jmiExit.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_E,
                        InputEvent.CTRL_DOWN_MASK));
        jmFile.add(jmiOpen);
        jmFile.add(jmiClose);
        jmFile.add(jmiSave);
        jmFile.addSeparator();
        jmFile.add(jmiExit);
        jmb.add(jmFile);
// Add the action listeners for the File menu.
        jmiOpen.addActionListener(this);
        jmiClose.addActionListener(this);
        jmiSave.addActionListener(this);
        jmiExit.addActionListener(this);
    }

    // Create the Options menu.
    void makeOptionsMenu() {
        JMenu jmOptions = new JMenu("Options");
// Create the Colors submenu.
        JMenu jmColors = new JMenu("Colors");
// Use check boxes for colors. This allows
// the user to select more than one color.
        JCheckBoxMenuItem jmiRed = new JCheckBoxMenuItem("Red");
        JCheckBoxMenuItem jmiGreen = new JCheckBoxMenuItem("Green");
        JCheckBoxMenuItem jmiBlue = new JCheckBoxMenuItem("Blue");
// Add the items to the Colors menu.
        jmColors.add(jmiRed);
        jmColors.add(jmiGreen);
        jmColors.add(jmiBlue);
        jmOptions.add(jmColors);
// Create the Priority submenu.
        JMenu jmPriority = new JMenu("Priority");
// Use radio buttons for the priority setting.
// This lets the menu show which priority is used
// but also ensures that one and only one priority
// can be selected at any one time. Notice that
// the High radio button is initially selected.
        JRadioButtonMenuItem jmiHigh =
                new JRadioButtonMenuItem("High", true);
        JRadioButtonMenuItem jmiLow =
                new JRadioButtonMenuItem("Low");
// Add the items to the Priority menu.
        jmPriority.add(jmiHigh);

        jmPriority.add(jmiLow);
        jmOptions.add(jmPriority);
// Create a button group for the radio button
// menu items.
        ButtonGroup bg = new ButtonGroup();
        bg.add(jmiHigh);
        bg.add(jmiLow);
// Now, create a Debug submenu that goes under
// the Options menu bar item. Use actions to
// create the items.
        JMenu jmDebug = new JMenu("Debug");
        JMenuItem jmiSetBP = new JMenuItem(setAct);
        JMenuItem jmiClearBP = new JMenuItem(clearAct);
        JMenuItem jmiResume = new JMenuItem(resumeAct);
// Add the items to the Debug menu.
        jmDebug.add(jmiSetBP);
        jmDebug.add(jmiClearBP);
        jmDebug.add(jmiResume);
        jmOptions.add(jmDebug);
// Create the Reset menu item.
        JMenuItem jmiReset = new JMenuItem("Reset");
        jmOptions.addSeparator();
        jmOptions.add(jmiReset);
// Finally, add the entire options menu to
// the menu bar
        jmb.add(jmOptions);
// Add the action listeners for the Options menu,
// except for those supported by the Debug menu.
        jmiRed.addActionListener(this);
        jmiGreen.addActionListener(this);
        jmiBlue.addActionListener(this);
        jmiHigh.addActionListener(this);
        jmiLow.addActionListener(this);
        jmiReset.addActionListener(this);
    }

    // Create the Help menu.
    void makeHelpMenu() {
        JMenu jmHelp = new JMenu("Help");

        // Load the image icon
        ImageIcon icon = new ImageIcon("AboutIcon.png");

        // Resize the image icon to
        Image image = icon.getImage();
        Image resizedImage = image.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon AboutIcon = new ImageIcon(resizedImage);
        JMenuItem jmiAbout = new JMenuItem("About", AboutIcon);
        jmiAbout.setToolTipText("Info about the MenuDemo program.");
        jmHelp.add(jmiAbout);
        jmb.add(jmHelp);
        // Add action listener for About.
        jmiAbout.addActionListener(this);
    }

    // Construct the actions needed by the Debug menu
// and toolbar.
    void makeActions() {
        try {
// Load the images for the actions.
            ImageIcon setIcon = new ImageIcon("settings3.png");
            ImageIcon clearIcon = new ImageIcon("clear3.png");
            ImageIcon resumeIcon = new ImageIcon("resume3.png");
// Create actions.
            setAct =
                    new DebugAction("Set Breakpoint",
                            setIcon,
                            KeyEvent.VK_S,
                            KeyEvent.VK_B,
                            "Set a break point.");
            clearAct =
                    new DebugAction("Clear Breakpoint",
                            clearIcon,
                            KeyEvent.VK_C,
                            KeyEvent.VK_L,
                            "Clear a break point.");
            resumeAct =
                    new DebugAction("Resume",
                            resumeIcon,
                            KeyEvent.VK_R,
                            KeyEvent.VK_R,
                            "Resume execution after breakpoint.");
// Initially disable the Clear Breakpoint option.
            clearAct.setEnabled(false);
        }
        catch (Exception e) {
            // Handle image loading errors here (e.g., display an error message)
            e.printStackTrace();
        }
    }

    // Create the Debug toolbar.
    void makeToolBar() {
// Create the toolbar buttons by using the actions.
        JButton jbtnSet = new JButton(setAct);
        JButton jbtnClear = new JButton(clearAct);
        JButton jbtnResume = new JButton(resumeAct);
// Create the Debug toolbar.
        jtb = new JToolBar("Breakpoints");
// Add the buttons to the toolbar.
        jtb.add(jbtnSet);
        jtb.add(jbtnClear);
        jtb.add(jbtnResume);
    }

    // Create the Edit popup menu.
    void makeEditPUMenu() {
        jpu = new JPopupMenu();
// Create the popup menu items
        JMenuItem jmiCut = new JMenuItem("Cut");
        JMenuItem jmiCopy = new JMenuItem("Copy");
        JMenuItem jmiPaste = new JMenuItem("Paste");
// Add the menu items to the popup menu.
        jpu.add(jmiCut);
        jpu.add(jmiCopy);
        jpu.add(jmiPaste);
// Add the Edit popup menu action listeners.
        jmiCut.addActionListener(this);
        jmiCopy.addActionListener(this);
        jmiPaste.addActionListener(this);
    }
    public static void main(String... args) {
// Create the frame on the event dispatching thread.
        SwingUtilities.invokeLater(MenuDemo2::new);
    }
}