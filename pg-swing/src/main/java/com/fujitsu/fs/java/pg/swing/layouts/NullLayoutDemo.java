package com.fujitsu.fs.java.pg.swing.layouts;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class NullLayoutDemo  extends JFrame {

    public NullLayoutDemo() {
        initGUI();
    }

    private void initGUI() {
        JPanel container = new JPanel();

container.setLayout(null);
JButton button = new JButton("Button");
// x, y, width, height
button.setBounds(30, 50, 80, 30);
container.add(button);

        getContentPane().add(container);
        pack();
    }

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new NullLayoutDemo().setVisible(true);
            }
        });
    }

}
