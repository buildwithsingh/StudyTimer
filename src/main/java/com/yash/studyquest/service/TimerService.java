package com.yash.studyquest.service;

import javax.swing.*;

public class TimerService {

    private Timer timer;

    private int totalSeconds;
    private int remainingSeconds;

    private TimerListener listener;

    public interface TimerListener {
        void onTick(int remainingSeconds);
        void onFinish();
    }

    public void setDuration(int seconds) {

        this.totalSeconds = seconds;
        this.remainingSeconds = seconds;
    }

    public void setListener(TimerListener listener) {
        this.listener = listener;
    }

    public void start() {

        if (timer != null) {
            timer.stop();
        }

        timer = new Timer(1000, e -> {

            remainingSeconds--;

            listener.onTick(remainingSeconds);

            if (remainingSeconds <= 0) {

                timer.stop();

                listener.onFinish();
            }
        });

        timer.start();
    }

    public void pause() {

        if (timer != null) {
            timer.stop();
        }
    }

    public void resume() {

        if (timer != null) {
            timer.start();
        }
    }

    public void reset() {

        if (timer != null) {
            timer.stop();
        }

        remainingSeconds = totalSeconds;
    }

    public int getRemainingSeconds() {
        return remainingSeconds;
    }
}