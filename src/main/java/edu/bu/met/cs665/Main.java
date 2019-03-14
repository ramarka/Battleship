package edu.bu.met.cs665;

import edu.bu.met.cs665.battleshipgame.GameStateContext;

public class Main {

  /**
   * A main method to run examples. 
   * @param args not used 
   */
  public static void main(String[] args) {

    GameStateContext context = new GameStateContext();

    //initializes the start of the game
    context.initialize();

    //runs continually until victory condition is met
    do {
      context.shoot();
      if(context.getVictory1() == 3 || context.getVictory2() == 3){
        break;
      }

    }while (true);

    context.victory(context.getCurrentState());










  }

}
