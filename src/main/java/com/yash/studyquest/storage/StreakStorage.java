package com.yash.studyquest.storage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yash.studyquest.model.StreakData;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class StreakStorage {

    private static final String FILE_NAME = "streak.json";

    private final Gson gson =
            new GsonBuilder().setPrettyPrinting().create();

    public StreakData load() {

        try {

            File file = new File(FILE_NAME);

            if (!file.exists()) {

                StreakData data = new StreakData();

                data.setCurrentStreak(0);
                data.setBestStreak(0);

                return data;
            }

            FileReader reader = new FileReader(file);

            StreakData data =
                    gson.fromJson(reader, StreakData.class);

            reader.close();

            return data;

        } catch (Exception e) {

            e.printStackTrace();

            return new StreakData();
        }
    }

    public void save(StreakData data) {

        try {

            FileWriter writer =
                    new FileWriter(FILE_NAME);

            gson.toJson(data, writer);

            writer.flush();
            writer.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}