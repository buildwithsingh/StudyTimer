package com.yash.studyquest.ui.tabs;

import com.yash.studyquest.model.SettingsData;
import com.yash.studyquest.storage.SettingsStorage;

import javax.swing.*;
import java.awt.*;

public class SettingsPanel extends JPanel {

    public SettingsPanel() {

        setLayout(new BoxLayout(this,
                BoxLayout.Y_AXIS));

        SettingsStorage storage =
                new SettingsStorage();

        SettingsData settings =
                storage.load();

        JLabel focusLabel =
                new JLabel("Focus Duration");

        JTextField focusField =
                new JTextField(
                        String.valueOf(
                                settings.getFocusDuration()
                        )
                );

        JLabel breakLabel =
                new JLabel("Break Duration");

        JTextField breakField =
                new JTextField(
                        String.valueOf(
                                settings.getBreakDuration()
                        )
                );

        JCheckBox autoStartBox =
                new JCheckBox("Auto Start");

        autoStartBox.setSelected(
                settings.isAutoStart()
        );

        JButton saveButton =
                new JButton("Save");

        saveButton.addActionListener(e -> {

            System.out.println("Focus Text = "
                    + focusField.getText());

            System.out.println("Break Text = "
                    + breakField.getText());

            int focusDuration =
                    Integer.parseInt(
                            focusField.getText()
                    );

            int breakDuration =
                    Integer.parseInt(
                            breakField.getText()
                    );

            System.out.println("Parsed Focus = "
                    + focusDuration);

            System.out.println("Parsed Break = "
                    + breakDuration);

            boolean autoStart =
                    autoStartBox.isSelected();

            SettingsData newSettings =
                    new SettingsData(
                            focusDuration,
                            breakDuration,
                            autoStart
                    );

            storage.save(newSettings);

            System.out.println("SAVE EXECUTED");

            JOptionPane.showMessageDialog(
                    this,
                    "Settings Saved!"
            );
        });

        focusLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT);

        focusField.setMaximumSize(
                new Dimension(100,30));

        breakLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT);

        breakField.setMaximumSize(
                new Dimension(100,30));

        autoStartBox.setAlignmentX(
                Component.CENTER_ALIGNMENT);

        saveButton.setAlignmentX(
                Component.CENTER_ALIGNMENT);

        add(Box.createVerticalGlue());

        add(focusLabel);
        add(focusField);

        add(Box.createVerticalStrut(20));

        add(breakLabel);
        add(breakField);

        add(Box.createVerticalStrut(20));

        add(autoStartBox);

        add(Box.createVerticalStrut(20));

        add(saveButton);

        add(Box.createVerticalGlue());
    }
}