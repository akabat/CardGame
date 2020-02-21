package game.model.player.impl;

import game.model.card.IPlayingCard;
import game.model.player.IPlayer;

/**
 * Decorator improving the display of the winner's name.
 */
public class WinnerPlayerDecorator implements IPlayer {
    private IPlayer winner;
    
    public WinnerPlayerDecorator(IPlayer player) {
        this.winner = player;
    }
    
    
    @Override
    public String getName() {
        return String.format("*** %s ***", winner.getName());
    }

    @Override
    public void addCardToHand(IPlayingCard pc) {
        winner.addCardToHand(pc);
    }

    @Override
    public IPlayingCard getCard(int index) {
        return winner.getCard(index);
    }

    @Override
    public IPlayingCard removeCard() {
        return winner.removeCard();
    }
}
