package com.example.example.service.strategy;

import com.example.example.model.Quest;
import org.springframework.stereotype.Component;

@Component
public class EscortQuestStrategy implements QuestStrategy {
    @Override
    public boolean supports(String type) {
        return "ESCORT".equalsIgnoreCase(type);
    }

    @Override
    public int calculateReward(Quest quest) {
        if (quest.getProgress() >= 1) {
            // BUG FIXED: 500 instead of 5000
            return quest.getDifficulty() * 500;
        }
        return 0;
    }
}