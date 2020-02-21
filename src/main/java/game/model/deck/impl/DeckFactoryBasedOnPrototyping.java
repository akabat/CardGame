package game.model.deck.impl;

import java.util.HashMap;
import java.util.Map;

import game.model.card.IPlayingCard;
import game.model.card.impl.ERank;
import game.model.card.impl.ESuit;
import game.model.card.impl.PlayingCard;
import game.model.deck.ADeck;

/**
 * Is this implementation correct? Or we should not mix Factory and Prototype design patterns?
 */
public class DeckFactoryBasedOnPrototyping {
    
    public enum DeckType {
        NORMAL,
        SMALL,
        NORMAL_WITH_JOKERS,
        SMALL_WITH_JOKERS,
        TEST,
    }
    
    // the Decks' prototypes cache followed by joker prototype
    private Map<DeckType, ADeck> deckPrototypes;
    private IPlayingCard joker;
    
    private DeckFactoryBasedOnPrototyping() {
        deckPrototypes = new HashMap<>();
        deckPrototypes.put(DeckType.NORMAL, new NormalDeck());
        deckPrototypes.put(DeckType.SMALL, new SmallDeck());
        joker = new PlayingCard(ERank.NONE, ESuit.NONE);
    }
    
    private static DeckFactoryBasedOnPrototyping factory;
    
    public static DeckFactoryBasedOnPrototyping getInstance() {
        if(factory == null)
            factory = new DeckFactoryBasedOnPrototyping();
        return factory;
    }
    
    public ADeck makeDeck(DeckType dType) {
        
        ADeck deck = null;
        switch(dType) {
        case NORMAL:
            deck = factory.deckPrototypes.get(DeckType.NORMAL).clone();
            break;
        case SMALL:
            deck = factory.deckPrototypes.get(DeckType.SMALL).clone(); 
            break;
        case NORMAL_WITH_JOKERS:
            deck = factory.deckPrototypes.get(DeckType.NORMAL).clone(); 
            deck.returnCardToDeck( factory.joker.clone() );
            deck.returnCardToDeck( factory.joker.clone() );
            break;
        case SMALL_WITH_JOKERS:
            deck = factory.deckPrototypes.get(DeckType.SMALL).clone(); 
            deck.returnCardToDeck( factory.joker.clone() );
            deck.returnCardToDeck( factory.joker.clone() );
            break;
        case TEST:
            deck = new TestDeck(); 
            break;
        }
        
        deck.shuffle();
        return deck;
    }
    
}
