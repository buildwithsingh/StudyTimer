package com.yash.studyquest.storage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yash.studyquest.model.SettingsData;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class SettingsStorage {

    private static final String FILE_NAME = "settings.json";

    private final Gson gson =
            new GsonBuilder()
                    .setPrettyPrinting()
                    .create();

    public void save(SettingsData settings) {

        try {

            File file = new File(FILE_NAME);

            System.out.println(
                    "Saving To: "
                            + file.getAbsolutePath()
            );

            FileWriter writer =
                    new FileWriter(file);

            gson.toJson(settings, writer);

            writer.close();

            System.out.println(
                    "Saved Settings -> Focus: "
                            + settings.getFocusDuration()
                            + " Break: "
                            + settings.getBreakDuration()
            );

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public SettingsData load() {

        try {

            File file = new File(FILE_NAME);

            System.out.println(
                    "Loading From: "
                            + file.getAbsolutePath()
            );

            System.out.println(
                    "File Exists: "
                            + file.exists()
            );

            if (!file.exists()) {

                System.out.println(
                        "Using Default Settings"
                );

                return new SettingsData(
                        25,
                        5,
                        false
                );
            }

            FileReader reader =
                    new FileReader(file);

            SettingsData data =
                    gson.fromJson(
                            reader,
                            SettingsData.class
                    );

            reader.close();

            System.out.println(
                    "Loaded Focus: "
                            + data.getFocusDuration()
            );

            System.out.println(
                    "Loaded Break: "
                            + data.getBreakDuration()
            );

            System.out.println(
                    "Loaded AutoStart: "
                            + data.isAutoStart()
            );

            return data;

        } catch (Exception e) {

            e.printStackTrace();
        }

        System.out.println(
                "Failed Loading -> Using Defaults"
        );

        return new SettingsData(
                25,
                5,
                false
        );
    }
}