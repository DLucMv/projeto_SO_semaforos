package org.example;

import javax.swing.*;
import java.awt.*;

public class ChildsDrawing extends JPanel {

    private int x;
    private int y;

    public ChildsDrawing(){
        setPreferredSize(new Dimension(200, 100));
    }

    public void upDate(){
        x += 1;
        y += 1;
    }

    @Override
    public void paint(Graphics c){
        c.clearRect(0,0,getWidth(),getHeight());
        c.fillRect(x,y, 20, 50);
    }
}
