package pacman.models.ghost;

import pacman.models.Coordinate;
import pacman.models.sprite.MovingSprite;

import java.awt.Image;

public abstract class Ghost extends MovingSprite {
    protected boolean scared;

    public Ghost(Image sprite, Coordinate coordinate) {
        super(sprite, coordinate, null);
        scared = false;
    }

    @Override
    public Image getImage() {
        return this.defaultSprite;
//        change if scared
    }
}
