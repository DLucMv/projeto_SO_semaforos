package org.example;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    public Window() throws Exception{
        JFrame frame = new JFrame();

        frame.setTitle("Child´s play");
        frame.setSize(800, 600); //Tamanho da Janela
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha a janela ao sair da aplicação

        setLayout(new BorderLayout());
        JPanel panel = new JPanel();

        JLabel childIdLabel = new JLabel("Id da criança: ");
        panel.add(childIdLabel);
        JTextField childIdTextField = new JTextField(2);
        panel.add(childIdTextField);

        JLabel childTimePlayingLabel = new JLabel("Tempo de brincadeira: ");
        panel.add(childTimePlayingLabel);
        JTextField childTimePlayingTextField = new JTextField(2);
        panel.add(childTimePlayingTextField);

        JLabel childTimeQuietLabel = new JLabel("Tempo de estudo: ");
        panel.add(childTimeQuietLabel);
        JTextField childTimeQuietField = new JTextField(2);
        panel.add(childTimeQuietField);

        JLabel childHaveBallLabel = new JLabel("A criança possui bola? ");
        panel.add(childHaveBallLabel);
        JTextField childHaveBallField = new JTextField(2);
        panel.add(childHaveBallField);

        JButton button = new JButton("OK");
        ChildsParameters action = new ChildsParameters(childIdTextField,
                childTimePlayingTextField, childTimeQuietField, childHaveBallField);
        button.addActionListener(action);
        panel.add(button);

        frame.add(BorderLayout.NORTH, panel);


        JPanel field = new JPanel();

        frame.add(BorderLayout.CENTER, field);


        frame.setVisible(true);
    }

}
