package GUIForms;

import javax.swing.*;

public class FactoriesCenter {
    private JPanel factoryCenter;
    private JPanel scoreBoard;
    private JLabel playerName1;
    private JLabel playerName4;
    private JLabel playerName3;
    private JLabel playerName2;
    private JLabel scoreboard;
    private JLabel score4;
    private JLabel score3;
    private JLabel score2;
    private JLabel score1;
    private JButton boardButton;
    private JButton factoriesButton;
    private JButton whiteTile;
    private JButton blackTile;
    private JButton blueTile;
    private JButton redTile;
    private JButton yellowTile;
    private JPanel centerTiles;
    private JLabel whiteNumber;
    private JLabel blackNumber;
    private JLabel blueNumber;
    private JLabel redNumber;
    private JLabel yellowNumber;


    public JPanel getFactoryCenterPanel(){
        return factoryCenter;
    }

    FactoriesCenter(){
        HelpfulMethodsGuiJava.createButton("img/white.png",120,120,whiteTile);
        HelpfulMethodsGuiJava.createButton("img/black.png",120,120,blackTile);
        HelpfulMethodsGuiJava.createButton("img/blue.png",120,120,blueTile);
        HelpfulMethodsGuiJava.createButton("img/red.png",120,120,redTile);
        HelpfulMethodsGuiJava.createButton("img/yellow.png",120,120,yellowTile);

    }
}
