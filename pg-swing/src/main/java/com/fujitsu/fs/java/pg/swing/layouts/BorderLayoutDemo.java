package com.fujitsu.fs.java.pg.swing.layouts;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class BorderLayoutDemo  extends JFrame {

    public BorderLayoutDemo() {
        initGUI();
    }

    private void initGUI() {
        JPanel container = new JPanel();

        container.setLayout(new BorderLayout(6, 18));
        container.add(new JButton("PAGE_START"), BorderLayout.PAGE_START);
        container.add(new JButton("LINE_START"), BorderLayout.LINE_START);
        container.add(new JButton("CENTER"), BorderLayout.CENTER);
        container.add(new JButton("LINE_END"), BorderLayout.LINE_END);
        container.add(new JButton("PAGE_END"), BorderLayout.PAGE_END);

        getContentPane().add(container);
        pack();
    }

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BorderLayoutDemo().setVisible(true);
            }
        });
    }

}
