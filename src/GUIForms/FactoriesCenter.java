package GUIForms;

import javax.swing.*;
import java.awt.event.ActionListener;

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

    private static int whiteQuantity;
    private static int blackQuantity;
    private static int redQuantity;
    private static int blueQuantity;
    private static int yellowQuantity;


    public JPanel getFactoryCenterPanel(){
        return factoryCenter;
    }
    public ActionListener getToWorkshop(){
        return e -> {
          factoryCenter.setVisible(false);
          GUI.getWorkshop().getWorkshopPanel().setVisible(true);
        };
    }
    FactoriesCenter(){
        whiteQuantity = 0;
        blackQuantity = 0;
        redQuantity = 0;
        blueQuantity = 0;
        yellowQuantity = 0;
        HelpfulMethodsGuiJava.createButton("img/white.png",100,100,whiteTile);
        HelpfulMethodsGuiJava.createButton("img/black.png",100,100,blackTile);
        HelpfulMethodsGuiJava.createButton("img/blue.png",100,100,blueTile);
        HelpfulMethodsGuiJava.createButton("img/red.png",100,100,redTile);
        HelpfulMethodsGuiJava.createButton("img/yellow.png",100,100,yellowTile);
        whiteNumber.setText(String.valueOf(whiteQuantity));
        factoriesButton.addActionListener(getToWorkshop());
    }

    public static void setWhiteQuantity(int whiteQuantity) {
        FactoriesCenter.whiteQuantity = whiteQuantity;
    }

    public static void setBlackQuantity(int blackQuantity) {
        FactoriesCenter.blackQuantity = blackQuantity;
    }

    public static void setRedQuantity(int redQuantity) {
        FactoriesCenter.redQuantity = redQuantity;
    }

    public static void setBlueQuantity(int blueQuantity) {
        FactoriesCenter.blueQuantity = blueQuantity;
    }

    public static void setYellowQuantity(int yellowQuantity) {
        FactoriesCenter.yellowQuantity = yellowQuantity;
    }
}
