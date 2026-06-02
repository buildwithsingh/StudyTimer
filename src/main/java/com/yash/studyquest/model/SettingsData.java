package com.yash.studyquest.model;

public class SettingsData {

    private int focusDuration;

    private int breakDuration;

    private boolean autoStart;

    public SettingsData() {
    }

    public SettingsData(
            int focusDuration,
            int breakDuration,
            boolean autoStart) {

        this.focusDuration = focusDuration;
        this.breakDuration = breakDuration;
        this.autoStart = autoStart;
    }

    public int getFocusDuration() {
        return focusDuration;
    }

    public void setFocusDuration(int focusDuration) {
        this.focusDuration = focusDuration;
    }

    public int getBreakDuration() {
        return breakDuration;
    }

    public void setBreakDuration(int breakDuration) {
        this.breakDuration = breakDuration;
    }

    public boolean isAutoStart() {
        return autoStart;
    }

    public void setAutoStart(boolean autoStart) {
        this.autoStart = autoStart;
    }
}