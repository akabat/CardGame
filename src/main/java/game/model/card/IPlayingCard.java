package game.model.card;

import game.model.card.impl.ERank;
import game.model.card.impl.ESuit;

/**
 * This abstract class aims to enable the implementation of an adapter for the FancyCard class.
 */
public interface IPlayingCard extends Cloneable {
    
    public ERank getRank();
    
    public ESuit getSuit();

    public boolean isFaceUp();
    
    public boolean flip();
    
    public IPlayingCard clone();
}
