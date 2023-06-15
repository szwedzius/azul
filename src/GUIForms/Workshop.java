package GUIForms;

import Mechanics.Table;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.ActionListener;

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
    private ArrayList<JButton> buttons = new ArrayList<>();

    public JPanel getWorkshopPanel() {
        return workshop;
    }

    public ActionListener getToCenter(){
        return e -> {
          workshop.setVisible(false);
          FactoriesCenter center = new FactoriesCenter();
          GUI.frame.add(center.getFactoryCenterPanel());
          center.getFactoryCenterPanel().setVisible(true);
        };
    }
    public ActionListener getToBoard(){
        return e -> {
            workshop.setVisible(false);
            FactoriesCenter center = new FactoriesCenter();
            GUI.frame.add(center.getFactoryCenterPanel());
            center.getFactoryCenterPanel().setVisible(true);
        };
    }
    Workshop() throws Exception {
        boardButton.addActionListener(getToBoard());
        scoreboard.setIcon(HelpfulMethodsGuiJava.getImageIconWithSize("img/scoreboard.png",339,90));
        centerButton.addActionListener(getToCenter());
        HelpfulMethodsGuiJava.createButton("img/confirm.png",291,150,boardButton);
        Table table = new Table(NumberOfPlayers.getClickedNumberOfPlayers());
        table.refillFactories();
        buttons.add(factory1Tile1);
        buttons.add(factory1Tile2);
        buttons.add(factory1Tile3);
        buttons.add(factory1Tile4);
        buttons.add(factory2Tile1);
        buttons.add(factory2Tile2);
        buttons.add(factory2Tile3);
        buttons.add(factory2Tile4);
        buttons.add(factory3Tile1);
        buttons.add(factory3Tile2);
        buttons.add(factory3Tile3);
        buttons.add(factory3Tile4);
        buttons.add(factory4Tile1);
        buttons.add(factory4Tile2);
        buttons.add(factory4Tile3);
        buttons.add(factory4Tile4);
        buttons.add(factory5Tile1);
        buttons.add(factory5Tile2);
        buttons.add(factory5Tile3);
        buttons.add(factory5Tile4);
        buttons.add(factory6Tile1);
        buttons.add(factory6Tile2);
        buttons.add(factory6Tile3);
        buttons.add(factory6Tile4);
        buttons.add(factory7Tile1);
        buttons.add(factory7Tile2);
        buttons.add(factory7Tile3);
        buttons.add(factory7Tile4);
        buttons.add(factory8Tile1);
        buttons.add(factory8Tile2);
        buttons.add(factory8Tile3);
        buttons.add(factory8Tile4);
        buttons.add(factory9Tile1);
        buttons.add(factory9Tile2);
        buttons.add(factory9Tile3);
        buttons.add(factory9Tile4);
        int button = 0;

        
        for (int i = 0; i < table.factories.length; i++) {
            for (int j = 0; j < 4; j++) {
                HelpfulMethodsGuiJava.createButton(table.factories[i].getContents()[j].getImageName(),80,80,buttons.get(button));
                button++;
            }
        }




        switch (NumberOfPlayers.getClickedNumberOfPlayers()){
            case 1:
                playerName1.setText(GUI.nameList.get(0));
                factoriesFor1Players();
                break;
            case 2:
                playerName1.setText(GUI.nameList.get(0));
                playerName2.setText(GUI.nameList.get(1));
                factoriesFor2Players();
                break;
            case 3:
                playerName1.setText(GUI.nameList.get(0));
                playerName2.setText(GUI.nameList.get(1));
                playerName3.setText(GUI.nameList.get(2));
                factoriesFor3Players();
                break;
            case 4:
                playerName1.setText(GUI.nameList.get(0));
                playerName2.setText(GUI.nameList.get(1));
                playerName3.setText(GUI.nameList.get(2));
                playerName4.setText(GUI.nameList.get(3));
                factoriesFor4Players();
            default:
                playerName1.setText(GUI.nameList.get(0));
                factoriesVisibleBase();
        }

    }

    private void factoriesVisibleBase() {
        factory1.setVisible(true);
        factory2.setVisible(true);
        factory3.setVisible(true);
        factory4.setVisible(true);
        factory5.setVisible(true);
        center.setVisible(true);
    }
    private void factoriesFor1Players(){
        factoriesVisibleBase();
        factory6.setVisible(false);
        factory7.setVisible(false);
        factory8.setVisible(false);
        factory9.setVisible(false);
    }
    private void factoriesFor2Players(){
        factoriesVisibleBase();
        factory6.setVisible(false);
        factory7.setVisible(false);
        factory8.setVisible(false);
        factory9.setVisible(false);
    }
    private void factoriesFor3Players(){
        factoriesVisibleBase();
        factory6.setVisible(true);
        factory7.setVisible(true);
        factory8.setVisible(false);
        factory9.setVisible(false);
    }
    private void factoriesFor4Players(){
        factoriesVisibleBase();
        factory6.setVisible(true);
        factory7.setVisible(true);
        factory8.setVisible(true);
        factory9.setVisible(true);
    }



}
