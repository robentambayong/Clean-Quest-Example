package com.example.example.service;

import com.example.example.model.Quest;
import org.springframework.stereotype.Service;
import java.io.*;

@Service
public class QuestServiceImpl implements QuestService {

    // Trigger Question: Identify the issues in this code.
    public int processQuestLogic(String name, String type, int difficulty, int progress) {
        int reward = 0;

        if (type.equals("KILL")) { // E.g., kill 100 goblins
            if (progress >= 100) {
                reward = difficulty * 100;
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter("quest_log.txt", true));
                    writer.write("Quest: " + name + " | Reward: " + reward);
                    writer.newLine();
                    writer.close();
                } catch (IOException e) {
                    System.out.println("Error saving!");
                }
            }
        } else if (type.equals("FETCH")) { // E.g., gather 10 palm oils
            if (progress >= 10) {
                reward = difficulty * 50;
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter("quest_log.txt", true));
                    writer.write("Quest: " + name + " | Reward: " + reward);
                    writer.newLine();
                    writer.close();
                } catch (IOException e) {
                    System.out.println("Error saving!");
                }
            }
        } else if (type.equals("ESCORT")) { // E.g., escort Pak Burhan
            if (progress >= 1) {
                // To make it more obvious in the lecture session, the following line is the bug!
                reward = difficulty * 5000; 
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter("quest_log.txt", true));
                    writer.write("Quest: " + name + " | Reward: " + reward);
                    writer.newLine();
                    writer.close();
                } catch (IOException e) {
                    System.out.println("Error saving!");
                }
            }
        }
        return reward;
    }

    // Dummy implementations to satisfy the interface for now
    @Override public int calculateReward(Quest q) { return 0; }
    @Override public boolean isCompleted(Quest q) { return false; }
}
