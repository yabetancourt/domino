package com.yabetancourt.domino.model;

import java.util.List;

public class GameLog {
    private String event;
    private List<Object> args;

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public List<Object> getArgs() {
        return args;
    }

    public void setArgs(List<Object> args) {
        this.args = args;
    }
}
