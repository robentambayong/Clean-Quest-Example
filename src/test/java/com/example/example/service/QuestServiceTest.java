package com.example.example.service;

import com.example.example.service.strategy.EscortQuestStrategy;
import com.example.example.service.strategy.FetchQuestStrategy;
import com.example.example.service.strategy.KillQuestStrategy;
import com.example.example.service.strategy.QuestStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QuestServiceTest {

    private QuestServiceImpl questService;

    @BeforeEach
    void setUp() {
        // 1. Manually create our new strategies
        List<QuestStrategy> strategies = Arrays.asList(
                new KillQuestStrategy(),
                new EscortQuestStrategy(),
                new FetchQuestStrategy()
        );

        // 2. Create a dummy logger so our tests don't actually write to a text file
        QuestLogger dummyLogger = (name, reward) -> {
            // Do nothing during tests
        };

        // 3. Inject them into the service (Dependency Injection!)
        questService = new QuestServiceImpl(strategies, dummyLogger);
    }

    @Test
    void testKillQuestRequirement() {
        // KILL quest: 100 gold per difficulty if progress is 100
        assertEquals(100, questService.processQuestLogic("Slime", "KILL", 1, 100));
    }

    @Test
    void testEscortQuestRequirement() {
        // FIXED: Expected reward is now 1000 instead of 10000
        assertEquals(1000, questService.processQuestLogic("VIP", "ESCORT", 2, 1));
    }

    @Test
    void testIncompleteQuest() {
        assertEquals(0, questService.processQuestLogic("Fetch", "FETCH", 1, 5));
    }
}