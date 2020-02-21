package game.model.card.fancy;

public enum EFancyShape {
    CIRCLE(0),
    TRIANGLE(1),
    RECTANGLE(2),
    PENTAGON(3),
    HEXAGON(4);

    private int shape;
    
    private EFancyShape(int suit) {
        this.shape = suit;
    }
    
    public int value() {
        return shape;
    }
}
