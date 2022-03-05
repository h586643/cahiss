package com.ebookfrenzy.cahiss.utils;

public class Score {

    // Class variables
    private int score;
    private int attempts;

    // Getter & setter for score
    public int getScore() {
        return score;
    }

    // Automatically increment
    public void setScore() {
        this.score++;
    }

    // Getter & setter for attempts
    public int getAttempts() {
        return attempts;
    }

    // Automatically increment
    public void setAttempts() {
        this.attempts++;
    }

    @Override
    public String toString() {
        return score + " / " + attempts;
    }
}
