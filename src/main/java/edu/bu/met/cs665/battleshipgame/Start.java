package edu.bu.met.cs665.battleshipgame;

import java.util.Random;

public class Start implements GameState {
    private int rows = 5;
    private int columns = 5;



    //used a 2D Array to represent player attack and defense boards
    private String[][] player2AtkBoard = new String[rows][columns];
    private String[][] player2DefBoard = new String[rows][columns];

    private String[][] player1AtkBoard = new String[rows][columns];
    private String[][] player1DefBoard = new String[rows][columns];

    @Override
    public void displayBoard(String[][] board) {
        System.out.println("Cannot Display board during game initialization");
    }

    @Override
    public Integer shoot(String[][] board1, String [][] board2) {
        System.out.println("Cannot attack on game start up");
        return null;

    }

    @Override
    public void initialize() {

        //Set up for the game
        setBoard(player1AtkBoard);
        setBoard(player2AtkBoard);
        setBoard(player1DefBoard);
        setBoard(player2DefBoard);
        placeBattleship(player1DefBoard);
        placeBattleship(player2DefBoard);



    }

    public String[][] getPlayer2AtkBoard() {
        return player2AtkBoard;
    }


    public String[][] getPlayer2DefBoard() {
        return player2DefBoard;
    }

    public String[][] getPlayer1AtkBoard() {
        return player1AtkBoard;
    }

    public String[][] getPlayer1DefBoard() {
        return player1DefBoard;
    }


    /**
     * @param playerAtkBoard refers to the attack board that each player will reference for their turn.
     */
    public void setBoard(String[][] playerAtkBoard){
        for(int i = 0; i< rows; i++){
            for(int j=0; j< columns; j++){
                playerAtkBoard[i][j] = "-";

            }
        }
    }


    /**
     * Method sets the random position of three battleships on a board (2D Array). To ensure
     * that a random position is not selected twice, method checks to see if
     * an "X" was already placed on the 2D Array.
     * @param playerDefBoard refers to the players board
     */
    public void placeBattleship(String[][] playerDefBoard){
        Random random = new Random();
        int count = 0;
        while(count != 3){
            int row = random.nextInt(4);
            int column = random.nextInt(4);
            if(playerDefBoard[row][column].equals("-")){
                playerDefBoard[row][column] = "X";
                count +=1;
            }

        }


    }

}
