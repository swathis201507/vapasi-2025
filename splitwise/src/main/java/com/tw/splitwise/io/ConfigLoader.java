package com.tw.splitwise.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {
    public static String getFilePath() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("/Users/swathis/IdeaProjects/vapasi-2025/splitwise/src/main/resources/application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty("expenses.file.path");
    }
}

