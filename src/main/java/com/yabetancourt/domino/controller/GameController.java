package com.yabetancourt.domino.controller;

import com.yabetancourt.domino.model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class GameController {

    private final GameState state = new GameState();

    @GetMapping("/start")
    public ResponseEntity<Map<String, Boolean>> startGame() {
        Map<String, Boolean> response = new HashMap<>();
        response.put("start", true);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/reset")
    public ResponseEntity<Void> resetGame(@RequestBody GameReset request) {
        state.reset(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/step")
    public ResponseEntity<GameStepResponse> makeMove(@RequestBody GameStepRequest request) {
        GameStepResponse response = state.makeMove(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/log")
    public ResponseEntity<Void> logEvent(@RequestBody GameLog request) {
        state.logEvent(request);
        return ResponseEntity.ok().build();
    }

}
