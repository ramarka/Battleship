package edu.bu.met.cs665.battleshipgame;

public class GameStateContext {

    //Class is used to handle game state changes. Each GameState implementation is instantiated within
    //the Class and Class uses the GameState to determine which state will execute the desired method.

    private Start start = new Start();
    private Player player1 = new Player();
    private Player player2 = new Player();

    private int victory1 = 0;
    private int victory2 = 0;



    private GameState currentState;


    /**
     * Default constructor. Always sets the current state of the game to start
     */
    public GameStateContext() {
        currentState = start;

    }


    /**
     * Method invokes the currentState's initialize() method (which should always be Start) and
     * then changes the state to the player1 instance of Player1 Class, effectively starting the game.
     */
    public void initialize(){
        currentState.initialize();
        System.out.println("Welcome to Battleship. Good luck to both players and have fun!!");
        setCurrentState(player1);
    }

    /**
     * Method displays the attack board of whatever state is currently active.
     */
    public void displayBoard(){
        if(currentState.equals(player1)){
            currentState.displayBoard(start.getPlayer1AtkBoard());
        }
        else {
            currentState.displayBoard(start.getPlayer2AtkBoard());
        }
    }


    /**
     * Method invokes the shoot() method of the State currently active
     */
    public void shoot(){

        if(currentState.equals(player1)){

            /*

            cheat to test run through a game quickly

            for (String[] s:start.getPlayer2DefBoard()) {

                System.out.println( Arrays.toString(s));
            }
            */


            //display to terminal
            System.out.println("\n\nPLAYER ONE IS UP, YOUR ATTACK BOARD IS DISPLAYED BELOW");

            this.displayBoard();

            //adds to player 1 victory total if the currentState shoot() method resulted in a ship being sunk otherwise
            //adds 0
            this.victory1 += currentState.shoot(start.getPlayer1AtkBoard(), start.getPlayer2DefBoard());

            //as long as victory is less than three change state to next player
            if(victory1 < 3){
                setCurrentState(player2);
            }

        }
        else{

            /*

            cheat to test run through a game quickly
            for (String[] s:start.getPlayer2DefBoard()) {

                System.out.println( Arrays.toString(s));
            }

             */

            System.out.println("\n\nPLAYER TWO IS UP, YOUR ATTACK BOARD IS DISPLAYED BELOW");
            this.displayBoard();

            this.victory2 += currentState.shoot(start.getPlayer2AtkBoard(), start.getPlayer1DefBoard());
            if(victory2 < 3) {
                setCurrentState(player1);
            }
        }

    }


    /**
     * method displays the victor when all their opponents battleships are sunk
     * @param currentState refers to the games current state
     */
    public void victory(GameState currentState){
        if(currentState.equals(player1)){
            System.out.println("\n\nCONGRATULATIONS PLAYER ONE, YOU SUNK ALL YOUR OPPONENT'S BATTLESHIPS!");
        }
        else {
            System.out.println("\n\nCONGRATULATIONS PLAYER TWO, YOU SUNK ALL YOUR OPPONENT'S BATTLESHIPS!");
        }
    }


    public int getVictory1() {
        return victory1;
    }

    public int getVictory2() {
        return victory2;
    }


    public GameState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(GameState currentState) {
        this.currentState = currentState;
    }

}
