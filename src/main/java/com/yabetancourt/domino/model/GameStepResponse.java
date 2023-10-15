package com.yabetancourt.domino.model;

import java.util.List;

public class GameStepResponse {
    private List<Integer> piece;
    private Integer head;

    public List<Integer> getPiece() {
        return piece;
    }

    public void setPiece(List<Integer> piece) {
        this.piece = piece;
    }

    public Integer getHead() {
        return head;
    }

    public void setHead(Integer head) {
        this.head = head;
    }
}
