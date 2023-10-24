package CoolPack;

import java.awt.*;
import java.awt.event.*;

class SampleDialog extends Dialog implements ActionListener {
    SampleDialog(Frame parent, String title) {
        super(parent, title, false);
        setLayout(new FlowLayout());
        setSize(300, 200);
        add(new Label("Press this button:"));
        Button b;
        add(b = new Button("Cancel"));
        b.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        dispose();
    }

    public void paint(Graphics g) {
        g.drawString("This is in the dialog box", 10, 70);
    }
}

class MyMenuFrame extends Frame {
    String msg = "";
    CheckboxMenuItem debug, test;

    MyMenuFrame(String title) {
        super(title);
        // create menu bar and add it to frame
        MenuBar mbar = new MenuBar();
        setMenuBar(mbar);

        // create the menu items
        Menu file = new Menu("File");
        MenuItem item1, item2, item3, item4;
        file.add(item1 = new MenuItem("New..."));
        file.add(item2 = new MenuItem("Open..."));
        file.add(item3 = new MenuItem("Close"));
        file.add(new MenuItem("-"));
        file.add(item4 = new MenuItem("Quit..."));
        mbar.add(file);

        Menu edit = new Menu("Edit");
        MenuItem item5, item6, item7;
        edit.add(item5 = new MenuItem("Cut"));
        edit.add(item6 = new MenuItem("Copy"));
        edit.add(item7 = new MenuItem("Paste"));
        edit.add(new MenuItem("-"));
        Menu sub = new Menu("Special", true);
        MenuItem item8, item9, item10;
        sub.add(item8 = new MenuItem("First"));
        sub.add(item9 = new MenuItem("Second"));
        sub.add(item10 = new MenuItem("Third"));
        edit.add(sub);

        // these are checkable menu items
        debug = new CheckboxMenuItem("Debug");
        edit.add(debug);
        test = new CheckboxMenuItem("Testing");
        edit.add(test);
        mbar.add(edit);

        NewMenuHandler handler = new NewMenuHandler(this);
        // register it to receive those events
        item1.addActionListener(handler);
        item2.addActionListener(handler);
        item3.addActionListener(handler);
        item4.addActionListener(handler);
        item5.addActionListener(handler);
        item6.addActionListener(handler);
        item7.addActionListener(handler);
        item8.addActionListener(handler);
        item9.addActionListener(handler);
        item10.addActionListener(handler);
        debug.addItemListener(handler);
        test.addItemListener(handler);

        // create an object to handle window events
        MyWinAdapter adapter = new MyWinAdapter(this);
        // register it to receive those events
        addWindowListener(adapter);
    }

    public void paint(Graphics g) {
        g.drawString(msg, 10, 200);
        if (debug.getState())
            g.drawString("Debug is on.", 10, 220);
        else
            g.drawString("Debug is off.", 10, 220);
        if (test.getState())
            g.drawString("Testing is on.", 10, 240);
        else
            g.drawString("Testing is off.", 10, 240);
    }
}

class MyWinAdapter extends WindowAdapter {
    MyMenuFrame menuFrame;

    public MyWinAdapter(MyMenuFrame menuFrame) {
        this.menuFrame = menuFrame;
    }

    public void windowClosing(WindowEvent we) {
        menuFrame.dispose();
    }
}

class NewMenuHandler implements ActionListener, ItemListener {
    MyMenuFrame menuFrame;

    public NewMenuHandler(MyMenuFrame menuFrame) {
        this.menuFrame = menuFrame;
    }

    // Handle action events.
    public void actionPerformed(ActionEvent ae) {
        String msg = "You selected ";
        String arg = ae.getActionCommand();
        // Activate a dialog box when New is selected.
        switch (arg) {
            case "New..." -> {
                msg += "New.";
                SampleDialog d = new SampleDialog(menuFrame, "New Dialog Box");
                d.setVisible(true);
            }
            // Try defining other dialog boxes for these options.
            case "Open..." -> msg += "Open.";
            case "Close" -> msg += "Close.";
            case "Quit..." -> msg += "Quit.";
            case "Edit" -> msg += "Edit.";
            case "Cut" -> msg += "Cut.";
            case "Copy" -> msg += "Copy.";
            case "Paste" -> msg += "Paste.";
            case "First" -> msg += "First.";
            case "Second" -> msg += "Second.";
            case "Third" -> msg += "Third.";
            case "Debug" -> msg += "Debug.";
            case "Testing" -> msg += "Testing.";
        }
        menuFrame.msg = msg;
        menuFrame.repaint();
    }

    public void itemStateChanged(ItemEvent ie) {
        menuFrame.repaint();
    }
}

public class DialogDemo {
    public static void main(String... args) {
        MyMenuFrame f = new MyMenuFrame("Menu Demo");
        f.setTitle("Menu Demo");
        f.setSize(400, 300);
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }
}
