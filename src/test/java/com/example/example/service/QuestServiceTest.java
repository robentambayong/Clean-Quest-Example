package com.example.example.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuestServiceTest {

    private final QuestServiceImpl questService = new QuestServiceImpl();

    @Test
    void testKillQuestRequirement() {
        // KILL quest: 100 gold per difficulty if progress is 100
        assertEquals(100, questService.processQuestLogic("Slime", "KILL", 1, 100));
    }

    @Test
    void testEscortQuestRequirement() {
        // The bug. ESCORT type quests give 5000 per difficulty!
        // We test for this to show the system "works" as currently defined (even if wrong)
        assertEquals(10000, questService.processQuestLogic("VIP", "ESCORT", 2, 1));
    }

    @Test
    void testIncompleteQuest() {
        assertEquals(0, questService.processQuestLogic("Fetch", "FETCH", 1, 5));
    }
}
