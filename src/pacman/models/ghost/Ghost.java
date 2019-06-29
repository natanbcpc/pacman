package pacman.models.ghost;

import pacman.models.Coordinate;
import pacman.models.ghost.blue.BlueGhostMovingStrategy;
import pacman.models.sprite.MovingSprite;
import pacman.models.sprite.MovingStrategy;

import java.awt.Image;

public abstract class Ghost extends MovingSprite {
    protected boolean scared;

    public Ghost(Image sprite, Coordinate coordinate, MovingStrategy movingStrategy) {
        super(sprite, coordinate, movingStrategy);
        scared = false;
    }

    @Override
    public Image getImage() {
        return this.defaultSprite;
//        change if scared
    }
}
