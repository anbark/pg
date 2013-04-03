package com.fujitsu.fs.java.pg.swing;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GridBagPG extends JFrame {

    public GridBagPG() {
        initGUI();
    }

    private void initGUI() {
        getContentPane().setBackground(Color.RED);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBackground(Color.CYAN);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        getContentPane().add(mainPanel);

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.1;
        mainPanel.add(new JButton("Push me"), c);

        c.gridx = 1;
        mainPanel.add(new JButton("Do not push me dfsasdfadf"), c);

        pack();
    }

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GridBagPG().setVisible(true);
            }
        });
    }

}
