package game.model.deck.impl;

import game.model.card.impl.ERank;
import game.model.card.impl.ESuit;
import game.model.card.impl.PlayingCard;
import game.model.deck.ADeck;

public class NormalDeck extends ADeck {

    public NormalDeck() {

        highestRank = ERank.ACE;
        lowestRank = ERank.TWO;

        for(ERank r : ERank.values()) {
            if(ERank.NONE.equals(r))
                continue;
            for(ESuit s : ESuit.values()) {
                if(ESuit.NONE.equals(s))
                    continue;
                cards.add(new PlayingCard(r, s));
            }
        }
    }
}
