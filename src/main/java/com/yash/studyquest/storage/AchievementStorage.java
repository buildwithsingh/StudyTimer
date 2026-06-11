package com.yash.studyquest.storage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yash.studyquest.model.AchievementData;

import java.io.FileReader;
import java.io.FileWriter;

public class AchievementStorage {

    private static final String FILE_NAME =
            "achievements.json";

    private final Gson gson =
            new GsonBuilder()
                    .setPrettyPrinting()
                    .create();

    public void save(
            AchievementData data) {

        try(FileWriter writer =
                    new FileWriter(FILE_NAME)) {

            gson.toJson(data, writer);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public AchievementData load() {

        try(FileReader reader =
                    new FileReader(FILE_NAME)) {

            AchievementData data =
                    gson.fromJson(
                            reader,
                            AchievementData.class
                    );

            if(data != null) {
                return data;
            }

        } catch(Exception ignored) {
        }

        return new AchievementData();
    }
}