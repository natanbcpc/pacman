package pacman.models.ghost;

import pacman.models.Coordinate;
import pacman.models.sprite.MovingSprite;
import pacman.models.sprite.MovingStrategy;
import pacman.utils.ImageEnum;

import java.awt.*;

public abstract class Ghost extends MovingSprite {
    protected static final Image SCARED_SPRITE = ImageEnum.GHOST_SCARED.getImage();
    protected boolean scared;

    public Ghost(Coordinate coordinate, MovingStrategy movingStrategy) {
        super(coordinate, movingStrategy, new GhostCollisionStrategy());
        scared = false;
    }

    protected abstract Image getDefaultSprite();

    @Override
    public Image getImage() {
        if (scared) {
            return SCARED_SPRITE;
        }

        return getDefaultSprite();
    }
}
