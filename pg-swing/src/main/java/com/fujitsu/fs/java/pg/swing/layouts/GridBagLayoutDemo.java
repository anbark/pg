package com.fujitsu.fs.java.pg.swing.layouts;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


public class GridBagLayoutDemo  extends JFrame {

    public GridBagLayoutDemo() {
        initGUI();
    }

    private void initGUI() {
        setTitle("GridBagLayout");
        JPanel container = new JPanel();

        container.setLayout(new GridBagLayout());
        container.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets.right = 12;  // JLabel <-> JTextField
        gbc.insets.top = 6; // between fields
        gbc.gridx = 0;
        gbc.gridy = 0;
        container.add(new JLabel("First Name"), gbc);
        gbc.gridy = 1;
        container.add(new JLabel("Last Name"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        container.add(new JTextField(10), gbc);
        gbc.gridy = 1;
        container.add(new JTextField(10), gbc);
        gbc.weightx = 0;
        gbc.insets.top = 18; // between form fileds and buttons
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        container.add(new JButton("Save"), gbc);

        getContentPane().add(container);
        pack();
    }

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GridBagLayoutDemo().setVisible(true);
            }
        });
    }

}
