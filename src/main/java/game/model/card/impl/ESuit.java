package game.model.card.impl;

import java.util.Optional;

public enum ESuit {
    NONE(0),
    DIAMOND(1),
    HEART(2),
    SPADE(3),
    CLUB(4);

    private int suit;
    
    private ESuit(int suit) {
        this.suit = suit;
    }
    
    public int value() {
        return suit;
    }

    public static Optional<ESuit> forValue(int value) {
        ESuit result = null;
        for(ESuit s : ESuit.values()) {
            if(s.value() == value) {
                result = s;
                break;
            }
        }
        return Optional.ofNullable(result);
    }

}
