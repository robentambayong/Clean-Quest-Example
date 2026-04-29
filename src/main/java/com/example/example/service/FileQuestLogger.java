package com.example.example.service;

import org.springframework.stereotype.Component;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@Component
public class FileQuestLogger implements QuestLogger {
    @Override
    public void logReward(String name, int reward) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("quest_log.txt", true))) {
            writer.write("Quest: " + name + " | Reward: " + reward);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error saving quest log: " + e.getMessage());
        }
    }
}