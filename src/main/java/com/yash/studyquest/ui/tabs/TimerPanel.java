package com.yash.studyquest.ui.tabs;

import com.yash.studyquest.model.FocusSession;
import com.yash.studyquest.model.SettingsData;
import com.yash.studyquest.service.*;
import com.yash.studyquest.storage.SessionStorage;
import com.yash.studyquest.storage.SettingsStorage;
import com.yash.studyquest.ui.components.CircularTimerComponent;
import com.yash.studyquest.service.AchievementPopupService;
import com.yash.studyquest.service.AchievementService;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

public class TimerPanel extends JPanel {

    private SessionStorage sessionStorage;
    private boolean focusMode = true;
    private int focusDuration;

    private int breakDuration;

    private boolean paused = false;
    private JLabel modeLabel;
    private CircularTimerComponent timer;
    private JButton startButton;
    private JButton pauseButton;
    private JButton resetButton;

    private TimerService timerService;

    private String formatTime(int totalSeconds) {

        int minutes = totalSeconds / 60;

        int seconds = totalSeconds % 60;

        return String.format("%02d:%02d", minutes, seconds);
    }

    private void prepareCurrentMode() {

        int duration;

        if (focusMode) {

            duration = focusDuration;

            switchToFocusMode();

        } else {

            duration = breakDuration;

            switchToBreakMode();
        }

        timer.setTimeText(formatTime(duration));

        timer.setProgress(1.0);
    }

    private void switchToFocusMode() {

        focusMode = true;

        modeLabel.setText("FOCUS MODE");

        timer.setProgressColor(new Color(0, 170, 255));
    }

    private void switchToBreakMode() {

        focusMode = false;

        modeLabel.setText("BREAK MODE");

        timer.setProgressColor(new Color(0, 255, 120));
    }

    private JCheckBox autoStart;

    public TimerPanel() {

        SettingsStorage storage = new SettingsStorage();

        SettingsData settings = storage.load();

        focusDuration = settings.getFocusDuration();

        breakDuration = settings.getBreakDuration();

        System.out.println("Focus = " + focusDuration);
        System.out.println("Break = " + breakDuration);

        sessionStorage = new SessionStorage();

        modeLabel = new JLabel("FOCUS MODE");

        modeLabel.setFont(new Font("Arial", Font.BOLD, 18));

        modeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        timerService = new TimerService();
        setLayout(new BorderLayout());

        timer = new CircularTimerComponent();

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        timer.setAlignmentX(Component.CENTER_ALIGNMENT);

        startButton = new JButton("Start");
        pauseButton = new JButton("Pause");
        resetButton = new JButton("Reset");

        pauseButton.setEnabled(false);
        resetButton.setEnabled(false);

        JPanel buttonPanel = new JPanel();

        buttonPanel.add(startButton);
        buttonPanel.add(pauseButton);
        buttonPanel.add(resetButton);


        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        autoStart = new JCheckBox("Auto Start");
        autoStart.setAlignmentX(Component.CENTER_ALIGNMENT);

        centerPanel.add(Box.createVerticalGlue());

        centerPanel.add(modeLabel);

        centerPanel.add(Box.createVerticalStrut(15));

        centerPanel.add(timer);

        centerPanel.add(Box.createVerticalStrut(20));

        centerPanel.add(buttonPanel);

        centerPanel.add(Box.createVerticalStrut(10));

        centerPanel.add(autoStart);

        centerPanel.add(Box.createVerticalGlue());

        add(centerPanel, BorderLayout.CENTER);

        startButton.addActionListener(e -> {

            startButton.setEnabled(false);

            pauseButton.setEnabled(true);

            resetButton.setEnabled(true);

            timerService.setDuration(

                    focusMode ? focusDuration : breakDuration);

            timerService.setListener(new TimerService.TimerListener() {

                @Override
                public void onTick(int remainingSeconds) {

                    int minutes = remainingSeconds / 60;

                    int seconds = remainingSeconds % 60;

                    String text = String.format("%02d:%02d", minutes, seconds);

                    timer.setTimeText(text);

                    int totalDuration = focusMode ? focusDuration : breakDuration;

                    double progress = (double) remainingSeconds / totalDuration;

                    timer.setProgress(progress);
                }

                @Override
                public void onFinish() {

                    ChimeService.play();


                    if (focusMode) {

                        SessionStorage storage = new SessionStorage();

                        storage.saveSession(new FocusSession(LocalDateTime.now().toString(), focusDuration));
                        StreakService streakService =
                                new StreakService();

                        streakService.registerStudySession();

                        AchievementService achievementService =
                                new AchievementService();

                        if (achievementService.hasFirstSessionAchievement()) {

                            AchievementPopupService.show(
                                    "🥉 First Session"
                            );
                        }

                        JOptionPane.showMessageDialog(
                                TimerPanel.this,
                                "Focus Session Complete!"
                        );

                        focusMode = false;
                    } else {

                        JOptionPane.showMessageDialog(TimerPanel.this, "Break Complete!");

                        focusMode = true;
                    }

                    prepareCurrentMode();

                    startButton.setEnabled(true);

                    pauseButton.setEnabled(false);

                    resetButton.setEnabled(false);

                    pauseButton.setText("Pause");

                    paused = false;

                    if (autoStart.isSelected()) {

                        startButton.doClick();
                    }
                }
            });

            timerService.start();
        });

        pauseButton.addActionListener(e -> {

            if (!paused) {

                timerService.pause();

                pauseButton.setText("Resume");

                paused = true;

            } else {

                timerService.resume();

                pauseButton.setText("Pause");

                paused = false;
            }

        });

        resetButton.addActionListener(e -> {

            timerService.reset();

            timer.setTimeText(formatTime(focusDuration));

            timer.setProgress(1.0);

            startButton.setEnabled(true);

            pauseButton.setEnabled(false);

            resetButton.setEnabled(false);

            pauseButton.setText("Pause");

            paused = false;

        });

        prepareCurrentMode();
    }
}