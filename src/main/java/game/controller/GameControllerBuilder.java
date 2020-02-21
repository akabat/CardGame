package game.controller;

import game.model.deck.ADeck;
import game.model.deck.impl.DeckFactoryBasedOnPrototyping;
import game.model.deck.impl.DeckFactoryBasedOnPrototyping.DeckType;
import game.rules.ACardComparator;
import game.rules.impl.CardComparatorFactory;
import game.rules.impl.CardComparatorFactory.CardComparatorType;
import game.view.impl.CompositeView;
import game.view.impl.ViewFactory;
import game.view.impl.ViewFactory.ViewType;

/**
 * Instead of a generic method taking parameters,
 * the builder should have several methods, which names correspond to pre-configured actions of creation of a specific card game.
 * For example : buildGameNormalDecNoJokskHigherCardWinCLI, or buildGameSmallDeckWithJoksLowerWinGUI.
 * Builder and its methods do not have to be static.
 */
public class GameControllerBuilder {
    
    private static GameController build(DeckType dType, CardComparatorType rType, ViewType vType) {
        
        ADeck deck = DeckFactoryBasedOnPrototyping.getInstance().makeDeck(dType);
        
        ACardComparator gameRule = CardComparatorFactory.makeComparator(rType, deck);
        
        CompositeView view = new CompositeView(); 
        view.addView( ViewFactory.makeView(vType) );
        
        return new GameController(view, deck, gameRule);
    }
    
    public static GameController buildGameNormalDeckWithJoksHigherCardWinCLI() {
        return build(DeckType.NORMAL_WITH_JOKERS, CardComparatorType.HIGHER_RANK_WIN, ViewType.CLI);
    }
    
    public static GameController buildGameSmallDeckNoJoksLowerCardWinGUI() {
        return build(DeckType.SMALL, CardComparatorType.LOWER_RANK_WIN, ViewType.SWING);
    }
}
