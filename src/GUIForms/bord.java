package GUIForms;

import Mechanics.GUIGAME;
import Mechanics.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static Mechanics.GUIGAME.*;

public class bord {
    private JPanel fullbord;
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
    private JPanel stairs;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton button11;
    private JButton button12;
    private JButton button13;
    private JButton button14;
    private JButton button10;
    private JButton button15;
    private JButton button16;
    private JButton button17;
    private JButton button18;
    private JButton button19;
    private JButton button20;
    private JPanel wall;
    private JLabel l1;
    private JLabel l2;
    private JLabel l3;
    private JLabel l4;
    private JLabel l5;
    private JLabel l6;
    private JLabel l7;
    private JLabel l8;
    private JLabel l9;
    private JLabel l10;
    private JLabel l11;
    private JLabel l12;
    private JLabel l13;
    private JLabel l14;
    private JLabel l15;
    private JLabel l16;
    private JLabel l17;
    private JLabel l18;
    private JLabel l19;
    private JLabel l20;
    private JLabel l21;
    private JLabel l22;
    private JLabel l23;
    private JLabel l24;
    private JLabel l25;
    private JButton button21;
    private JButton button22;
    private JLabel[] tiles = new JLabel[25];
    private static int row;

    public bord() {
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
        HelpfulMethodsGuiJava.createButton("img/notile.png",80,80,button2);
        HelpfulMethodsGuiJava.createButton("img/notile.png",80,80,button3);
        HelpfulMethodsGuiJava.createButton("img/notile.png",80,80,button5);
        HelpfulMethodsGuiJava.createButton("img/notile.png",80,80,button6);
        HelpfulMethodsGuiJava.createButton("img/notile.png",80,80,button7);
        HelpfulMethodsGuiJava.createButton("img/notile.png",80,80,button8);
        HelpfulMethodsGuiJava.createButton("img/notile.png",80,80,button9);
        HelpfulMethodsGuiJava.createButton("img/notile.png",80,80,button10);
        HelpfulMethodsGuiJava.createButton("img/notile.png",80,80,button11);
        HelpfulMethodsGuiJava.createButton("img/notile.png",80,80,button12);
        HelpfulMethodsGuiJava.createButton("img/notile.png",80,80,button13);
        HelpfulMethodsGuiJava.createButton("img/notile.png",80,80,button14);
        HelpfulMethodsGuiJava.createButton("img/notile.png",80,80,button15);
        HelpfulMethodsGuiJava.createButton("img/notile.png",80,80,button16);
        HelpfulMethodsGuiJava.createButton("img/notile.png",80,80,button17);
        HelpfulMethodsGuiJava.createButton("img/notile.png",80,80,button18);
        HelpfulMethodsGuiJava.createButton("img/notile.png",80,80,button19);
        HelpfulMethodsGuiJava.createButton("img/notile.png",80,80,button20);
        HelpfulMethodsGuiJava.createButton("img/notile.png",80,80,button21);
        HelpfulMethodsGuiJava.createButton("img/notile.png",80,80,button4);
        HelpfulMethodsGuiJava.createButton("img/notile.png", 80, 80, button1);
        HelpfulMethodsGuiJava.createButton("img/notile.png", 80, 80, button22);

        HelpfulMethodsGuiJava.createLabel("img/blue_notile.png", 80,80, l1);
        HelpfulMethodsGuiJava.createLabel("img/yellow_notile.png", 80,80, l2);
        HelpfulMethodsGuiJava.createLabel("img/red_notile.png", 80,80, l3);
        HelpfulMethodsGuiJava.createLabel("img/black_notile.png", 80,80, l4);
        HelpfulMethodsGuiJava.createLabel("img/white_notile.png", 80,80, l5);
        HelpfulMethodsGuiJava.createLabel("img/white_notile.png", 80,80, l6);
        HelpfulMethodsGuiJava.createLabel("img/blue_notile.png", 80,80, l7);
        HelpfulMethodsGuiJava.createLabel("img/yellow_notile.png", 80,80, l8);
        HelpfulMethodsGuiJava.createLabel("img/red_notile.png", 80,80, l9);
        HelpfulMethodsGuiJava.createLabel("img/black_notile.png", 80,80, l10);
        HelpfulMethodsGuiJava.createLabel("img/black_notile.png", 80,80, l11);
        HelpfulMethodsGuiJava.createLabel("img/white_notile.png", 80,80, l12);
        HelpfulMethodsGuiJava.createLabel("img/blue_notile.png", 80,80, l13);
        HelpfulMethodsGuiJava.createLabel("img/yellow_notile.png", 80,80, l14);
        HelpfulMethodsGuiJava.createLabel("img/red_notile.png", 80,80, l15);
        HelpfulMethodsGuiJava.createLabel("img/red_notile.png", 80,80, l16);
        HelpfulMethodsGuiJava.createLabel("img/black_notile.png", 80,80, l17);
        HelpfulMethodsGuiJava.createLabel("img/white_notile.png", 80,80, l18);
        HelpfulMethodsGuiJava.createLabel("img/blue_notile.png", 80,80, l19);
        HelpfulMethodsGuiJava.createLabel("img/yellow_notile.png", 80,80, l20);
        HelpfulMethodsGuiJava.createLabel("img/yellow_notile.png", 80,80, l21);
        HelpfulMethodsGuiJava.createLabel("img/red_notile.png", 80,80, l22);
        HelpfulMethodsGuiJava.createLabel("img/black_notile.png", 80,80, l23);
        HelpfulMethodsGuiJava.createLabel("img/white_notile.png", 80,80, l24);
        HelpfulMethodsGuiJava.createLabel("img/blue_notile.png", 80,80, l25);

        int index = 0;

        for (Component component : this.stairs.getComponents()) {
            if (component instanceof JButton && index < 22) {
                ((JButton) component).addActionListener(makeTurn());
                index++;
            }
        }

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

    public JPanel getFullbord() {
        return fullbord;
    }

    public ActionListener whereToPutTheTile(Tile tile){
        return e->{
        };
    }

    public ActionListener makeTurn(){
        return e -> {
            row = 0;
            if(e.getSource().equals(button1))
                row =1;
            else if (e.getSource().equals(button5)||e.getSource().equals(button6)) {
                row =2;
            } else if (e.getSource().equals(button4)||e.getSource().equals(button7)||e.getSource().equals(button11)) {
                row =3;
            } else if (e.getSource().equals(button14)||e.getSource().equals(button12) ||e.getSource().equals(button8)|| e.getSource().equals(button3)) {
                row =4;
            }else {
                row =5;
            }


            try {
                //TODO error handling
                localGamePhase1(que.get(GUI.currentPlayerIndex));
                GUI.currentPlayerIndex++;
                localGameNextTurn(GUI.currentPlayerIndex);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            
        };
    }

    public static int getRow() {
        return row;
    }
}
