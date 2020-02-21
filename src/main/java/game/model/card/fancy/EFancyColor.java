package game.model.card.fancy;

public enum EFancyColor {
    BLACK(0),
    YELLOW(2),
    ORANGE(3),
    RED(4),
    SCARLET(5),
    CRISMON(6),
    MAGENTA(7),
    PURPLE(8),
    VIOLET(9),
    BLUE(10),
    CYAN(11),
    TURQUOISE(12),
    GREEN(13),
    LEMON(14);
    
    private int color;
    
    private EFancyColor(int value) {
        this.color = value;
    }
    
    public int value() {
        return color;
    }

}
