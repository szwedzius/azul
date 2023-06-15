package GUIForms;

import javax.swing.*;
import java.awt.*;

public class Board {



    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton button10;
    private JButton button11;
    private JButton button12;
    private JButton button13;
    private JButton button14;
    private JButton button15;
    private JButton button16;
    private JButton button17;
    private JButton button18;
    private JButton button19;
    private JButton button20;
    private JButton button5;
    private JButton button21;
    private JLabel l2;
    private JLabel l3;
    private JLabel l4;
    private JLabel l1;
    private JLabel l5;
    private JLabel l31;
    private JLabel l22;
    private JLabel l32;
    private JLabel l23;
    private JLabel l33;
    private JLabel l24;
    private JLabel l34;
    private JLabel l25;
    private JLabel l35;
    private JLabel l43;
    private JLabel l53;
    private JLabel l42;
    private JLabel l41;
    private JLabel l21;
    private JLabel l51;
    private JLabel l52;
    private JLabel l44;
    private JLabel l54;
    private JLabel l45;
    private JLabel l55;
    private JPanel Board;
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

    Board(){
        HelpfulMethodsGuiJava.createButton("img/notile.png",60,60,button2);
        HelpfulMethodsGuiJava.createButton("img/notile.png",60,60,button3);
        HelpfulMethodsGuiJava.createButton("img/notile.png",60,60,button5);
        HelpfulMethodsGuiJava.createButton("img/notile.png",60,60,button6);
        HelpfulMethodsGuiJava.createButton("img/notile.png",60,60,button7);
        HelpfulMethodsGuiJava.createButton("img/notile.png",60,60,button8);
        HelpfulMethodsGuiJava.createButton("img/notile.png",60,60,button9);
        HelpfulMethodsGuiJava.createButton("img/notile.png",60,60,button10);
        HelpfulMethodsGuiJava.createButton("img/notile.png",60,60,button11);
        HelpfulMethodsGuiJava.createButton("img/black.png",60,60,button12);
        HelpfulMethodsGuiJava.createButton("img/notile.png",60,60,button13);
        HelpfulMethodsGuiJava.createButton("img/notile.png",60,60,button14);
        HelpfulMethodsGuiJava.createButton("img/notile.png",60,60,button15);
        HelpfulMethodsGuiJava.createButton("img/notile.png",60,60,button16);
        HelpfulMethodsGuiJava.createButton("img/notile.png",60,60,button17);
        HelpfulMethodsGuiJava.createButton("img/notile.png",60,60,button18);
        HelpfulMethodsGuiJava.createButton("img/notile.png",60,60,button19);
        HelpfulMethodsGuiJava.createButton("img/notile.png",60,60,button20);
        HelpfulMethodsGuiJava.createButton("img/notile.png",60,60,button21);
        HelpfulMethodsGuiJava.createButton("img/notile.png",60,60,button4);
    }

    public JPanel getBoard() {
        return Board;
    }
}
