package com.yash.studyquest.service;

import javax.swing.*;

public class AchievementPopupService {

    public static void show(String achievementName) {

        JOptionPane.showMessageDialog(
                null,
                "🏆 Achievement Unlocked!\n\n" +
                        achievementName,
                "Achievement",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}