package com.yash.studyquest.service;

import com.yash.studyquest.model.Achievement;

import java.util.ArrayList;
import java.util.List;

public class AchievementService {

    public List<Achievement> getAchievements() {

        StatisticsService stats =
                new StatisticsService();

        StreakService streakService =
                new StreakService();

        List<Achievement> achievements =
                new ArrayList<>();

        achievements.add(
                new Achievement(
                        "🥉 First Session",
                        stats.getTotalFocusMinutes() >= 10
                )
        );

        achievements.add(
                new Achievement(
                        "🥈 100 Focus Minutes",
                        stats.getTotalFocusMinutes() >= 100
                )
        );

        achievements.add(
                new Achievement(
                        "🥇 7 Day Streak",
                        streakService.getCurrentStreak() >= 7
                )
        );

        achievements.add(
                new Achievement(
                        "👑 Level 5",
                        stats.getLevel() >= 5
                )
        );

        achievements.add(
                new Achievement(
                        "🔥 30 Day Streak",
                        streakService.getCurrentStreak() >= 30
                )
        );

        return achievements;
    }
}