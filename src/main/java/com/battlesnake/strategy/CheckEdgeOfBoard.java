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
    List<Move> makeAMove(MoveRequest request, List<Move> possibleMoves) {
        Snake us = SnakeUtils.findSnakeByUUID(request.getYou(), request.getSnakes());
        int boardSize = request.getHeight();

        for (Move move: possibleMoves) {
            if (SnakeUtils.getPossibleMoveCoord(us.getCoords()[0], possibleMoves);
        }

        return new ArrayList<Move>();
    }


}
