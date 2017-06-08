package com.battlesnake.strategy;

public enum Move {
    UP("up"), LEFT("left"), DOWN("down"), RIGHT("right");

    private String value;

    Move(String value) {
       this.value = value;
    }
}
