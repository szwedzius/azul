package GUIForms;

import Mechanics.GUIGAME;

import javax.swing.*;
import java.awt.*;

public class MainFrame {
    private JButton SETTINGSButton;
    private JButton ONLINEButton;
    private JButton LOCALButton;
    public JPanel AZUL;
    private JLabel logoLabel;
    private static int isGameOnline=0;

    public static int getIsGameOnline() {
        return isGameOnline;
    }

    private static int init =0;

    public JPanel getAZUL() {
        return AZUL;
    }

    public MainFrame() {
        logoLabel.setIcon(HelpfulMethodsGuiJava.getImageIconWithSize("img/logo.png", 600, 320));

        LOCALButton.setIcon(HelpfulMethodsGuiJava.getImageIconWithSize("img/localButton.png", 291, 150));
        LOCALButton.setBorder(BorderFactory.createEmptyBorder());
        LOCALButton.setOpaque(false);
        LOCALButton.setContentAreaFilled(false);
        LOCALButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        ONLINEButton.setIcon(HelpfulMethodsGuiJava.getImageIconWithSize("img/onlineButton.png", 291, 150));
        ONLINEButton.setBorder(BorderFactory.createEmptyBorder());
        ONLINEButton.setOpaque(false);
        ONLINEButton.setContentAreaFilled(false);
        ONLINEButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        SETTINGSButton.setIcon(HelpfulMethodsGuiJava.getImageIconWithSize("img/settingsButton.png", 291, 150));
        SETTINGSButton.setBorder(BorderFactory.createEmptyBorder());
        SETTINGSButton.setOpaque(false);
        SETTINGSButton.setContentAreaFilled(false);
        SETTINGSButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        //LOCALButton.setBorderPainted(false);

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
                    isGameOnline=1;
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

        SETTINGSButton.addMouseListener(
                HelpfulMethodsGuiJava.hoverEvents(
                        SETTINGSButton,
                        "img/settingsButton.png",
                        "img/settingsButtonHover.png",
                        291,
                        150));

        LOCALButton.addMouseListener(
                HelpfulMethodsGuiJava.hoverEvents(
                        LOCALButton,
                        "img/localButton.png",
                        "img/localButtonHover.png",
                        291,
                        150));

        ONLINEButton.addMouseListener(
                HelpfulMethodsGuiJava.hoverEvents(
                        ONLINEButton,
                        "img/onlineButton.png",
                        "img/onlineButtonHover.png",
                        291,
                        150));
    }
}
