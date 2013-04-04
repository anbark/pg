package com.fujitsu.fs.java.pg.swing;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class PasswordGeneratorFrame extends JFrame {

    private static final String MESSAGES = "com.fujitsu.fs.java.pg.messages";

    private JButton generateButton;

    private JTextField passwordField;

    private JSpinner lengthSpinner;
    private JLabel lengthLabel;

    private JCheckBox caseCheckBox;
    private JCheckBox lettersCheckBox;
    private JCheckBox numbersCheckBox;

    private ResourceBundle messages;

    public PasswordGeneratorFrame() throws HeadlessException {
        messages = ResourceBundle.getBundle(MESSAGES);
        initGUI();
    }

    private void initGUI() {
        setTitle(messages.getString("pg.frame.title"));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        getContentPane().add(mainPanel);

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1.0;
        c.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(createOptionsPanel(), c);

        pack();
    }

    private JPanel createOptionsPanel() {
        JPanel optionsPanel = new JPanel();
        optionsPanel.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        //optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.Y_AXIS));
        optionsPanel.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        caseCheckBox = new JCheckBox(messages.getString("pg.checkbox.case"));
        optionsPanel.add(caseCheckBox);

        lettersCheckBox = new JCheckBox(messages.getString("pg.checkbox.letters"));
        optionsPanel.add(lettersCheckBox);

        numbersCheckBox = new JCheckBox(messages.getString("pg.checkbox.numbers"));
        optionsPanel.add(numbersCheckBox);

        lengthLabel = new JLabel(messages.getString("pg.spinner.length"));

        SpinnerModel lengthSpinnerModel = new SpinnerNumberModel(6, 2, 128, 1);
        lengthSpinner = new JSpinner(lengthSpinnerModel);
        optionsPanel.add(lengthSpinner);

//        JPanel optionsTitledPanel = new JPanel(new BorderLayout());
//        optionsTitledPanel.setBorder(BorderFactory.createTitledBorder(
//                messages.getString("pg.options.title")));
//        optionsTitledPanel.add(optionsPanel);

        return optionsPanel;
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
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PasswordGeneratorFrame().setVisible(true);
            }
        });
    }

}
