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
    private static int ClickedNumberOfPlayers;

    public static int getClickedNumberOfPlayers() {
        return ClickedNumberOfPlayers;
    }

    public JPanel getPLAYERS() {
        return PLAYERS;
    }

    public NumberOfPlayers() {
        //GUI.frame.add(PLAYERS);
        //PLAYERS.setVisible(true);

        /**
         * ważne - zakomentowane są GUIGAME.choosePlayerNumber(), ze względu na brak dokończonej metody
         * w klasie GUIGAME
         */
        // TODO disclaimer nad ^^^^
        a1Button.addActionListener(e -> {//GUIGAME.choosePlayerNumber(1);
            ClickedNumberOfPlayers=1;
            PLAYERS.setVisible(false);
            ChoosePlayerNames names = new ChoosePlayerNames();
            GUI.frame.add(names.getPanel1());
            names.getPanel1().setVisible(true);

        });
        a2Button.addActionListener(e -> {//GUIGAME.choosePlayerNumber(2);
            ClickedNumberOfPlayers=2;
            PLAYERS.setVisible(false);
            ChoosePlayerNames names = new ChoosePlayerNames();
            GUI.frame.add(names.getPanel1());
            names.getPanel1().setVisible(true);
        });
        a3Button.addActionListener(e -> {//GUIGAME.choosePlayerNumber(3);
            ClickedNumberOfPlayers=3;
            PLAYERS.setVisible(false);
            ChoosePlayerNames names = new ChoosePlayerNames();
            GUI.frame.add(names.getPanel1());
            names.getPanel1().setVisible(true);
        });
        a4Button.addActionListener(e -> {//GUIGAME.choosePlayerNumber(4);
            PLAYERS.setVisible(false);
            ClickedNumberOfPlayers=4;
            ChoosePlayerNames names = new ChoosePlayerNames();
            GUI.frame.add(names.getPanel1());
            names.getPanel1().setVisible(true);
        });
        returnButton.addActionListener(e -> {
            MainFrame azulMenu = new MainFrame();
            azulMenu.AZUL.setVisible(true);
            getPLAYERS().setVisible(false);
        });
    }

}
