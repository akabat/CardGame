package game.model.card.fancy;

public class FancyCardFromAnotherJar {
    private EFancyShape fancyShape;
    private EFancyColor fancyColor;
    private boolean faceUp;
    
    public FancyCardFromAnotherJar(EFancyShape shape, EFancyColor color) {
        this.fancyShape = shape;
        this.fancyColor = color;
        this.faceUp = false;
    }
    
    public EFancyShape getFancyShape() {
        return fancyShape;
    }

    public EFancyColor getFancyColor() {
        return fancyColor;
    }

    public boolean isFaceUp() {
        return faceUp;
    }

    public boolean tourneOver() {
        faceUp = !faceUp;
        return faceUp;
    }
}
