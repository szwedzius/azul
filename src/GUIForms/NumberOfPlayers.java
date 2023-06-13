package GUIForms;

import Mechanics.GUIGAME;

import javax.swing.*;

public class NumberOfPlayers {
    private JPanel PLAYERS;
    private JButton a4Button;
    private JButton a3Button;
    private JButton a2Button;
    private JButton a1Button;

    public JPanel getPLAYERS() {
        return PLAYERS;
    }

    public NumberOfPlayers() {
        GUI.frame.add(PLAYERS);
        PLAYERS.setVisible(true);
        a3Button.addActionListener(e -> GUIGAME.choosePlayerNumber(1));
        a2Button.addActionListener(e -> GUIGAME.choosePlayerNumber(2));
        a3Button.addActionListener(e -> GUIGAME.choosePlayerNumber(3));
        a4Button.addActionListener(e -> GUIGAME.choosePlayerNumber(4));
    }
}
