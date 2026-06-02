package com.yash.studyquest.ui.tabs;

import com.yash.studyquest.model.Achievement;
import com.yash.studyquest.service.AchievementService;
import com.yash.studyquest.service.StatisticsService;
import com.yash.studyquest.service.StreakService;

import javax.swing.JProgressBar;

import javax.swing.*;
import java.awt.*;

public class StatisticsPanel extends JPanel {

    public StatisticsPanel() {





        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        StatisticsService stats = new StatisticsService();
        StreakService streakService =
                new StreakService();

        int currentXP =
                stats.getXPIntoCurrentLevel();

        int neededXP =
                stats.getXPNeededForNextLevel();

        JLabel levelLabel =
                new JLabel("Level: " + stats.getLevel());

        JLabel xpLabel =
                new JLabel("XP: " + stats.getTotalXP());

        JLabel focusLabel =
                new JLabel("Focus Minutes: "
                        + stats.getTotalFocusMinutes());

        JLabel streakLabel =
                new JLabel(
                        "Current Streak: "
                                + streakService.getCurrentStreak()
                                + " 🔥");

        JLabel bestStreakLabel =
                new JLabel(
                        "Best Streak: "
                                + streakService.getBestStreak()
                                + " 🏆");

        JProgressBar xpBar =
                new JProgressBar(0, neededXP);

        xpBar.setValue(currentXP);

        xpBar.setStringPainted(true);

        xpBar.setString(
                currentXP + " / " + neededXP + " XP");

        xpBar.setMaximumSize(
                new Dimension(300, 25));

        levelLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        xpLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        focusLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        xpBar.setAlignmentX(Component.CENTER_ALIGNMENT);
        streakLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        bestStreakLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(Box.createVerticalGlue());

        add(levelLabel);
        add(Box.createVerticalStrut(15));

        add(xpLabel);
        add(Box.createVerticalStrut(15));

        add(focusLabel);
        add(Box.createVerticalStrut(15));

        add(streakLabel);
        add(Box.createVerticalStrut(15));

        add(bestStreakLabel);
        add(Box.createVerticalStrut(25));

        add(xpBar);

        AchievementService achievementService =
                new AchievementService();

        add(Box.createVerticalStrut(30));

        JLabel achievementTitle =
                new JLabel("🏆 Achievements");

        achievementTitle.setAlignmentX(
                Component.CENTER_ALIGNMENT);

        add(achievementTitle);

        add(Box.createVerticalStrut(10));

        for (Achievement achievement :
                achievementService.getAchievements()) {

            String status =
                    achievement.isUnlocked()
                            ? "✅ "
                            : "❌ ";

            JLabel achievementLabel =
                    new JLabel(
                            status +
                                    achievement.getTitle());

            achievementLabel.setAlignmentX(
                    Component.CENTER_ALIGNMENT);

            add(achievementLabel);
        }

        add(Box.createVerticalGlue());
    }
}