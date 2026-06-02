package com.yash.studyquest;

import com.formdev.flatlaf.FlatDarkLaf;
import com.yash.studyquest.model.SettingsData;
import com.yash.studyquest.model.StreakData;
import com.yash.studyquest.service.StatisticsService;
import com.yash.studyquest.service.StreakService;
import com.yash.studyquest.storage.SettingsStorage;
import com.yash.studyquest.storage.StreakStorage;
import com.yash.studyquest.ui.MainFrame;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        FlatDarkLaf.setup();

        SwingUtilities.invokeLater(() -> {
            new MainFrame();
        });

        SettingsStorage storage =
                new SettingsStorage();

        storage.save(
                new SettingsData(
                        50,
                        10,
                        true
                )
        );

        SettingsData settings =
                storage.load();

        System.out.println(
                settings.getFocusDuration());

        System.out.println(
                settings.getBreakDuration());

        System.out.println(
                settings.isAutoStart());    }
}