package GUIForms;

import javax.swing.*;
import java.awt.*;
import java.util.jar.Attributes;

/**
 * The GUIForms.GUI class is responsible for displaying the current state
 * of the gameboard
 */
public class GUI {

    /**
     * Default constructor
     */
    public GUI() {
        mainframe();
    }

    public static WindowSize windowSize;

    public static final JFrame frame = new JFrame("azul");

    public static void mainframe() {

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        JLabel label = new JLabel("Menu");
        JButton button = new JButton();
        button.setText("options");
        label.setBounds(200,100,100,100);
        button.setBounds(200,200,100,100);
        panel.add(label);
        panel.add(button);
        frame.add(panel);
        frame.setResizable(false);
        frame.setSize(1600, 900);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        button.addActionListener(e -> {
            Options options = new Options();
            frame.add(options.getPanel1());
            panel.setVisible(false);
        });
    }


    public static void main(String[] args) {
        new GUI();
    }

    /**
     * Atributes of the GUIForms.GUI
     * (not filled so as not to impose concept)
     */
    private Attributes atributes;

    /**
     * Method that updates the current state of the gameboard
     */
    public void update() {
        // TODO implement here
    }

}