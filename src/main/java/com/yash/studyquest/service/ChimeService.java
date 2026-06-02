package com.yash.studyquest.service;

import java.awt.*;

public class ChimeService {

    public static void play() {

        Toolkit.getDefaultToolkit().beep();

        try {

            Thread.sleep(150);

        } catch (InterruptedException ignored) {

        }

        Toolkit.getDefaultToolkit().beep();
    }
}