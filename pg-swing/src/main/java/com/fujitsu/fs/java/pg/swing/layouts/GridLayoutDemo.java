package com.fujitsu.fs.java.pg.swing.layouts;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class GridLayoutDemo  extends JFrame {

    public GridLayoutDemo() {
        initGUI();
    }

    private void initGUI() {
        setTitle("GridLayout");
        JPanel container = new JPanel();

        container.setLayout(new GridLayout(
                0, 3, 6, 18)); // rows, cols, hgap, vgap
        for (int i = 0; i <= 9; i++) {
            container.add(new JButton(String.valueOf(i)));
        }

        getContentPane().add(container);
        pack();
    }

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GridLayoutDemo().setVisible(true);
            }
        });
    }

}
