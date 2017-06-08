package com.battlesnake.strategy;

import com.battlesnake.data.Move;
import com.battlesnake.data.MoveRequest;
import com.battlesnake.data.Snake;

import javax.websocket.RemoteEndpoint;
import java.util.ArrayList;
import java.util.List;


public class CheckFoodPosition implements BasicStrategy {
    public List<Move> makeAMove(MoveRequest request, List<Move> possibleSnakeMoves) {

        int[] foodCoords = request.getFood()[0];
        Snake me = SnakeUtils.findSnakeByUUID(request.getYou(),request.getSnakes());

        if(me != null) {
            int[][] coords = me.getCoords();
            int[] headCoords = coords[0];
            if (foodCoords[0] > headCoords[0] && movePossible(possibleSnakeMoves, Move.RIGHT)) {
                return returnMoveArray(Move.RIGHT);
            } else if (foodCoords[0] < headCoords[0] && movePossible(possibleSnakeMoves, Move.LEFT) ) {
                return returnMoveArray(Move.LEFT);
            }
            else {
                if (foodCoords[1] > headCoords[1] && movePossible(possibleSnakeMoves, Move.DOWN)) {
                    return returnMoveArray(Move.DOWN);
                } else if (foodCoords[1] < headCoords[1] && movePossible(possibleSnakeMoves, Move.UP) ) {
                    return returnMoveArray(Move.UP);
                }
            }
        }

        return possibleSnakeMoves;
    }


    private boolean movePossible(List<Move> possibleMoves, Move currentMove) {
        for(Move move : possibleMoves) {
            if (move == currentMove) {
                return true;
            }
        }
        return false;
    }

    private List<Move> returnMoveArray(Move move) {
        List<Move> moves = new ArrayList<>();
        moves.add(move);
        return moves;
    }
}
