package com.fujitsu.fs.java.pg.swing.layouts;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class HelloFrame extends JFrame {

    public HelloFrame() {
        setTitle("Hello Frame");

        JButton helloButton = new JButton("Say Hello");
        helloButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(HelloFrame.this, "Hello!", "Message",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        getContentPane().add(helloButton);
        pack();
    }

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new HelloFrame().setVisible(true);
            }
        });
    }

}
