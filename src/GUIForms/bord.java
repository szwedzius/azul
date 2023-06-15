package GUIForms;

import javax.swing.*;

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

    bord() {
        HelpfulMethodsGuiJava.createButton("img/notile.png", 60, 60, button2);
        HelpfulMethodsGuiJava.createButton("img/notile.png", 60, 60, button3);
        HelpfulMethodsGuiJava.createButton("img/notile.png", 60, 60, button5);
        HelpfulMethodsGuiJava.createButton("img/notile.png", 60, 60, button6);
        HelpfulMethodsGuiJava.createButton("img/notile.png", 60, 60, button7);
        HelpfulMethodsGuiJava.createButton("img/notile.png", 60, 60, button8);
        HelpfulMethodsGuiJava.createButton("img/notile.png", 60, 60, button9);
        HelpfulMethodsGuiJava.createButton("img/notile.png", 60, 60, button10);
        HelpfulMethodsGuiJava.createButton("img/notile.png", 60, 60, button11);
        HelpfulMethodsGuiJava.createButton("img/black.png", 60, 60, button12);
        HelpfulMethodsGuiJava.createButton("img/notile.png", 60, 60, button13);
        HelpfulMethodsGuiJava.createButton("img/notile.png", 60, 60, button14);
        HelpfulMethodsGuiJava.createButton("img/notile.png", 60, 60, button15);
        HelpfulMethodsGuiJava.createButton("img/notile.png", 60, 60, button16);
        HelpfulMethodsGuiJava.createButton("img/notile.png", 60, 60, button17);
        HelpfulMethodsGuiJava.createButton("img/notile.png", 60, 60, button18);
        HelpfulMethodsGuiJava.createButton("img/notile.png", 60, 60, button19);
        HelpfulMethodsGuiJava.createButton("img/notile.png", 60, 60, button20);
        HelpfulMethodsGuiJava.createButton("img/notile.png", 60, 60, button1);
        HelpfulMethodsGuiJava.createButton("img/notile.png", 60, 60, button4);
        HelpfulMethodsGuiJava.createButton("img/notile.png", 60, 60, button21);
        HelpfulMethodsGuiJava.createButton("img/notile.png", 60, 60, button22);

        tiles[0] = l1;
        tiles[1] = l2;
        tiles[2] = l3;
        tiles[3] = l4;
        tiles[4] = l5;
        tiles[5] = l6;
        tiles[6] = l7;
        tiles[7] = l8;
        tiles[8] = l9;
        tiles[9] = l10;
        tiles[10] = l11;
        tiles[11] = l12;
        tiles[12] = l13;
        tiles[13] = l14;
        tiles[14] = l15;
        tiles[15] = l16;
        tiles[16] = l17;
        tiles[17] = l18;
        tiles[18] = l19;
        tiles[19] = l20;
        tiles[20] = l21;
        tiles[21] = l22;
        tiles[22] = l23;
        tiles[23] = l24;
        tiles[24] = l25;
        for(JLabel tile: tiles){
            HelpfulMethodsGuiJava.createLabel("img/notile.png", 50,50, tile);
        }
    }

    public JPanel getFullbord() {
        return fullbord;
    }
}
