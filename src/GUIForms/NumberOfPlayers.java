package GUIForms;

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
    }
}
