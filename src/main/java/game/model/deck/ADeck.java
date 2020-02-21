package game.model.deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import game.model.card.IPlayingCard;
import game.model.card.impl.ERank;

/**
 * This abstract class enables to decline a deck to Normal, Small, Test, etc, which differ mainly by the constructor.
 * It defines the clone() method.
 */
public abstract class ADeck implements Cloneable {
    protected List<IPlayingCard> cards = new ArrayList<>();
    protected ERank highestRank;
    protected ERank lowestRank;

    public void shuffle() {
        Random random = new Random();
        for(int i=0; i<cards.size(); i++) {
            Collections.swap(cards, i, random.nextInt(cards.size()));
        }
    }
    
    public IPlayingCard removeTopCard() {
        return cards.remove(0);
    }
    
    public void returnCardToDeck(IPlayingCard pc) {
        cards.add(pc);
    }

    public ERank getHighestRank() {
        return highestRank;
    }

    public ERank getLowestRank() {
        return lowestRank;
    }
    
    @Override
    public ADeck clone() {
        ADeck deck = null;
        try {
            deck = (ADeck) super.clone();
            deck.cards = new ArrayList<>(deck.cards.size());
            for(IPlayingCard c : cards) {
                deck.cards.add(c.clone());
            }
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return deck;
    }
    
}
