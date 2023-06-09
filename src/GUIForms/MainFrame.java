package GUIForms;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainFrame {
    private JButton SETTINGSButton;
    private JButton ONLINEButton;
    private JButton LOCALButton;
    private JPanel AZUL;

    private static int init =0;

    public JPanel getAZUL() {
        return AZUL;
    }

    public MainFrame() {
        GUI.frame.add(AZUL);
        SETTINGSButton.addActionListener(e -> {
            Options options = new Options();
            GUI.frame.add(options.getPanel1());
            AZUL.setVisible(false);
        });
        ONLINEButton.addActionListener(e->{
            if(init ==0){
                NumberOfPlayers numberOfPlayers = new NumberOfPlayers();
                GUI.frame.add(numberOfPlayers.getPLAYERS());
                numberOfPlayers.getPLAYERS().setVisible(true);
                AZUL.setVisible(false);
            }
        });
    }
}
