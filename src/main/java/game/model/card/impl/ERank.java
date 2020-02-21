package game.model.card.impl;

import java.util.Optional;

public enum ERank {
    NONE(0),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13),
    ACE(14);
    
    private int rank;
    
    private ERank(int value) {
        this.rank = value;
    }
    
    public int value() {
        return rank;
    }

    public static Optional<ERank> forValue(int value) {
        ERank result = null;
        for(ERank r : values()) {
            if(r.value() == value) {
                result = r;
                break;
            }
        }
        return Optional.ofNullable(result);
    }

}
