package game.view;

import game.controller.GameController;

/**
 * This interface enables to implement the composite design pattern: 
 *      process a group of objects the same way as it would be only one object (all sharing the same interface).
 */
public interface IView {
    
    public void setController(GameController gc);
    
    public void promptForPlayerName();
    
    public void promptForFlip();
    
    public void promptForNewGame();

    public void showPlayerName(int playerIndex, String playerName);

    public void showFaceDownCardForPlayer(int playerIndex, String playerName);

    public void showCardForPlayer(int playerIndex, String playerName, String rank, String suit);

    public void showWinner(String winnerName);
}
