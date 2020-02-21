package game.rules.impl;

import game.model.deck.ADeck;
import game.rules.ACardComparator;

public class CardComparatorFactory {
    
    public enum CardComparatorType {
        HIGHER_RANK_WIN,
        LOWER_RANK_WIN
    }
    
    public static ACardComparator makeComparator(CardComparatorType eType, ADeck deck) {
        ACardComparator comparingRule = null;
        switch(eType) {
        case HIGHER_RANK_WIN:
            comparingRule = new HigherRankWinRule(deck);
            break;
        case LOWER_RANK_WIN:
            comparingRule = new LowerRankWinRule(deck); 
            break;
        }
        
        return comparingRule;
    }
}
