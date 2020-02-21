package game.model.player.impl;

import game.model.card.IPlayingCard;
import game.model.player.IPlayer;

public class Player implements IPlayer {
    private String name;
    private Hand hand;
    
    public Player(String name) {
        this.name = name;
        this.hand = new Hand();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addCardToHand(IPlayingCard pc) {
        hand.addCard(pc);
    }
    
    @Override
    public IPlayingCard getCard(int index) {
        return hand.getCard(index);
    }
    
    @Override
    public IPlayingCard removeCard() {
        return hand.removeCard();
    }
}
