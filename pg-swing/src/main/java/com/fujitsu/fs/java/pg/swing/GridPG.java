package com.fujitsu.fs.java.pg.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class GridPG extends JFrame {

    public GridPG() {
        initGUI();
    }

    private void initGUI() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(0, 17));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));



        mainPanel.add(new JTextArea(30, 40), BorderLayout.CENTER);

        mainPanel.add(createButtonsPanel(), BorderLayout.PAGE_END);

        getContentPane().add(mainPanel, BorderLayout.CENTER);
        pack();
    }

    private JPanel createButtonsPanel() {
        JPanel buttonContainerPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3, 6, 0));
        buttonPanel.add(new JButton("OK"));
        buttonPanel.add(new JButton("Cancel"));

        buttonContainerPanel.add(buttonPanel);

        return buttonContainerPanel;
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