package game.controller;

import java.util.ArrayList;
import java.util.List;

import game.model.card.IPlayingCard;
import game.model.deck.ADeck;
import game.model.player.IPlayer;
import game.model.player.impl.Player;
import game.model.player.impl.WinnerPlayerDecorator;
import game.rules.ACardComparator;
import game.view.IView;

/**
 * This class is a high level rules implementation of a "One Card Game". It is not supposed to be modified.
 * Unless a new game with other general rules have to be implemented.
 */
public class GameController {

    // Model
    private ADeck deck;
    private ACardComparator cardComparator;
    private List<IPlayer> players;
    private IPlayer winner;

    // View
    private IView view;

    private GameState state;

    private enum GameState {
        AddingPlayers,
        CardsDealt,
        WinnerRevealed
    } 

    public GameController(IView view, ADeck deck, ACardComparator cardComparingRule) {
        this.view = view;
        view.setController(this);
        this.deck = deck;
        this.cardComparator = cardComparingRule;

        players = new ArrayList<>();
        state = GameState.AddingPlayers;
    }

    //---------------------------------------------------------------------

    /**
     * The run method together with the state variable enables to implement the State design pattern.
     * In the training, in the run method, there was an infinite loop. It worked well with the the CLI, but "loudly" with Swing GUI.  
     * For that reason, instead, I chose to call the run method after each state update.
     */
    public void run() {
        //        while(true) {
        switch(state) {
        case AddingPlayers:
            view.promptForPlayerName(); break;
        case CardsDealt:
            view.promptForFlip(); break;
        case WinnerRevealed:
            view.promptForNewGame(); break;
        }
        //        }
    }

    private void updateState() {
        switch(state) {
        case AddingPlayers:
            state = GameState.CardsDealt; break;
        case CardsDealt: 
            state = GameState.WinnerRevealed; break;
        case WinnerRevealed:
            state = GameState.CardsDealt; break;
        }
        run();
    }    

    //---------------------------------------------------------------------

    public void addPlayer(String playerName) {
        if(GameState.AddingPlayers.equals(state)) {
            players.add(new Player(playerName));
            view.showPlayerName(players.size(), playerName);
        }
        run();
    }

    public void startGame() {
        if(!GameState.CardsDealt.equals(state)) {
            deck.shuffle();
            int playerIndex = 1;
            for(IPlayer p : players) {
                p.addCardToHand(deck.removeTopCard());
                view.showFaceDownCardForPlayer(playerIndex++, p.getName());
            }

            updateState();
            //            state = GameState.CardsDealt;
        }
    }

    public void flipCards() {
        int playerIndex = 1;
        for(IPlayer p : players) {
            IPlayingCard pc = p.getCard(0);
            pc.flip();
            view.showCardForPlayer(playerIndex++, p.getName(), pc.getRank().toString(), pc.getSuit().toString());
        }

        evaluateWinner();
        displaywinner();
        rebuildDeck();

        updateState();
        //        state = GameState.WinnerRevealed;
    }

    //---------------------------------------------------------------------

    public void evaluateWinner() {
        IPlayer currentlyBestPlayer = null;
        for(IPlayer p : players) {
            if(currentlyBestPlayer == null) {
                currentlyBestPlayer = p;
            } else if( cardComparator.firstDefeatsSecond(p.getCard(0), currentlyBestPlayer.getCard(0)) ) {
                currentlyBestPlayer = p; 
            }
        }
        winner = new WinnerPlayerDecorator(currentlyBestPlayer);
    }

    public void displaywinner() {
        view.showWinner(winner.getName());
    }

    public void rebuildDeck() {
        for(IPlayer p : players) {
            deck.returnCardToDeck(p.removeCard());
        }
    }

}
