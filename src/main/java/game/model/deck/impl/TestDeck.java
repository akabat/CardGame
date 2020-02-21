package game.model.deck.impl;

import game.model.card.impl.ERank;
import game.model.card.impl.ESuit;
import game.model.card.impl.PlayingCard;
import game.model.deck.ADeck;

public class TestDeck extends ADeck {
    public TestDeck() {
        highestRank = ERank.ACE;
        lowestRank = ERank.ACE;

        for(int i=0; i<20; i++) {
            cards.add(new PlayingCard(ERank.ACE, ESuit.CLUB));
        }
    }
}
