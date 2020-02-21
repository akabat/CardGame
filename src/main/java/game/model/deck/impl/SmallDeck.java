package game.model.deck.impl;

import game.model.card.impl.ERank;
import game.model.card.impl.ESuit;
import game.model.card.impl.PlayingCard;
import game.model.deck.ADeck;

public class SmallDeck extends ADeck {

    public SmallDeck() {
        highestRank = ERank.ACE;
        lowestRank = ERank.SEVEN;

        for(ERank r : ERank.values()) {
            if( ERank.SEVEN.compareTo(r) > 0 )
                continue;
            for(ESuit s : ESuit.values()) {
                if(ESuit.NONE.equals(s))
                    continue;
                cards.add(new PlayingCard(r, s));
            }
        }
    }
}
