package com.example.example.service.strategy;

import com.example.example.model.Quest;

public interface QuestStrategy {
    boolean supports(String type);
    int calculateReward(Quest quest);
}