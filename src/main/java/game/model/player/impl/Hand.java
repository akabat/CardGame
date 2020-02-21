package game.model.player.impl;

import java.util.ArrayList;
import java.util.List;

import game.model.card.IPlayingCard;

public class Hand {
    List<IPlayingCard> cards;

    public Hand() {
        cards = new ArrayList<>();
    }
    
    public void addCard(IPlayingCard pc)  {
        cards.add(pc);
    }
    
    public IPlayingCard getCard(int index) {
        return cards.get(index);
    }
    
    public IPlayingCard removeCard() {
        return cards.remove(0);
    }
    
}
