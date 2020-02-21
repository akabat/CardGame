package game.view.impl;

import java.util.Scanner;

import game.controller.GameController;
import game.view.IView;

public class CommandLineView implements IView {
    
    private GameController gameController;
    private Scanner keyboard = new Scanner(System.in);
    
    public void setController(GameController gc) {
        this.gameController = gc;
    }
    
    public void promptForPlayerName() {
        System.out.print("Player name: ");
        String name = keyboard.nextLine();
        if(name.isEmpty()) {
            gameController.startGame();
        } else {
            gameController.addPlayer(name);
        }
    }
    
    public void promptForFlip() {
        System.out.println("Press Enter to reveal cards...");
        keyboard.nextLine();
        gameController.flipCards();
    }
    
    public void promptForNewGame() {
        System.out.println("Press Enter to deal again...");
        keyboard.nextLine();
        gameController.startGame();
    }

    public void showPlayerName(int playerIndex, String playerName) {
        System.out.format("[%1$d][%2$s]%n", playerIndex, playerName);
    }

    public void showFaceDownCardForPlayer(int playerIndex, String playerName) {
        System.out.format("[%1$s][ : ]%n", playerName);
    }

    public void showCardForPlayer(int playerIndex, String playerName, String rank, String suit) {
        System.out.format("[%1$s][%2$s : %3$s]%n", playerName, rank, suit);
    }

    public void showWinner(String winnerName) {
        System.out.format("And the winner is: %s!%n", winnerName);
    }
}
