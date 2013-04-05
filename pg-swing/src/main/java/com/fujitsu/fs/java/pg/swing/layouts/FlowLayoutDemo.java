package com.fujitsu.fs.java.pg.swing.layouts;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class FlowLayoutDemo  extends JFrame {

    public FlowLayoutDemo() {
        initGUI();
    }

    private void initGUI() {
        JPanel container = new JPanel();

        container.setLayout(new FlowLayout(
                FlowLayout.RIGHT, 6, 18)); //align, hgap, vgap
        container.add(new JButton("First Button"));
        container.add(new JButton("Button 2"));
        container.add(new JButton("..."));
        container.add(new JButton("Last Button"));

        getContentPane().add(container);
        pack();
    }

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FlowLayoutDemo().setVisible(true);
            }
        });
    }

}
