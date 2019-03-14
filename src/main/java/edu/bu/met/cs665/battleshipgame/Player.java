package edu.bu.met.cs665.battleshipgame;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Player implements GameState {


    /**
     * @param board is the player's attackBoard
     * method displays the current attack board including misses and ships sunk
     */
    @Override
    public void displayBoard(String [][] board) {
        System.out.println("  0  1  2  3  4");
        int columnCount = 0;
        for (String[] s:board) {

            System.out.println(columnCount + Arrays.toString(s));
            columnCount +=1;
        }


    }


    /**
     *
     * @param playerBoard refers to the players attack board
     * @param opponentBoard refers to hidden opponents board
     * @return 1 if attack was successful and 0 if not
     */
    @Override
    public Integer shoot(String[][] playerBoard, String[][] opponentBoard) {
        int indexBound = opponentBoard.length - 1;
        int row;
        int column;

        do {

            Scanner input = new Scanner(System.in);
            System.out.println("Please enter the row you wish to attack");
            try{
                int check = input.nextInt();

                if(check <= indexBound && check >= 0){
                    row = check;
                    break;
                }else {
                    System.out.println(" ERROR: Invalid input please enter a number from 0 to " + indexBound);
                }

            }catch (InputMismatchException e){
                System.out.println("ERROR: Invalid input please enter a number only");
            }

        }while (true);

        do {
            System.out.println("Great now enter the column");
            Scanner input = new Scanner(System.in);
            try{
                int check = input.nextInt();

                if(check <= indexBound && check >= 0){
                    column = check;
                    break;
                }else {
                    System.out.println("ERROR: Invalid input please enter a number from 0 to " + indexBound);
                }

            }catch (InputMismatchException e){
                System.out.println(" ERROR: Invalid input please enter a number only");
            }

        }while (true);


        if(opponentBoard[row][column].equals("X")){
            System.out.println("DIRECT HIT!!! BATTLESHIP SUNK!");
            playerBoard[row][column] = "X";
            return 1;
        }else{
            System.out.println("MISS");
            playerBoard[row][column] = "*";
            return 0;
        }

    }

    @Override
    public void initialize() {
        System.out.println("Game already in progress.");

    }


}
