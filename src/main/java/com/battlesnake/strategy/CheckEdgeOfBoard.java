package com.battlesnake.strategy;

import com.battlesnake.data.MoveRequest;
import com.battlesnake.data.Snake;
import com.battlesnake.strategy.SnakeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adahlquist on 2017-06-08.
 */
public class CheckEdgeOfBoard implements BasicStrategy {
    public List<Move> makeAMove(MoveRequest request, List<Move> possibleMoves) {
        List<Move> nextPossibleMoves = new ArrayList<>();

        Snake us = SnakeUtils.findSnakeByUUID(request.getYou(), request.getSnakes());
        int boardSize = request.getHeight();

        for (Move move: possibleMoves) {
            int[] possbileMoveCoord = SnakeUtils.getPossibleMoveCoord(us.getCoords()[0], move);
            if (!(possbileMoveCoord[0] < 0 || possbileMoveCoord[0] == boardSize ||
                    possbileMoveCoord[1] < 0 || possbileMoveCoord[1] == boardSize)) {
                nextPossibleMoves.add(move);
            }
        }

        return nextPossibleMoves;
    }


}
