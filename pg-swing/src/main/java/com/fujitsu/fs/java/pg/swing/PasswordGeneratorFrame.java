package com.fujitsu.fs.java.pg.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.io.IOException;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class PasswordGeneratorFrame extends JFrame {

    private static final String MESSAGES = "/com/fujitsu/fs/java/pg/messages.properties";

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
            messages.load(getClass().getResourceAsStream(MESSAGES));
        } catch (IOException e) {
            System.err.println("Error loading messages");
            e.printStackTrace();
        }
        initGUI();
    }

    private void initGUI() {
        setTitle(messages.getProperty("pg.frame.title"));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.Y_AXIS));
        optionsPanel.setBorder(BorderFactory.createTitledBorder(
                messages.getProperty("pg.options.title")));
        caseCheckBox = new JCheckBox(messages.getProperty("pg.checkbox.case"));
        optionsPanel.add(caseCheckBox);
        lettersCheckBox = new JCheckBox(messages.getProperty("pg.checkbox.letters"));
        optionsPanel.add(lettersCheckBox);
        numbersCheckBox = new JCheckBox(messages.getProperty("pg.checkbox.numbers"));
        optionsPanel.add(numbersCheckBox);

        getContentPane().add(optionsPanel);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
//        try {
//            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (Exception e) {
//            // If Nimbus is not available, you can set the GUI to another look and feel.
//        }
        JFrame.setDefaultLookAndFeelDecorated(true);
        PasswordGeneratorFrame frame = new PasswordGeneratorFrame();
    }

}
