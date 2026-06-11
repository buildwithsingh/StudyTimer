package com.yash.studyquest.model;

public class AchievementData {

    private boolean firstSession;

    private boolean hundredMinutes;

    private boolean sevenDayStreak;

    private boolean levelFive;

    private boolean thirtyDayStreak;

    public AchievementData() {
    }

    public boolean isFirstSession() {
        return firstSession;
    }

    public void setFirstSession(boolean firstSession) {
        this.firstSession = firstSession;
    }

    public boolean isHundredMinutes() {
        return hundredMinutes;
    }

    public void setHundredMinutes(boolean hundredMinutes) {
        this.hundredMinutes = hundredMinutes;
    }

    public boolean isSevenDayStreak() {
        return sevenDayStreak;
    }

    public void setSevenDayStreak(boolean sevenDayStreak) {
        this.sevenDayStreak = sevenDayStreak;
    }

    public boolean isLevelFive() {
        return levelFive;
    }

    public void setLevelFive(boolean levelFive) {
        this.levelFive = levelFive;
    }

    public boolean isThirtyDayStreak() {
        return thirtyDayStreak;
    }

    public void setThirtyDayStreak(boolean thirtyDayStreak) {
        this.thirtyDayStreak = thirtyDayStreak;
    }
}