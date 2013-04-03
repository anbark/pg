package com.fujitsu.fs.java.pg.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.io.IOException;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
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

//        JPanel container = new JPanel();
//        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
//        container.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
//        getContentPane().add(container);

        JPanel optionsPanel = new JPanel();
        optionsPanel.setBackground(Color.YELLOW);
        optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.Y_AXIS));

        // --- Options -----------------------------------------------------------------------------

        optionsPanel.setBorder(BorderFactory.createTitledBorder(
                messages.getProperty("pg.options.title")));
        getContentPane().add(optionsPanel);

        caseCheckBox = new JCheckBox(messages.getProperty("pg.checkbox.case"));
        caseCheckBox.setBackground(Color.RED);
        optionsPanel.add(caseCheckBox);

        lettersCheckBox = new JCheckBox(messages.getProperty("pg.checkbox.letters"));
        lettersCheckBox.setBackground(Color.GREEN);
        optionsPanel.add(lettersCheckBox);

        numbersCheckBox = new JCheckBox(messages.getProperty("pg.checkbox.numbers"));
        numbersCheckBox.setBackground(Color.CYAN);
        optionsPanel.add(numbersCheckBox);

        SwingUtils.makeSameWidth(caseCheckBox, lettersCheckBox, numbersCheckBox);

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
