package org.example;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.Semaphore;

public class Child extends Thread{
    private int id;
    private int timePlaying;
    private int timeQuiet;
    private boolean haveBall;
    private Semaphore mutex, playing, quiet; //playing = empty && quiet = full

    public Child(int id, int timePlaying, int timeQuiet, boolean haveBall, Semaphore mutex, Semaphore playing, Semaphore quiet) {
        this.id = id;
        this.timePlaying = timePlaying;
        this.timeQuiet = timeQuiet;
        this.haveBall = haveBall;
        this.mutex = mutex;
        this.playing = playing;
        this.quiet = quiet;
    }

    @Override
    public long getId() {
        return id;
    }

    public int getTimePlaying() {
        return timePlaying;
    }

    public int getTimeQuiet() {
        return timeQuiet;
    }

    public boolean isHaveBall() {
        return haveBall;
    }

    public Semaphore getMutex() {
        return mutex;
    }

    public Semaphore getPlaying() {
        return playing;
    }

    public Semaphore getQuiet() {
        return quiet;
    }

    public static void wait(int time) {
        LocalDateTime start = LocalDateTime.now();

        while(true) {
            LocalDateTime now = LocalDateTime.now();

            if(ChronoUnit.SECONDS.between(start, now) >= time) {
                return;
            }
        }

    }

    public int remainingQuiet(String idThread){
        try{
            quiet.acquire();
            mutex.acquire();
            this.haveBall = true;
            System.out.println("Child(" + idThread + ") " + this.id + " is NOT playing with a ball.");
            wait(this.timeQuiet);
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            mutex.release();
            playing.release();
        }
        return this.id;
    }

    public int playingBall(String idThread){
        try{
            playing.acquire();
            mutex.acquire();
            this.haveBall = false;
            System.out.println("Child(" + idThread + ") " + this.id + " is playing with a ball.");
            wait(this.timePlaying);
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            mutex.release();
            quiet.release();
        }
        return this.id;
    }


}
