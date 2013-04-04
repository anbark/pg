package com.fujitsu.fs.java.pg.swing.layouts;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class LayoutsDemo extends JFrame {

    public LayoutsDemo() {
        setTitle("Standard Swing layout managers");

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.add(createNullLayoutPanel());
        tabbedPane.add(createBorderLayoutDemo());
        tabbedPane.add(createFlowLayoutDemo());
        tabbedPane.add(createGridLayoutDemo());

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(tabbedPane, BorderLayout.CENTER);
        pack();
    }

    private JPanel createNullLayoutPanel() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setName("null");

        final JPanel container = new JPanel(null);
        final JButton button = new JButton("Button");
        // x, y, width, height
        button.setBounds(30, 50, 80, 30);
        container.add(button);

        JPanel paramsPanel = new JPanel(new GridBagLayout());
        paramsPanel.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets.top = 6;

        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets.right = 12;
        paramsPanel.add(new JLabel("x"), gbc);
        gbc.gridy = 1;
        paramsPanel.add(new JLabel("y"), gbc);
        gbc.gridy = 2;
        paramsPanel.add(new JLabel("width"), gbc);
        gbc.gridy = 3;
        paramsPanel.add(new JLabel("height"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.insets.right = 0;
        paramsPanel.add(createNumberSpinner(new NumberSpinnerAction() {
            public void doOnValueChanged(int value) {
                Rectangle bounds = button.getBounds();
                bounds.x = value;
                button.setBounds(bounds);
                container.revalidate();
            }
        }, 30), gbc);
        gbc.gridy = 1;
        paramsPanel.add(createNumberSpinner(new NumberSpinnerAction() {
            public void doOnValueChanged(int value) {
                Rectangle bounds = button.getBounds();
                bounds.y = value;
                button.setBounds(bounds);
                container.revalidate();
            }
        }, 50), gbc);
        gbc.gridy = 2;
        paramsPanel.add(createNumberSpinner(new NumberSpinnerAction() {
            public void doOnValueChanged(int value) {
                Rectangle bounds = button.getBounds();
                bounds.width = value;
                button.setBounds(bounds);
                container.revalidate();
            }
        }, 80), gbc);
        gbc.gridy = 3;
        paramsPanel.add(createNumberSpinner(new NumberSpinnerAction() {
            public void doOnValueChanged(int value) {
                Rectangle bounds = button.getBounds();
                bounds.height = value;
                button.setBounds(bounds);
                container.revalidate();
            }
        }, 30), gbc);

        mainPanel.add(paramsPanel, BorderLayout.PAGE_END);

        mainPanel.add(container, BorderLayout.CENTER);

        return mainPanel;
    }

    private JPanel createFlowLayoutDemo() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setName("FlowLayout");

        final JPanel container = new JPanel();
        container.setLayout(new FlowLayout());
        container.add(new JButton("First Button"));
        container.add(new JButton("Button 2"));
        container.add(new JButton("..."));
        container.add(new JButton("Last Button"));

        mainPanel.add(container, BorderLayout.CENTER);

        JPanel paramsPanel = new JPanel(new GridBagLayout());
        paramsPanel.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets.top = 6;

        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets.right = 12;
        paramsPanel.add(new JLabel("hgap"), gbc);
        gbc.gridy = 1;
        paramsPanel.add(new JLabel("vgap"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.insets.right = 0;
        paramsPanel.add(createNumberSpinner(new NumberSpinnerAction() {
            public void doOnValueChanged(int value) {
                ((FlowLayout)container.getLayout()).setHgap(value);
                container.revalidate();
            }
        }, 5), gbc);
        gbc.gridy = 1;
        paramsPanel.add(createNumberSpinner(new NumberSpinnerAction() {
            public void doOnValueChanged(int value) {
                ((FlowLayout)container.getLayout()).setVgap(value);
                container.revalidate();
            }
        }, 5), gbc);

        mainPanel.add(paramsPanel, BorderLayout.PAGE_END);

        return mainPanel;
    }

    private JPanel createBorderLayoutDemo() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setName("BorderLayout");

        final JPanel container = new JPanel();
        container.setLayout(new BorderLayout());
        container.add(new JButton("PAGE_START"), BorderLayout.PAGE_START);
        container.add(new JButton("PAGE_START"), BorderLayout.LINE_START);
        container.add(new JButton("PAGE_START"), BorderLayout.CENTER);
        container.add(new JButton("PAGE_START"), BorderLayout.LINE_END);
        container.add(new JButton("PAGE_START"), BorderLayout.PAGE_END);

        mainPanel.add(container, BorderLayout.CENTER);

        JPanel paramsPanel = new JPanel(new GridBagLayout());
        paramsPanel.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets.top = 6;

        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets.right = 12;
        paramsPanel.add(new JLabel("hgap"), gbc);
        gbc.gridy = 1;
        paramsPanel.add(new JLabel("vgap"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.insets.right = 0;
        paramsPanel.add(createNumberSpinner(new NumberSpinnerAction() {
            public void doOnValueChanged(int value) {
                ((BorderLayout)container.getLayout()).setHgap(value);
                container.revalidate();
            }
        }), gbc);
        gbc.gridy = 1;
        paramsPanel.add(createNumberSpinner(new NumberSpinnerAction() {
            public void doOnValueChanged(int value) {
                ((BorderLayout)container.getLayout()).setVgap(value);
                container.revalidate();
            }
        }), gbc);

        mainPanel.add(paramsPanel, BorderLayout.PAGE_END);

        return mainPanel;
    }

    private JPanel createGridLayoutDemo() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setName("GridLayout");

        final JPanel container = new JPanel();
        container.setLayout(new GridLayout(0, 3));
        for (int i = 0; i <= 9; i++) {
            container.add(new JButton(String.valueOf(i)));
        }

        mainPanel.add(container, BorderLayout.CENTER);

        JPanel paramsPanel = new JPanel(new GridBagLayout());
        paramsPanel.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets.top = 6;

        gbc.insets.right = 12;
        paramsPanel.add(new JLabel("hgap"), gbc);
        gbc.gridy = 1;
        paramsPanel.add(new JLabel("vgap"), gbc);
        gbc.gridy = 2;
        paramsPanel.add(new JLabel("columns"), gbc);
        gbc.gridy = 3;
        paramsPanel.add(new JLabel("rows"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.insets.right = 0;
        paramsPanel.add(createNumberSpinner(new NumberSpinnerAction() {
            public void doOnValueChanged(int value) {
                ((GridLayout)container.getLayout()).setHgap(value);
                container.revalidate();
            }
        }), gbc);
        gbc.gridy = 1;
        paramsPanel.add(createNumberSpinner(new NumberSpinnerAction() {
            public void doOnValueChanged(int value) {
                ((GridLayout)container.getLayout()).setVgap(value);
                container.revalidate();
            }
        }), gbc);
        gbc.gridy = 2;
        paramsPanel.add(createNumberSpinner(new NumberSpinnerAction() {
            public void doOnValueChanged(int value) {
                ((GridLayout)container.getLayout()).setColumns(value);
                container.revalidate();
            }
        }, 3), gbc);
        gbc.gridy = 3;
        paramsPanel.add(createNumberSpinner(new NumberSpinnerAction() {
            public void doOnValueChanged(int value) {
                ((GridLayout)container.getLayout()).setRows(value);
                container.revalidate();
            }
        }), gbc);

        mainPanel.add(paramsPanel, BorderLayout.PAGE_END);

        return mainPanel;
    }

    private interface NumberSpinnerAction {
        void doOnValueChanged(int value);
    }

    private JSpinner createNumberSpinner(final NumberSpinnerAction action) {
        return createNumberSpinner(action, 0);
    }

    private JSpinner createNumberSpinner(final NumberSpinnerAction action, int value) {
        final JSpinner spinner = new JSpinner(
                new SpinnerNumberModel(value, 0, Integer.MAX_VALUE, 1));
        ((JSpinner.NumberEditor)spinner.getEditor()).getTextField().setColumns(4);
        spinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int value = ((Number)spinner.getValue()).intValue();
                action.doOnValueChanged(value);
            }
        });
        return spinner;
    }

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LayoutsDemo().setVisible(true);
            }
        });
    }

}
