/* Projeto desenvolvido para a disciplina de Sistemas Operacionais do curso de
 Engenharia da Computação do Instituto Federal de Educação, Ciência e Tecnologia
 do Ceará - IFCE como método de avaliaçao parcial para a conclusão da disciplina.*/

/* Desenvolvido por:
* Davison Lucas
* Paulo Victor
* Rony Cleyton*/

package org.example;

import javax.swing.*;
import java.util.Timer;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) throws Exception {

        new Window();


        /*SwingUtilities.invokeLater(() -> {
            Window w = new Window();

            ChildsDrawing c = new ChildsDrawing();
            w.add(c);

            w.setVisible(true);

            Timer animationTimer = new Timer();
            AnimationTask myLoop = new AnimationTask(c);
            animationTimer.scheduleAtFixedRate(myLoop, 0, 100);
        });*/

        final int CHILDS_NUMBER = 2;
        final int MAX_CHILDS_PLAYING = 1;
        final int BASKET = 1;

        Semaphore mutex = new Semaphore(1);
        Semaphore playing = new Semaphore(MAX_CHILDS_PLAYING);
        Semaphore quiet = new Semaphore(0);

        /*Child c = new Child(0, 3, 3, true,mutex, playing, quiet);
        Child c2 = new Child(1, 3, 3, false,mutex, playing, quiet);
        Child c3 = new Child(2, 3, 3, false,mutex, playing, quiet);
        Playing p = new Playing(c);
        Quiet q = new Quiet(c);
        Playing p2 = new Playing(c2);
        Quiet q2 = new Quiet(c2);
        Playing p3 = new Playing(c3);
        Quiet q3 = new Quiet(c3);

        p.start();
        q.start();
        p2.start();
        q2.start();
        p3.start();
        q3.start();*/

    }
}