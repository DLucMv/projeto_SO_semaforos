package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.Semaphore;

public class Playground extends JFrame {
    private JButton createChildButton;
    private JTable childTable;
    private DefaultTableModel childTableModel;

    private Semaphore mutex;
    private Semaphore playing;
    private Semaphore quiet;

    private int maxChildsPlaying = 1;
    private int basketCapacity = 1;

    public Playground() {
        // Configurações básicas da janela
        super("Playground");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        // Cria os componentes
        createChildButton = new JButton("Criar criança");
        createChildButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createChild();
            }
        });

        childTableModel = new DefaultTableModel();
        childTableModel.addColumn("ID");
        childTableModel.addColumn("Bola?");
        childTableModel.addColumn("Tempo de brincadeira");
        childTableModel.addColumn("Tempo quieta");
        childTableModel.addColumn("Estado");
        childTableModel.addColumn("Brincando");
        childTableModel.addColumn("Quieta");

        childTable = new JTable(childTableModel);
        childTable.getColumnModel().getColumn(0).setPreferredWidth(20);
        childTable.getColumnModel().getColumn(1).setPreferredWidth(50);
        childTable.getColumnModel().getColumn(2).setPreferredWidth(130);
        childTable.getColumnModel().getColumn(3).setPreferredWidth(100);
        childTable.getColumnModel().getColumn(4).setPreferredWidth(100);
        childTable.getColumnModel().getColumn(5).setPreferredWidth(70);
        childTable.getColumnModel().getColumn(6).setPreferredWidth(70);

        JScrollPane scrollPane = new JScrollPane(childTable);

        // Adiciona os componentes à janela
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(createChildButton, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        add(mainPanel);

        // Cria os semáforos
        mutex = new Semaphore(1);
        playing = new Semaphore(maxChildsPlaying);
        quiet = new Semaphore(0);

        // Configura as imagens para as células "Brincando" e "Quieta"
        ImageIcon playingIcon = new ImageIcon(getClass().getResource("/playing.jpg"));
        ImageIcon quietIcon = new ImageIcon(getClass().getResource("/quiet.jpg"));

        ImageRenderer imageRenderer = new ImageRenderer();
        imageRenderer.setImageForValue("Sim", playingIcon);
        imageRenderer.setImageForValue("Não", quietIcon);

        childTable.getColumnModel().getColumn(5).setCellRenderer(imageRenderer);
        childTable.getColumnModel().getColumn(6).setCellRenderer(imageRenderer);
    }

    private void createChild() {
        int id = childTableModel.getRowCount();
        boolean hasBall = Math.random() < 0.5;
        int playingTime = (int)(Math.random() * 6) + 1;
        int quietTime = (int)(Math.random() * 6) + 1;

        Child child = new Child(id, playingTime, quietTime, hasBall, mutex, playing, quiet);
        Playing playingThread = new Playing(child);
        Quiet quietThread = new Quiet(child);

        playingThread.start();
        quietThread.start();

        String[] row = {
                Integer.toString(id),
                hasBall ? "Sim" : "Não",
                Integer.toString(playingTime),
                Integer.toString(quietTime),
                "Quieta"
        };
        childTableModel.addRow(row);
    }

    public static void main(String[] args) {
        Playground playground = new Playground();
        playground.setVisible(true);
    }
}
