package GUIForms;

import javax.swing.*;
import java.awt.*;

public class Workshop {
    private JPanel workshop;
    private JButton confirmButton;
    private JPanel ScoreBoard;
    private JLabel playerName1;
    private JLabel playerName4;
    private JLabel playerName3;
    private JLabel playerName2;
    private JLabel score4;
    private JLabel score3;
    private JLabel score2;
    private JLabel score1;
    private JButton boardButton;
    private JButton centerButton;
    private JPanel factory1;
    private JPanel center;
    private JPanel factory2;
    private JPanel factory3;
    private JPanel factory4;
    private JPanel factory5;
    private JPanel factory6;
    private JPanel factory7;
    private JPanel factory8;
    private JPanel factory9;
    private JLabel scoreboard;
    private JButton factory1Tile1;
    private JButton factory1Tile2;
    private JButton factory1Tile3;
    private JButton factory1Tile4;
    private JButton factory2Tile1;
    private JButton factory2Tile2;
    private JButton factory2Tile3;
    private JButton factory2Tile4;
    private JButton factory3Tile1;
    private JButton factory3Tile2;
    private JButton factory3Tile3;
    private JButton factory3Tile4;
    private JButton factory4Tile1;
    private JButton factory4Tile2;
    private JButton factory4Tile3;
    private JButton factory4Tile4;
    private JButton factory5Tile1;
    private JButton factory5Tile2;
    private JButton factory5Tile3;
    private JButton factory5Tile4;
    private JButton factory6Tile1;
    private JButton factory6Tile2;
    private JButton factory6Tile3;
    private JButton factory6Tile4;
    private JButton factory7Tile1;
    private JButton factory7Tile2;
    private JButton factory7Tile3;
    private JButton factory7Tile4;
    private JButton factory8Tile1;
    private JButton factory8Tile2;
    private JButton factory8Tile3;
    private JButton factory8Tile4;
    private JButton factory9Tile1;
    private JButton factory9Tile2;
    private JButton factory9Tile3;
    private JButton factory9Tile4;
    private JTextField textField1;

    public JPanel getWorkshopPanel() {
        return workshop;
    }

    Workshop() throws HeadlessException  {
        scoreboard.setIcon(HelpfulMethodsGuiJava.getImageIconWithSize("img/scoreboard.png",339,90));
        HelpfulMethodsGuiJava.createButton("img/confirm.png",291,150,boardButton);





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

    }




}
