package com.fujitsu.fs.java.pg.swing.threads;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class AWTEventQueueDemo {
    private void createGUI() {
        JFrame frame = new JFrame("AWT Event Queue");
        String labelText = SwingUtilities.isEventDispatchThread() ?
                "Current thread is an AWT event dispatching thread" :
                "Current thread is not an AWT event dispatching thread";
        frame.add(new JLabel(labelText));
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        SwingUtilities.invokeLater(new Runnable() {
            // executed asynchronously on the AWT event dispatching thread
            public void run() {
                new AWTEventQueueDemo().createGUI();
            }
        });
    }
}
