package com.yash.studyquest.model;

import java.time.LocalDateTime;

public class FocusSession {

    private String completedAt;

    private int focusMinutes;

    public FocusSession() {

    }

    public FocusSession(
            String completedAt,
            int focusMinutes) {

        this.completedAt = completedAt;
        this.focusMinutes = focusMinutes;
    }

    public String getCompletedAt() {
        return completedAt;
    }

    public int getFocusMinutes() {
        return focusMinutes;
    }
}