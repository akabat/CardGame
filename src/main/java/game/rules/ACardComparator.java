package game.rules;

import game.model.card.IPlayingCard;
import game.model.card.impl.ERank;
import game.model.card.impl.ESuit;

/**
 * This abstract class enables to implement the Strategy design pattern, or simply to use polymorphism, based on chosen rules: higher or lower rank win.
 */
public abstract class ACardComparator {
    
    protected ERank absoluteWinningRank;
    protected ESuit absoluteWinningSuit;
    
    protected abstract boolean firstNonJokDefeatsSecondNonJok(IPlayingCard card1, IPlayingCard card2);
    
    public boolean firstDefeatsSecond(IPlayingCard card1, IPlayingCard card2) {
        boolean result = false;
        
        boolean isCard1Jocker = ERank.NONE.equals(card1.getRank());
        boolean isCard2Jocker = ERank.NONE.equals(card2.getRank());

        if(isCard1Jocker || isCard2Jocker ) {
            if(isCard1Jocker && isCard2Jocker ) {
                result = true;
            } else if(isCard1Jocker) {
                if( !absoluteWinningRank.equals(card2.getRank()) || !absoluteWinningSuit.equals(card2.getSuit()) ) {
                    result = true;
                }
            } else {
                if( absoluteWinningRank.equals(card1.getRank()) && absoluteWinningSuit.equals(card1.getSuit()) ) {
                    result = true;
                }
            }
        } else {
            result = firstNonJokDefeatsSecondNonJok(card1, card2);
        }
        
        return result;
    }
}
