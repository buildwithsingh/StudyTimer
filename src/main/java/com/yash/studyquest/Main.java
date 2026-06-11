package com.yash.studyquest;

import com.formdev.flatlaf.FlatDarkLaf;
import com.yash.studyquest.model.AchievementData;
import com.yash.studyquest.storage.AchievementStorage;
import com.yash.studyquest.ui.MainFrame;
import com.yash.studyquest.model.AchievementData;
import com.yash.studyquest.storage.AchievementStorage;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        FlatDarkLaf.setup();

        SwingUtilities.invokeLater(() -> {
            new MainFrame();
        });


    }


}