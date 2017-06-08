package com.battlesnake.strategy;

import com.battlesnake.data.Move;
import com.battlesnake.data.MoveRequest;

import java.util.ArrayList;
import java.util.List;

public class CheckOtherSnakes implements BasicStrategy {

    public List<Move> makeAMove(MoveRequest request, List<Move> possibleSnakeMoves) {
        return new ArrayList<>();
    }
}
