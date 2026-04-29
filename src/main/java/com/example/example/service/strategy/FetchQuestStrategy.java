package com.example.example.service.strategy;

import com.example.example.model.Quest;
import org.springframework.stereotype.Component;

@Component
public class FetchQuestStrategy implements QuestStrategy {
    @Override
    public boolean supports(String type) {
        return "FETCH".equalsIgnoreCase(type);
    }

    @Override
    public int calculateReward(Quest quest) {
        if (quest.getProgress() >= 10) {
            return quest.getDifficulty() * 50;
        }
        return 0;
    }
}