package com.example.example.service;

import com.example.example.model.Quest;

public interface QuestService {
    // Trigger Discussion: dependency inversion principle (DIP)
    int processQuestLogic(String name, String type, int difficulty, int progress);
    
    // Methods that we are not using yet
    int calculateReward(Quest quest);
    boolean isCompleted(Quest quest);
}
