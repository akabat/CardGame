package game;

import game.controller.GameController;
import game.controller.GameControllerBuilder;

/**
 * This dev exercise was inspired by the openclassroom training 
 *      "Use MVC, SOLID Principles, and Design Patterns in Java" 
 *      by Glen Wolfram.
 * 
 * @author Andrzej KABAT
 */
public class CardGame {
    
    public static void main( String[] args ) {
//        GameController gc = GameControllerBuilder.buildGameNormalDeckWithJoksHigherCardWinCLI();
        GameController gc = GameControllerBuilder.buildGameSmallDeckNoJoksLowerCardWinGUI();
        gc.run();
    }
}
