package game.view.impl;

import java.util.ArrayList;
import java.util.List;

import game.controller.GameController;
import game.view.IView;

/**
 * The composite View enables to IO information from a group of views simultaneously.
 */
public class CompositeView implements IView {
    
    List<IView> views;
    
    public CompositeView() {
        views = new ArrayList<>();
    }
    
    public void addView(IView view) {
        views.add(view);
    }

    @Override
    public void setController(GameController gc) {
        for(IView v : views) {
            v.setController(gc);
        }
    }

    @Override
    public void promptForPlayerName() {
        for(IView v : views) {
            v.promptForPlayerName();
        }
    }

    @Override
    public void promptForFlip() {
        for(IView v : views) {
            v.promptForFlip();
        }
    }

    @Override
    public void promptForNewGame() {
        for(IView v : views) {
            v.promptForNewGame();
        }
    }

    @Override
    public void showPlayerName(int playerIndex, String playerName) {
        for(IView v : views) {
            v.showPlayerName(playerIndex, playerName);
        }
    }

    @Override
    public void showFaceDownCardForPlayer(int playerIndex, String playerName) {
        for(IView v : views) {
            v.showFaceDownCardForPlayer(playerIndex, playerName);
        }
    }

    @Override
    public void showCardForPlayer(int playerIndex, String playerName, String rank, String suit) {
        for(IView v : views) {
            v.showCardForPlayer(playerIndex, playerName, rank, suit);
        }
    }

    @Override
    public void showWinner(String winnerName) {
        for(IView v : views) {
            v.showWinner(winnerName);
        }
    }
}