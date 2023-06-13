package GUIForms;

import Mechanics.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.function.ToDoubleBiFunction;

public class ChoosePlayerNames {
    private JPanel panel1;
    private JTextField textField1;
    private JButton confirmButton;
    private static int numberOfNames = 0;
    private Player[] names = new Player[NumberOfPlayers.getClickedNumberOfPlayers()];

    public JPanel getPanel1() {
        return panel1;
    }

    public void setTextField1(JTextField textField1) {
        this.textField1 = textField1;
    }

    public ChoosePlayerNames() throws HeadlessException {
        panel1.setVisible(true);
            confirmButton.addActionListener(e -> {
                textField1.getText();
                System.out.println(textField1.getText());
                String name = (textField1.getText());
                Player player = new Player(name);
                textField1.setText(null);
                numberOfNames++;
            });
            if(numberOfNames==NumberOfPlayers.getClickedNumberOfPlayers()){
                panel1.setVisible(false);
                //TODO należy utworzyć sesje gry, tzn jakiś panel
        }

        // Add any necessary code for setting up the GUI, such as creating the panel and text field
        // and adding them to the frame.
    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if ("Confirm".equals(e.getActionCommand())) {  // Check action command of the event
//            System.out.println("Welcome " + textField1.getText());
//            // button.setEnabled(false);
//            // textField.setEditable(false);
//        }
//    }
}
