import java.awt.Image;

public abstract class Sprite {
    private Image defaultSprite;

    public Sprite(Image sprite) {
        this.defaultSprite = sprite;
    }

    public Image getImage() {
        return defaultSprite;
    }
}
