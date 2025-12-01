package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame();
    private final Controller c;

    /**
     * Constructor for GUI with file chooser.
     */
    public SimpleGUIWithFileChooser() {
        c = new Controller();
        final JPanel panel = new JPanel(new BorderLayout());
        final JPanel panelNorth = new JPanel(new BorderLayout());
        final JTextField text = new JTextField();
        final JButton button = new JButton("Browse...");
        final JButton save = new JButton("Save");

        panelNorth.add(text, BorderLayout.CENTER);
        panelNorth.add(button, BorderLayout.LINE_END);
        panel.add(save, BorderLayout.SOUTH);
        panel.add(panelNorth, BorderLayout.NORTH);
        frame.setContentPane(panel);
        text.setText(c.getPath());

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final JFileChooser fileChooser = new JFileChooser();
                if (fileChooser.showSaveDialog(button) == JFileChooser.APPROVE_OPTION) {
                    c.setFile(fileChooser.getSelectedFile());
                    text.setText(c.getPath());
                } else if (fileChooser.showSaveDialog(button) != JFileChooser.CANCEL_OPTION) {
                    JOptionPane.showMessageDialog(frame, "An error has been occured");
                }
            }
        });

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    c.saveInput(text.getText());
                } catch (final IOException ex) {
                    JOptionPane.showMessageDialog(frame, "An error has been occured");
                }
            }
        });
    }

    private void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    /**
     * Application entry point.
     * 
     * @param args ignored
     */
    public static void main(final String[] args) {
        new SimpleGUIWithFileChooser().display();
    }

}
