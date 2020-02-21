package game.model.card.impl;

import game.model.card.IPlayingCard;

public class PlayingCard implements IPlayingCard {
    private final ERank rank;
    private final ESuit suit;
    private boolean faceUp;
    
    public PlayingCard(ERank rank, ESuit suit) {
        this.rank = rank;
        this.suit = suit;
        this.faceUp = false;
    }
    
    @Override
    public ERank getRank() {
        return rank;
    }

    @Override
    public ESuit getSuit() {
        return suit;
    }

    @Override
    public boolean isFaceUp() {
        return faceUp;
    }

    @Override
    public boolean flip() {
        faceUp = !faceUp;
        return faceUp;
    }
    
    @Override
    public IPlayingCard clone() {
        IPlayingCard clonedCard = null;
        try {
            clonedCard = (IPlayingCard) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clonedCard;
    }
}
