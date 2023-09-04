package org.openjfx.classes;

public class Punctuation {
    private String name;
    private int score;

    public Punctuation(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }
}

