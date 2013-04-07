package com.fujitsu.fs.java.pg.swing.threads;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class FileCopy extends JFrame {

    public FileCopy(File from, File to) {
        this.setTitle("File Copy");

        JPanel mainPanel = new JPanel();

        final JProgressBar progressBar = new JProgressBar();
        mainPanel.add(progressBar);
        final FileCopyWorker fileCopyWorker = new FileCopyWorker(from, to);
        fileCopyWorker.addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().equals("progress")) {
                    progressBar.setValue((Integer)evt.getNewValue());
                }
            }
        });

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fileCopyWorker.cancel(true);
            }
        });
        mainPanel.add(cancelButton);

        getContentPane().add(mainPanel);
        pack();
        fileCopyWorker.execute();
    }

    class FileCopyWorker extends SwingWorker<Long, Void> {
        private final File from;
        private final File to;

        public FileCopyWorker(File from, File to) {
            this.from = from;
            this.to = to;
        }

        protected Long doInBackground() throws Exception {
            long size = from.length();
            BufferedReader in = null;
            BufferedWriter out = null;
            try {
                in = new BufferedReader(new FileReader(from));
                out = new BufferedWriter(new FileWriter(to));
                long copied = 0;
                int c;
                while (!isCancelled() && (c = in.read()) != -1) {
                    out.write(c);
                    double complete = ++copied/(double)size * 100;
                    setProgress((int)complete);
                }
            } finally {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            }
            return size;
        }
    }

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                if (args.length != 2) {
                    System.err.println("Usage: FileCopy SRC DEST");
                    System.exit(1);
                }
                new FileCopy(new File(args[0]), new File(args[1])).setVisible(true);
            }
        });
    }

}
