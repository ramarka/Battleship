package edu.bu.met.cs665.battleshipgame;

public interface GameState {

    // Interface for State pattern implementation.
    void displayBoard(String[][] board);
    Integer shoot(String[][] playerBoard, String[][] opponentBoard);
    void initialize();






}
