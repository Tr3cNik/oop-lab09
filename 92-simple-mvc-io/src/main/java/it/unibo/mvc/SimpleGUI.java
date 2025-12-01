package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final int PROPORTION = 20;
    private final JFrame frame = new JFrame("Salva il testo");
    private final Controller c;

    public SimpleGUI() {
        c = new Controller();
        JPanel panel = new JPanel(new BorderLayout());
        JTextArea text = new JTextArea();
        JButton button = new JButton("Save");
        panel.add(text, BorderLayout.NORTH);
        panel.add(button, BorderLayout.SOUTH);
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    c.saveInput(text.getText());
                } catch (IOException e1) {
                    System.out.println("sono esploso"); // NOPMD
                }
            }
        });
    }

    public void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        new SimpleGUI().display();
    }

}
