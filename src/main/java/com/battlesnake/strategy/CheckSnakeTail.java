package com.battlesnake.strategy;

import com.battlesnake.data.Move;
import com.battlesnake.data.MoveRequest;
import com.battlesnake.data.Snake;

import java.util.ArrayList;
import java.util.List;

public class CheckSnakeTail implements BasicStrategy {

    @Override public List<Move> makeAMove(MoveRequest request, List<Move> moves) {
        Snake me = SnakeUtils.findSnakeByUUID(request.getYou(),request.getSnakes());

        List<Move> remainingMoves = new ArrayList<>();
        if(me != null) {
            int[][] coords = me.getCoords();
            int[] head = coords[0];
            int[] upCoords = SnakeUtils.getPossibleMoveCoord(head, Move.UP);
            int[] downCoords = SnakeUtils.getPossibleMoveCoord(head, Move.DOWN);
            int[] leftCoords = SnakeUtils.getPossibleMoveCoord(head, Move.LEFT);
            int[] rightCoords = SnakeUtils.getPossibleMoveCoord(head, Move.RIGHT);

            List<Move> possibleMoves = new ArrayList<>();
            possibleMoves.add(Move.UP);
            possibleMoves.add(Move.DOWN);
            possibleMoves.add(Move.RIGHT);
            possibleMoves.add(Move.LEFT);

            for(int i=1; i<coords.length; i++) {
                if (SnakeUtils.sameCoords(upCoords, coords[i])) {
                    possibleMoves.remove(Move.UP);
                }

                if (SnakeUtils.sameCoords(downCoords, coords[i])) {
                    possibleMoves.remove(Move.DOWN);
                }

                if (SnakeUtils.sameCoords(leftCoords, coords[i])) {
                    possibleMoves.remove(Move.LEFT);
                }

                if (SnakeUtils.sameCoords(rightCoords, coords[i])) {
                    possibleMoves.remove(Move.RIGHT);
                }
            }
        }
        return remainingMoves;
    }
}
