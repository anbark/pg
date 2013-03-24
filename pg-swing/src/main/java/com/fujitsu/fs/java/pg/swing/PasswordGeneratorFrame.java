package com.fujitsu.fs.java.pg.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.HeadlessException;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

public class PasswordGeneratorFrame extends JFrame {

    private JButton generateButton;

    private JTextField passwordField;

    private JSpinner lengthSpinner;

    private JCheckBox caseCheckBox;
    private JCheckBox lettersCheckBox;
    private JCheckBox numbersCheckBox;

    private Properties messages;

    public PasswordGeneratorFrame() throws HeadlessException {
        messages = new Properties();
        try {
            messages.load(getClass().getResourceAsStream(
                    "/com/fujitsu/fs/java/pg/messages.properties"));
        } catch (IOException e) {
            System.err.println("Error loading messages");
            e.printStackTrace();
        }
        initGUI();
    }

    private void initGUI() {
        setTitle(messages.getProperty("pg.frame.title"));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        caseCheckBox = new JCheckBox(messages.getProperty("pg.checkbox.case"));
        lettersCheckBox = new JCheckBox(messages.getProperty("pg.checkbox.letters"));
        numbersCheckBox = new JCheckBox(messages.getProperty("pg.checkbox.numbers"));
        numbersCheckBox.setBackground(Color.RED);

        getContentPane().add(caseCheckBox, BorderLayout.PAGE_START);
        getContentPane().add(lettersCheckBox);
        getContentPane().add(numbersCheckBox, BorderLayout.PAGE_END);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        PasswordGeneratorFrame frame = new PasswordGeneratorFrame();
    }

}
