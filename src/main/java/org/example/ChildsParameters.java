package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChildsParameters implements ActionListener {

    private JTextField childIdTextField;
    private JTextField childTimePlayingTextField;
    private JTextField childTimeQuietField;
    private JTextField childHaveBallField;

    public ChildsParameters(JTextField childIdTextField,
                        JTextField childTimePlayingTextField,
                        JTextField childTimeQuietField, JTextField childHaveBallField){
        this.childIdTextField = childIdTextField;
        this.childTimePlayingTextField = childTimePlayingTextField;
        this.childTimeQuietField = childTimeQuietField;
        this.childHaveBallField = childHaveBallField;
    }

    @Override
    public void actionPerformed(ActionEvent e){

        String text1 = childIdTextField.getText();
        String text2 = childTimePlayingTextField.getText();
        String text3 = childTimeQuietField.getText();
        String text4 = childHaveBallField.getText();



        JOptionPane.showMessageDialog(null,
                "ID: " + text1 +
                        "  Tempo Brincando: " + text2 +
                        "  Tempo Estudando: " + text3 +
                        "  Tem bola? " + text4);


    }

}
