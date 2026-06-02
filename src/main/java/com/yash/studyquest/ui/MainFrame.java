package com.yash.studyquest.ui;

import com.yash.studyquest.ui.tabs.SettingsPanel;
import com.yash.studyquest.ui.tabs.StatisticsPanel;
import com.yash.studyquest.ui.tabs.StopwatchPanel;
import com.yash.studyquest.ui.tabs.TimerPanel;

import javax.swing.*;

public class MainFrame extends JFrame {

    public MainFrame() {

        setTitle("Study Quest");
        setSize(1000,700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();

        tabbedPane.addTab("Timer", new TimerPanel());
        tabbedPane.addTab("Stopwatch", new StopwatchPanel());
        tabbedPane.addTab("Statistics", new StatisticsPanel());
        tabbedPane.addTab("Settings", new SettingsPanel());

        add(tabbedPane);

        setVisible(true);
    }
}