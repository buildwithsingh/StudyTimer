package com.yash.studyquest.service;

import com.yash.studyquest.model.StreakData;
import com.yash.studyquest.storage.StreakStorage;

import java.time.LocalDate;

public class StreakService {

    private final StreakStorage storage = new StreakStorage();

    public void registerStudySession() {

        StreakData data = storage.load();

        LocalDate today = LocalDate.now();

        String lastDateString = data.getLastStudyDate();

        if (lastDateString == null) {

            data.setCurrentStreak(1);

        } else {

            LocalDate lastDate = LocalDate.parse(lastDateString);

            long days = lastDate.until(today).getDays();

            if (days == 0) {

                return;
            }

            if (days == 1) {

                data.setCurrentStreak(data.getCurrentStreak() + 1);

            } else {

                data.setCurrentStreak(1);
            }
        }

        data.setLastStudyDate(today.toString());

        if (data.getCurrentStreak() > data.getBestStreak()) {

            data.setBestStreak(data.getCurrentStreak());
        }

        storage.save(data);
    }

    public int getCurrentStreak() {

        return storage.load().getCurrentStreak();
    }

    public int getBestStreak() {

        return storage.load().getBestStreak();
    }
}