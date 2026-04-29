package com.example.example.controller;

import com.example.example.model.Quest;
import com.example.example.service.QuestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quests")
public class QuestController {

    private final QuestService questService;

    public QuestController(QuestService questService) {
        this.questService = questService;
    }

    @PostMapping("/process")
    public ResponseEntity<String> process(@RequestBody Quest quest) {
        try {
            int reward = questService.processQuestLogic(
                    quest.getName(),
                    quest.getType(),
                    quest.getDifficulty(),
                    quest.getProgress()
            );

            if (reward > 0) {
                return ResponseEntity.ok("SUCCESS: Reward is " + reward);
            } else {
                return ResponseEntity.ok("FAILED: Not done yet.");
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("ERROR: " + e.getMessage());
        }
    }
}