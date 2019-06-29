package pacman.models.sprite;

import java.awt.Image;

public abstract class Sprite {
    protected Image defaultSprite;

    public Sprite(Image sprite) {
        this.defaultSprite = sprite;
    }

    public Image getImage() {
        return defaultSprite;
    }
}
