package com.example.example.controller;

import com.example.example.model.Quest;
import com.example.example.service.QuestService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quests")
public class QuestController {

    private final QuestService questService;

    public QuestController(QuestService questService) {
        this.questService = questService;
    }

    @PostMapping("/process")
    public String process(@RequestBody Quest quest) {
        // To keep things simple, let's just use System.out.println for logging.
        System.out.println("DEBUG: Received request for " + quest.getName());

        // Trigger Question: Does the controller follow SRP?
        if (quest.getType() == null || quest.getType().isEmpty()) {
            return "ERROR: Quest type is missing!";
        }

        // Trigger Discussion: dependency inversion principle (DIP)
        int reward = questService.processQuestLogic(
            quest.getName(), 
            quest.getType(), 
            quest.getDifficulty(), 
            quest.getProgress()
        );

        if (reward > 1000) {
            System.out.println("WOW: Big reward for " + quest.getName());
        }

        if (reward > 0) {
            return "SUCCESS: Reward is " + reward;
        } else {
            return "FAILED: Not done yet.";
        }
    }
}
