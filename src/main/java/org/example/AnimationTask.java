package org.example;

import java.util.TimerTask;

public class AnimationTask extends TimerTask {

    private ChildsDrawing childComponent;

    public AnimationTask(ChildsDrawing child) {
        this.childComponent = child;
    }

    @Override
    public void run(){
        childComponent.upDate();
        childComponent.repaint();
        childComponent.getToolkit().sync();
    }
}
