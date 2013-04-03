package com.fujitsu.fs.java.pg.swing;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class GridPG extends JFrame {

    public GridPG() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());



        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3, 6, 0));
        buttonPanel.add(new JButton("OK"));
        buttonPanel.add(new JButton("Cancel"));

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        mainPanel.add(new JTextArea(), c);

        c.fill = GridBagConstraints.NONE;
        c.gridy = 1;
        c.anchor = GridBagConstraints.LAST_LINE_END;
        mainPanel.add(buttonPanel, c);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(mainPanel, BorderLayout.CENTER);
        pack();
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GridPG().setVisible(true);
            }
        });
    }
}