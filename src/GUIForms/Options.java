package GUIForms;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Options {
    private JPanel panel1;
    private JButton smallButton;
    private JButton mediumButton;
    private JButton bigButton;

    public static ActionListener setWidthHeight(int width, int height){
        return e -> {
            GUI.frame.setSize(width,height);
            switch (width) {
                case 1280 -> GUI.windowSize = WindowSize.SMALL;
                case 1600 -> GUI.windowSize = WindowSize.MEDIUM;
                case 1904 -> GUI.windowSize = WindowSize.BIG;
            }
        };
    }

    public JPanel getPanel1() {
        return panel1;
    }

    Options(){
        smallButton.addActionListener(setWidthHeight(1280, 720));
        mediumButton.addActionListener(setWidthHeight(1600, 900));
        bigButton.addActionListener(setWidthHeight(1904, 1071));
    }
}
