package com.example.example.model;

public class Quest {
    private String name;
    private String type;
    private int difficulty;
    private int progress;

    public Quest() {}

    public Quest(String name, String type, int difficulty, int progress) {
        this.name = name;
        this.type = type;
        this.difficulty = difficulty;
        this.progress = progress;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public int getDifficulty() { return difficulty; }
    public void setDifficulty(int difficulty) { this.difficulty = difficulty; }
    public int getProgress() { return progress; }
    public void setProgress(int progress) { this.progress = progress; }
}
