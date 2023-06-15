package GUIForms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FactoriesCenter {
    private static FactoriesCenter INSTANCE;
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

    private static int whiteQuantity = 0;
    private static int blackQuantity = 0;
    private static int redQuantity = 0;
    private static int blueQuantity = 0;
    private static int yellowQuantity = 0;

    private boolean isTilePicked = false;

    public static int getWhiteQuantity() {
        return whiteQuantity;
    }

    public static int getBlackQuantity() {
        return blackQuantity;
    }

    public static int getRedQuantity() {
        return redQuantity;
    }

    public static int getBlueQuantity() {
        return blueQuantity;
    }

    public static int getYellowQuantity() {
        return yellowQuantity;
    }

    public JLabel getPlayerName1() {
        return playerName1;
    }

    public JLabel getPlayerName4() {
        return playerName4;
    }

    public JLabel getPlayerName3() {
        return playerName3;
    }

    public JLabel getPlayerName2() {
        return playerName2;
    }

    public JPanel getFactoryCenterPanel(){
        return factoryCenter;
    }
    public ActionListener getToWorkshop(){
        return e -> {
            Workshop workshop;
          factoryCenter.setVisible(false);
            try {
                workshop = Workshop.getWorkshopInstance();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            workshop.getWorkshopPanel().setVisible(true);
        };
    }

    public static FactoriesCenter getFactoriesCenterINSTANCE() {
        if(INSTANCE == null){
            INSTANCE = new FactoriesCenter();
        }
        return INSTANCE;
    }
    public ActionListener tilePicked(String name){
        return e -> {
            try {
                if(!isTilePicked && !Workshop.getWorkshopInstance().isTileTaken()) {
                    addTileToPlayersPocketFromCenter(name);
                    isTilePicked = true;
                }
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        };
    }

    private FactoriesCenter(){
        playerName4.setForeground(Color.WHITE);
        playerName3.setForeground(Color.WHITE);
        playerName2.setForeground(Color.WHITE);
        playerName1.setForeground(Color.WHITE);
        playerName1.setFont(new Font("Georgia", Font.PLAIN, 28));
        playerName2.setFont(new Font("Georgia", Font.PLAIN, 28));
        playerName3.setFont(new Font("Georgia", Font.PLAIN, 28));
        playerName4.setFont(new Font("Georgia", Font.PLAIN, 28));
        score1.setForeground(Color.WHITE);
        score1.setFont(new Font("Georgia", Font.PLAIN, 28));
        score2.setForeground(Color.WHITE);
        score2.setFont(new Font("Georgia", Font.PLAIN, 28));
        score3.setForeground(Color.WHITE);
        score3.setFont(new Font("Georgia", Font.PLAIN, 28));
        score4.setForeground(Color.WHITE);
        score4.setFont(new Font("Georgia", Font.PLAIN, 28));
        switch (NumberOfPlayers.getClickedNumberOfPlayers()){
            case 1:
                playerName1.setText(GUI.nameList.get(0));

                break;
            case 2:
                playerName1.setText(GUI.nameList.get(0));
                playerName2.setText(GUI.nameList.get(1));

                break;
            case 3:
                playerName1.setText(GUI.nameList.get(0));
                playerName2.setText(GUI.nameList.get(1));
                playerName3.setText(GUI.nameList.get(2));

                break;
            case 4:
                playerName1.setText(GUI.nameList.get(0));
                playerName2.setText(GUI.nameList.get(1));
                playerName3.setText(GUI.nameList.get(2));
                playerName4.setText(GUI.nameList.get(3));

            default:
                playerName1.setText(GUI.nameList.get(0));

        }
        HelpfulMethodsGuiJava.createButton("img/white.png",100,100,whiteTile);
        HelpfulMethodsGuiJava.createButton("img/black.png",100,100,blackTile);
        HelpfulMethodsGuiJava.createButton("img/blue.png",100,100,blueTile);
        HelpfulMethodsGuiJava.createButton("img/red.png",100,100,redTile);
        HelpfulMethodsGuiJava.createButton("img/yellow.png",100,100,yellowTile);
        updateTileQuantities();
        factoriesButton.addActionListener(getToWorkshop());
        whiteTile.addActionListener(tilePicked("WHITE"));
        blackTile.addActionListener(tilePicked("BLACK"));
        blueTile.addActionListener(tilePicked("BLUE"));
        redTile.addActionListener(tilePicked("RED"));
        yellowTile.addActionListener(tilePicked("YELLOW"));

    }

    public void updateTileQuantities() {
        whiteNumber.setText(String.valueOf(whiteQuantity));
        blackNumber.setText(String.valueOf(blackQuantity));
        redNumber.setText(String.valueOf(redQuantity));
        blueNumber.setText(String.valueOf(blueQuantity));
        yellowNumber.setText(String.valueOf(yellowQuantity));
    }
    private void addTileToPlayersPocketFromCenter( String tileName){
        int quantity;
            switch (tileName) {
                case ("WHITE"):
                    if(whiteQuantity!=0) {
                        quantity = whiteQuantity;
                        System.out.println(quantity);
                        setWhiteQuantity(0);
                        updateTileQuantities();
                    }
                    break;
                case ("BLACK"):
                    if (blackQuantity !=0) {
                        quantity = blackQuantity;
                        setBlackQuantity(0);
                        updateTileQuantities();
                    }
                    break;
                case ("RED"):
                    if(redQuantity != 0) {
                        quantity = redQuantity;
                        setRedQuantity(0);
                        updateTileQuantities();
                    }
                    break;
                case ("BLUE"):
                    if(blueQuantity !=0) {
                        quantity = blueQuantity;
                        setBlueQuantity(0);
                        updateTileQuantities();
                    }
                    break;
                case ("YELLOW"):
                    if(yellowQuantity != 0) {
                        quantity = yellowQuantity;
                        setYellowQuantity(0);
                        updateTileQuantities();
                    }
                    break;

            }
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

    public boolean isTilePicked() {
        return isTilePicked;
    }
    public void setIfTileIsPicked(){
        isTilePicked = false;
    }
}
