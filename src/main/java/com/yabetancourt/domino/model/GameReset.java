package com.yabetancourt.domino.model;

import java.util.List;

public class GameReset {

    private int position;
    private List<List<Integer>> pieces;
    private int maxNumber;
    private int timeout;
    private int score;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public List<List<Integer>> getPieces() {
        return pieces;
    }

    public void setPieces(List<List<Integer>> pieces) {
        this.pieces = pieces;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
