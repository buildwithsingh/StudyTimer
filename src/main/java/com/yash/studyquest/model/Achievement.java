package com.yash.studyquest.model;

public class Achievement {

    private String title;

    private boolean unlocked;

    public Achievement(String title, boolean unlocked) {
        this.title = title;
        this.unlocked = unlocked;
    }

    public String getTitle() {
        return title;
    }

    public boolean isUnlocked() {
        return unlocked;
    }
}