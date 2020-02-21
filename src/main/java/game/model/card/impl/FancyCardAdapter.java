package game.model.card.impl;

import game.model.card.IPlayingCard;
import game.model.card.fancy.FancyCardFromAnotherJar;

/**
 * The adapter of the FancyCard class.
 */
public class FancyCardAdapter implements IPlayingCard {
    
    private FancyCardFromAnotherJar fancyCard;
    
    public FancyCardAdapter(FancyCardFromAnotherJar card) {
        this.fancyCard = card;
    }

    @Override
    public ERank getRank() {
        return ERank.forValue( fancyCard.getFancyColor().value() ).orElse(ERank.NONE);
    }

    @Override
    public ESuit getSuit() {
        return ESuit.forValue( fancyCard.getFancyShape().value() ).orElse(ESuit.NONE);
    }

    @Override
    public boolean isFaceUp() {
        return fancyCard.isFaceUp();
    }

    @Override
    public boolean flip() {
        return fancyCard.tourneOver();
    }
    
    @Override
    public IPlayingCard clone() {
        return new FancyCardAdapter(new FancyCardFromAnotherJar(fancyCard.getFancyShape(), fancyCard.getFancyColor()));
    }
}
