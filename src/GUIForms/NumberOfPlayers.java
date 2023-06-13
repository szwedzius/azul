package GUIForms;

import Mechanics.GUIGAME;

import javax.swing.*;

public class NumberOfPlayers {
    private JPanel PLAYERS;
    private JButton a4Button;
    private JButton a3Button;
    private JButton a2Button;
    private JButton a1Button;
    private JButton returnButton;

    public JPanel getPLAYERS() {
        return PLAYERS;
    }

    public NumberOfPlayers() {
        GUI.frame.add(PLAYERS);
        PLAYERS.setVisible(true);
        a1Button.addActionListener(e -> GUIGAME.choosePlayerNumber(1));
        a2Button.addActionListener(e -> GUIGAME.choosePlayerNumber(2));
        a3Button.addActionListener(e -> GUIGAME.choosePlayerNumber(3));
        a4Button.addActionListener(e -> GUIGAME.choosePlayerNumber(4));
        returnButton.addActionListener(e -> {
            MainFrame azulMenu = new MainFrame();
            azulMenu.AZUL.setVisible(true);
            getPLAYERS().setVisible(false);
        });
    }
}
