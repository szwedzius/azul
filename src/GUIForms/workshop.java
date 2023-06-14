package GUIForms;

import Mechanics.Factory;
import Mechanics.Table;
import Mechanics.Tile;

import javax.swing.*;

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
    private JTextField textField1;

    public static Table factoryTable;

    public JPanel getWorkshopPanel() {
        return workshop;
    }

    Workshop(){
        int i = 0;
        for(Factory x: factoryTable.factories){
            System.out.println(i);
            for(Tile y: x.getContents()){
                System.out.println(y.name() + " ");
            }
            i++;
        }
    }




}
