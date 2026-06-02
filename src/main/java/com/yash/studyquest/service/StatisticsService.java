package com.yash.studyquest.service;

import com.yash.studyquest.model.FocusSession;
import com.yash.studyquest.storage.SessionStorage;

import java.util.List;

public class StatisticsService {

    private final SessionStorage sessionStorage =
            new SessionStorage();

    public int getTotalFocusMinutes() {

        List<FocusSession> sessions =
                sessionStorage.loadSessions();

        int total = 0;

        for (FocusSession session : sessions) {

            total += session.getFocusMinutes();
        }

        return total;
    }

    public int getTotalXP() {

        return getTotalFocusMinutes();
    }
    public int getLevel() {

        return (getTotalXP() / 60) + 1;
    }
    public int getXPIntoCurrentLevel() {

        return getTotalXP() % 60;
    }
    public int getXPNeededForNextLevel() {

        return 60;
    }

}