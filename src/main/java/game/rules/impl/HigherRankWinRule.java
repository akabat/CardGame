package game.rules.impl;

import game.model.card.IPlayingCard;
import game.model.card.impl.ESuit;
import game.model.deck.ADeck;
import game.rules.ACardComparator;

public class HigherRankWinRule extends ACardComparator {
    
    public HigherRankWinRule(ADeck deck) {
        absoluteWinningRank = deck.getHighestRank();
        absoluteWinningSuit = ESuit.CLUB;
    }

    @Override
    protected boolean firstNonJokDefeatsSecondNonJok(IPlayingCard card1, IPlayingCard card2) {
        boolean result = false;
        if( card1.getRank().compareTo( card2.getRank() ) > 0 ) {
            result = true;
        } else if( card1.getRank().compareTo( card2.getRank() ) == 0 && card1.getSuit().compareTo( card2.getSuit() ) > 0 ) {
            result = true;
        }
        return result;
    }

}
