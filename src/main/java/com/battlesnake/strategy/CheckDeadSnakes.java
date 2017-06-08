package com.battlesnake.strategy;


import com.battlesnake.data.Move;
import com.battlesnake.data.MoveRequest;
import com.battlesnake.data.Snake;

import java.util.ArrayList;
import java.util.List;

public class CheckDeadSnakes implements BasicStrategy {

    @Override
    public List<Move> makeAMove(MoveRequest request, List<Move> moves) {
        Snake me = SnakeUtils.findSnakeByUUID(request.getYou(),request.getSnakes());

        List<Move> remainingMoves = new ArrayList<>();
        if(me != null) {
            int[][] coords = me.getCoords();
            int[] head = coords[0];
            int[] upCoords = SnakeUtils.getPossibleMoveCoord(head, Move.UP);
            int[] downCoords = SnakeUtils.getPossibleMoveCoord(head, Move.DOWN);
            int[] leftCoords = SnakeUtils.getPossibleMoveCoord(head, Move.LEFT);
            int[] rightCoords = SnakeUtils.getPossibleMoveCoord(head, Move.RIGHT);

            for(Snake snake: request.getDeadSnakes()) {
                int[][] snakeCoords = snake.getCoords();
                for(int i=1; i<snakeCoords.length; i++) {
                    if (SnakeUtils.sameCoords(upCoords, snakeCoords[i])) {
                        moves.remove(Move.UP);
                    }

                    if (SnakeUtils.sameCoords(downCoords, snakeCoords[i])) {
                        moves.remove(Move.DOWN);
                    }

                    if (SnakeUtils.sameCoords(leftCoords, snakeCoords[i])) {
                        moves.remove(Move.LEFT);
                    }

                    if (SnakeUtils.sameCoords(rightCoords, snakeCoords[i])) {
                        moves.remove(Move.RIGHT);
                    }
                }
            }

        }
        return moves;
    }
}