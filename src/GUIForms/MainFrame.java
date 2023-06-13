package GUIForms;

import javax.swing.*;

import Mechanics.*;

import java.awt.*;

public class MainFrame {
    private JButton SETTINGSButton;
    private JButton ONLINEButton;
    private JButton LOCALButton;
    public JPanel AZUL;
    private JLabel logoLabel;

    private static int init =0;

    public JPanel getAZUL() {
        return AZUL;
    }

    public MainFrame() {
        ImageIcon imageIcon = new ImageIcon("img/logo.png"); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(400, 213,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        imageIcon = new ImageIcon(newimg);  // transform it back
        logoLabel.setIcon(imageIcon);
        LOCALButton.setIcon(new ImageIcon("img/localButton.png"));
        LOCALButton.setBorder(BorderFactory.createEmptyBorder());

        GUI.frame.add(AZUL);
        SETTINGSButton.addActionListener(e -> {
            Options options = new Options();
            GUI.frame.add(options.getPanel1());
            AZUL.setVisible(false);
        });
        ONLINEButton.addActionListener(e->{
            if(init ==0){
                try {
                    GUIGAME.currentPanel = AZUL;
                    GUIGAME.mainGame(2);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        LOCALButton.addActionListener(e->{
                try {
                    GUIGAME.currentPanel = AZUL;
                    GUIGAME.mainGame(1);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
        });
        //LOCALButton.addActionListener(e);
    }
}
