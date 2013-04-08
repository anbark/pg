package com.fujitsu.fs.java.pg.swing.mig;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import net.miginfocom.swing.MigLayout;

public class AddUserFrame extends JFrame {

    public AddUserFrame() {
        initGUI();
    }

    private void initGUI() {
        setTitle("Add User");

        JPanel panel = new JPanel(new MigLayout("fillx, insets dialog", "[align label|fill,grow]"));

        panel.add(new JLabel("Username:"));
        panel.add(new JTextField(20), "wrap");
        panel.add(new JLabel("First Name:"));
        panel.add(new JTextField(20), "wrap");
        panel.add(new JLabel("Address:"), "aligny top");
        panel.add(new JTextArea(5,  20), "grow, push, wrap 18");

        panel.add(new JButton("Help"), "tag help, sizegroup button, span, split 3");
        panel.add(new JButton("Add"), "tag ok, sizegroup button");
        panel.add(new JButton("Cancel"), "tag cancel, sizegroup button");

        add(panel);
        pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            // executed asynchronously on the AWT event dispatching thread
            public void run() {
                new AddUserFrame().setVisible(true);
            }
        });

    }

}

