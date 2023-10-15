package com.yabetancourt.domino.model;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class GameState {
    private final Logger logger = Logger.getLogger(GameState.class.getName());
    private int position;
    private List<List<Integer>> pieces;
    private int maxNumber;
    private int timeout;
    private int score;
    private List<GameLog> logs;

    public GameState() {
        this.position = 0;
        this.pieces = new ArrayList<>();
        this.maxNumber = 0;
        this.timeout = 0;
        this.score = 0;
        logs = new ArrayList<>();
    }

    public void reset(GameReset request) {
        logger.info("reset");
        this.position = request.getPosition();
        this.pieces = request.getPieces();
        this.maxNumber = request.getMaxNumber();
        this.timeout = request.getTimeout();
        this.score = request.getScore();
        this.logs = new ArrayList<>();
    }

    public GameStepResponse makeMove(GameStepRequest request) {
        List<Integer> heads = request.getHeads();
        List<List<Integer>> possibleMoves = getPossibleMoves(heads);
        logger.info("Possible moves: " + possibleMoves);
        // Buscar la ficha más grande dentro de las posibles jugadas
        List<Integer> largestPiece = null;
        Integer largestPieceIndex = null;
        for (List<Integer> piece : possibleMoves) {
            if (largestPiece == null || getPieceValue(piece) > getPieceValue(largestPiece)) {
                largestPiece = piece;
                largestPieceIndex = piece.get(0) == heads.get(0) || piece.get(1) == heads.get(0) ? 0 : 1;
            }
        }
        logger.info("largest piece " + largestPiece);
        // Realizar la jugada con la ficha más grande
        GameStepResponse response = new GameStepResponse();
        response.setPiece(largestPiece);
        response.setHead(largestPieceIndex);

        pieces.remove(largestPiece);

        logger.info("Remaining pieces " + pieces);

        return response;
    }

    private List<List<Integer>> getPossibleMoves(List<Integer> heads) {
        if (heads.get(0) == -1 && heads.get(1) == -1) {
            return pieces;
        }
        List<List<Integer>> possibleMoves = new ArrayList<>();

        for (List<Integer> piece : pieces) {
            int leftNumber = piece.get(0);
            int rightNumber = piece.get(1);

            if (leftNumber == heads.get(0) || rightNumber == heads.get(0)) {
                possibleMoves.add(piece);
            } else if (leftNumber == heads.get(1) || rightNumber == heads.get(1)) {
                // Invertir la ficha para que el número coincida con el segundo número de los heads
                List<Integer> invertedPiece = new ArrayList<>(piece);
                invertedPiece.set(0, rightNumber);
                invertedPiece.set(1, leftNumber);
                possibleMoves.add(invertedPiece);
            }
        }

        return possibleMoves;
    }

    private int getPieceValue(List<Integer> piece) {
        int value = 0;
        for (int number : piece) {
            value += number;
        }
        return value;
    }

    public void logEvent(GameLog log) {
        logs.add(log);
        logger.info("Event " + log.getEvent());
    }

}
