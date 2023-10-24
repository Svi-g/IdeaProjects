package CoolPack;
// Demonstrate a simple main menu.

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MenuDemo implements ActionListener {
    JLabel jlab;
    JPopupMenu jpu;
    JFrame jfrm;
    MenuDemo() {
// Create a new JFrame container.
        jfrm = new JFrame("Menu Demo");
        jlab = new JLabel();
// Specify FlowLayout for the layout manager.
        //remove the layout line when creating a toolbar.
        // so JFrame can automatically use a border layout.
        //jfrm.setLayout(new FlowLayout());
        jfrm.add(jlab, BorderLayout.CENTER);//you center tweak the layout here so it is centred
// Give the frame an initial size.
        jfrm.setSize(220, 200);
// Terminate the program when the user closes the application.
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// Create a label that will display the menu selection.

// Create the menu bar.
        JMenuBar jmb = new JMenuBar();
// Create the File menu.
        JMenu jmFile = new JMenu("File");
        jmFile.setMnemonic(KeyEvent.VK_F);
        JMenuItem jmiOpen = new JMenuItem("Open",
                KeyEvent.VK_O);
        jmiOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
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
        //JMenuItem jmiOpen = new JMenuItem("Open");
        //JMenuItem jmiClose = new JMenuItem("Close");
        //JMenuItem jmiSave = new JMenuItem("Save");
        //JMenuItem jmiExit = new JMenuItem("Exit");
        jmFile.add(jmiOpen);
        jmFile.add(jmiClose);
        jmFile.add(jmiSave);
        jmFile.addSeparator();
        jmFile.add(jmiExit);
        jmb.add(jmFile);
// Create the Options menu.
        JMenu jmOptions = new JMenu("Options");
        // Create the Colors submenu.
        JMenu jmColors = new JMenu("Colors");
        // Use check boxes for colors. This allows
// the user to select more than one color.
        JCheckBoxMenuItem jmiRed = new JCheckBoxMenuItem("Red");
        JCheckBoxMenuItem jmiGreen = new JCheckBoxMenuItem("Green");
        JCheckBoxMenuItem jmiBlue = new JCheckBoxMenuItem("Blue");
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
        jmPriority.add(jmiHigh);
        jmPriority.add(jmiLow);
        jmOptions.add(jmPriority);
// Create button group for the radio button menu items.
        ButtonGroup bg = new ButtonGroup();
        bg.add(jmiHigh);
        bg.add(jmiLow);
// Create the Reset menu item.
        JMenuItem jmiReset = new JMenuItem("Reset");
        jmOptions.addSeparator();
        jmOptions.add(jmiReset);
// Finally, add the entire options menu to
// the menu bar
        jmb.add(jmOptions);
        /*
        JMenu jmOptions = new JMenu("Options");
// Create the Colors submenu.
        JMenu jmColors = new JMenu("Colors");
        JMenuItem jmiRed = new JMenuItem("Red");
        JMenuItem jmiGreen = new JMenuItem("Green");
        JMenuItem jmiBlue = new JMenuItem("Blue");
        jmColors.add(jmiRed);
        jmColors.add(jmiGreen);
        jmColors.add(jmiBlue);
        jmOptions.add(jmColors);
// Create the Priority submenu.
        JMenu jmPriority = new JMenu("Priority");
        JMenuItem jmiHigh = new JMenuItem("High");
        JMenuItem jmiLow = new JMenuItem("Low");
        jmPriority.add(jmiHigh);
        jmPriority.add(jmiLow);
        jmOptions.add(jmPriority);

// Create the Reset menu item.
        JMenuItem jmiReset = new JMenuItem("Reset");
        jmOptions.addSeparator();
        jmOptions.add(jmiReset);
        // Finally, add the entire options menu to
// the menu bar
        jmb.add(jmOptions);
        */
// Create the Help menu.
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



        /*
        JMenu jmHelp = new JMenu("Help");
        ImageIcon icon = new ImageIcon("AboutIcon.png");
        JMenuItem jmiAbout = new JMenuItem("About", icon);
        jmHelp.add(jmiAbout);
        jmb.add(jmHelp);
         */
// Add action listeners for the menu items.
        jmiOpen.addActionListener(this);
        jmiClose.addActionListener(this);
        jmiSave.addActionListener(this);
        jmiExit.addActionListener(this);
        jmiRed.addActionListener(this);
        jmiGreen.addActionListener(this);
        jmiBlue.addActionListener(this);
        jmiHigh.addActionListener(this);
        jmiLow.addActionListener(this);
        jmiReset.addActionListener(this);
        jmiAbout.addActionListener(this);
// Add the label to the content pane.
        jfrm.add(jlab);
// Add the menu bar to the frame.
        jfrm.setJMenuBar(jmb);
// Display the frame.
        jfrm.setVisible(true);

// Create a Debug toolbar.
        JToolBar jtb = new JToolBar("Debug");
// Load the images.
        ImageIcon set = new ImageIcon("settings3.png");
        ImageIcon clear = new ImageIcon("clear3.png");
        ImageIcon resume = new ImageIcon("resume3.png");

// Resize the image icons
        // Resize the image icons to 20x20.
        Image img = set.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon Settings = new ImageIcon(img);
        Image foto = clear.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon Clear = new ImageIcon(foto);
        Image pic = resume.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon Resume = new ImageIcon(pic);

        // Create the toolbar buttons.
        JButton jbtnSet = new JButton(set);
        jbtnSet.setActionCommand("Set Breakpoint");
        jbtnSet.setToolTipText("Set Breakpoint");
        jbtnSet.addActionListener(this);


        JButton jbtnClear = new JButton(clear);
        jbtnClear.setActionCommand("Clear Breakpoint");
        jbtnClear.setToolTipText("Clear Breakpoint");
        jbtnClear.addActionListener(this);

        JButton jbtnResume = new JButton(resume);
        jbtnResume.setActionCommand("Resume");
        jbtnResume.setToolTipText("Resume");
        jbtnResume.addActionListener(this);

        // Add the buttons to the toolbar.
        jtb.add(jbtnSet);
        jtb.add(jbtnClear);
        jtb.add(jbtnResume);
// Add the toolbar to the north position of
// the content pane.
        jfrm.add(jtb, BorderLayout.NORTH);

// Create an Edit popup menu.
        jpu = new JPopupMenu();
// Create the popup menu items.
        JMenuItem jmiCut = new JMenuItem("Cut");
        JMenuItem jmiCopy = new JMenuItem("Copy");
        JMenuItem jmiPaste = new JMenuItem("Paste");

        //Add some action listeners for your pop up menu
        jmiCut.addActionListener(this);
        jmiCopy.addActionListener(this);
        jmiPaste.addActionListener(this);
// Add the menu items to the popup menu.
        jpu.add(jmiCut);
        jpu.add(jmiCopy);
        jpu.add(jmiPaste);
// Add a listener for the popup trigger.
        // the reason it is added to JFrame is so that
        // it can appear in every part of the content frame
        jfrm.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                if(me.isPopupTrigger())
                    //jpu.show(me.getComponent(), me.getX(), me.getY()); FYI: the advantage of using getComponent()
                    // is that the popup menu will automatically pop up relative to the invoking component.
                    jpu.show(jfrm, me.getX(), me.getY());
            }
            public void mouseReleased(MouseEvent me) {
                if(me.isPopupTrigger())
                    //jpu.show(me.getComponent(), me.getX(), me.getY()); FYI: the advantage of using getComponent()
                    // is that the popup menu will automatically pop up relative to the invoking component.
                    jpu.show(jfrm, me.getX(), me.getY());
            }
        });

    }
    // Handle menu item action events.
    public void actionPerformed(ActionEvent ae) {
// Get the action command from the menu selection.
        String comStr = ae.getActionCommand();
// If user chooses Exit, then exit the program.
        if(comStr.equals("Exit")) System.exit(0);
// Otherwise, display the selection.
        jlab.setText(comStr + " Selected");
    }
    public static void main(String... args) {
// Create the frame on the event dispatching thread.
        SwingUtilities.invokeLater(MenuDemo::new);
    }
}
