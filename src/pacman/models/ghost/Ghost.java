package pacman.models.ghost;

import pacman.models.Coordinate;
import pacman.models.Edible;
import pacman.models.sprite.MovingSprite;
import pacman.models.sprite.MovingStrategy;
import pacman.utils.ImageEnum;

import java.awt.*;

public abstract class Ghost extends MovingSprite implements Edible {
    protected static final Image SCARED_SPRITE = ImageEnum.GHOST_SCARED.getImage();
    private static final int POINTS = 100;

    private boolean scared;

    public Ghost(Coordinate coordinate, MovingStrategy movingStrategy) {
        super(coordinate, movingStrategy, new GhostCollisionStrategy());
        scared = false;
    }

    @Override
    public void reset() {
        super.reset();
        this.scared = false;
    }

    protected abstract Image getDefaultSprite();

    @Override
    public Image getImage() {
        if (scared) {
            return SCARED_SPRITE;
        }

        return getDefaultSprite();
    }

    public boolean isScared() {
        return scared;
    }

    public void setScared(boolean scared) {
        this.scared = scared;
    }

    public int getPoints() {
        return POINTS;
    }
}
