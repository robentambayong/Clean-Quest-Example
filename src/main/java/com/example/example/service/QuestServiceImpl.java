package com.example.example.service;

import com.example.example.model.Quest;
import com.example.example.service.strategy.QuestStrategy;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class QuestServiceImpl implements QuestService {

    private final List<QuestStrategy> strategies;
    private final QuestLogger questLogger;

    // Constructor Injection
    public QuestServiceImpl(List<QuestStrategy> strategies, QuestLogger questLogger) {
        this.strategies = strategies;
        this.questLogger = questLogger;
    }

    @Override
    public int processQuestLogic(String name, String type, int difficulty, int progress) {
        Quest quest = new Quest(name, type, difficulty, progress);

        int reward = strategies.stream()
                .filter(strategy -> strategy.supports(type))
                .findFirst()
                .map(strategy -> strategy.calculateReward(quest))
                .orElseThrow(() -> new IllegalArgumentException("Unsupported quest type: " + type));

        if (reward > 0) {
            questLogger.logReward(name, reward);
        }

        return reward;
    }

    @Override public int calculateReward(Quest q) { return 0; }
    @Override public boolean isCompleted(Quest q) { return false; }
}