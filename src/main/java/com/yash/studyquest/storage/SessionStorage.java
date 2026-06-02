package com.yash.studyquest.storage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.yash.studyquest.model.FocusSession;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SessionStorage {

    private static final String FILE_NAME =
            "sessions.json";

    private final Gson gson =
            new GsonBuilder()
                    .setPrettyPrinting()
                    .create();

    public List<FocusSession> loadSessions() {

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (Reader reader =
                     new FileReader(file)) {

            Type listType =
                    new TypeToken<List<FocusSession>>() {
                    }.getType();

            List<FocusSession> sessions =
                    gson.fromJson(reader, listType);

            return sessions == null
                    ? new ArrayList<>()
                    : sessions;

        } catch (Exception e) {

            e.printStackTrace();

            return new ArrayList<>();
        }
    }

    public void saveSession(
            FocusSession session) {

        List<FocusSession> sessions =
                loadSessions();

        sessions.add(session);

        try (Writer writer =
                     new FileWriter(FILE_NAME)) {

            gson.toJson(sessions, writer);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}