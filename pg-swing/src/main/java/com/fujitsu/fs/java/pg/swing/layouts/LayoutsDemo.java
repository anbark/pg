package com.fujitsu.fs.java.pg.swing.layouts;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

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
        tabbedPane.add(createBorderLayoutWithGapsDemo());
        tabbedPane.add(createFlowLayoutDemo());

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(tabbedPane, BorderLayout.CENTER);
        pack();
    }

    private JPanel createNullLayoutPanel() {
        JPanel container = new JPanel(null);
        container.setName("null");
        JButton button = new JButton("Button");
        // x, y, width, height
        button.setBounds(30, 50, 80, 30);
        container.add(button);
        return container;
    }

    private JPanel createFlowLayoutDemo() {
        JPanel container = new JPanel();
        container.setName("FlowLayout");
        container.setLayout(new FlowLayout());
        container.add(new JButton("First Button"));
        container.add(new JButton("Button 2"));
        container.add(new JButton("..."));
        container.add(new JButton("Last Button"));
        return container;
    }

    private JPanel createBorderLayoutDemo() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setName("BorderLayout");

        final JPanel container = new JPanel();
        container.setName("BorderLayout");
        container.setLayout(new BorderLayout());
        container.add(new JButton("PAGE_START"), BorderLayout.PAGE_START);
        container.add(new JButton("PAGE_START"), BorderLayout.LINE_START);
        container.add(new JButton("PAGE_START"), BorderLayout.CENTER);
        container.add(new JButton("PAGE_START"), BorderLayout.LINE_END);
        container.add(new JButton("PAGE_START"), BorderLayout.PAGE_END);

        mainPanel.add(container, BorderLayout.CENTER);

        JPanel paramsPanel = new JPanel();
        JLabel hgapLabel = new JLabel("hgap");
        paramsPanel.add(hgapLabel);
        final JSpinner hgapSpinner = new JSpinner(
                new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
        hgapSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int value = ((Number)hgapSpinner.getValue()).intValue();
                ((BorderLayout)container.getLayout()).setHgap(value);
                container.revalidate();
            }
        });
        paramsPanel.add(hgapSpinner);

        mainPanel.add(paramsPanel, BorderLayout.PAGE_END);

        return mainPanel;
    }

    private JPanel createBorderLayoutWithGapsDemo() {
        JPanel container = new JPanel();
        container.setName("BorderLayout with gaps");
        container.setLayout(new BorderLayout(15, 30));
        container.add(new JButton("PAGE_START"), BorderLayout.PAGE_START);
        container.add(new JButton("PAGE_START"), BorderLayout.LINE_START);
        container.add(new JButton("PAGE_START"), BorderLayout.CENTER);
        container.add(new JButton("PAGE_START"), BorderLayout.LINE_END);
        container.add(new JButton("PAGE_START"), BorderLayout.PAGE_END);
        return container;
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
