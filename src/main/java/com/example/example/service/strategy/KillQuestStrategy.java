package com.example.example.service.strategy;

import com.example.example.model.Quest;
import org.springframework.stereotype.Component;

@Component
public class KillQuestStrategy implements QuestStrategy {
    @Override
    public boolean supports(String type) {
        return "KILL".equalsIgnoreCase(type);
    }

    @Override
    public int calculateReward(Quest quest) {
        if (quest.getProgress() >= 100) {
            return quest.getDifficulty() * 100;
        }
        return 0;
    }
}