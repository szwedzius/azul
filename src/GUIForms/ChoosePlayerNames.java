package GUIForms;

import Mechanics.Player;

import javax.swing.*;
import java.awt.*;

public class ChoosePlayerNames {
    private JPanel panel1;
    private JTextField textField1;
    private JButton confirmButton;
    private JLabel playerName1;
    private JLabel playerName2;
    private JLabel playerName3;
    private JLabel playerName4;
    private JPanel ScoreBoard;
    private JLabel score1;
    private JLabel score2;
    private JLabel score3;
    private JLabel score4;
    private static int numberOfNames = 0;
    private Player[] names = new Player[NumberOfPlayers.getClickedNumberOfPlayers()];

    public JPanel getPanel1() {
        return panel1;
    }

    public void setTextField1(JTextField textField1) {
        this.textField1 = textField1;
    }

    public ChoosePlayerNames() throws HeadlessException {
        HelpfulMethodsGuiJava.createButton("img/confirm.png",291,150,confirmButton);
        panel1.setVisible(true);
        ScoreBoard.setVisible(true);
            confirmButton.addActionListener(e -> {
                textField1.getText();
                System.out.println(textField1.getText());
                String name = (textField1.getText());
                Player player = new Player(name);
                textField1.setText(null);
                if(numberOfNames==0){
                    playerName1.setText(name);
                } else if (numberOfNames==1) {
                    playerName2.setText(name);
                } else if (numberOfNames==2) {
                    playerName3.setText(name);
                } else {
                    playerName4.setText(name);
                }
                numberOfNames++;
            });
            if(MainFrame.getIsGameOnline()==1) {
                if (numberOfNames==1){
                    //TODO należy utworzyć sesje gry, tzn jakiś panel
                }
            }
            else if (numberOfNames == NumberOfPlayers.getClickedNumberOfPlayers()) {
                panel1.setVisible(false);
                //TODO należy utworzyć sesje gry, tzn jakiś panel
            }

        confirmButton.addMouseListener(
                HelpfulMethodsGuiJava.hoverEvents(
                        confirmButton,
                        "img/confirm.png",
                        "img/confirmHover.png",
                        291,
                        150));

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
