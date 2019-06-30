package pacman.models.sprite;

import pacman.models.Coordinate;
import pacman.models.board.Board;

import java.awt.Image;

public abstract class Sprite {
    protected Image defaultSprite;
    protected Coordinate coordinate;
    protected CollisionStrategy collisionStrategy;

    public Sprite(Image sprite, Coordinate coordinate, CollisionStrategy collisionStrategy) {
        this.defaultSprite = sprite;
        this.coordinate = coordinate;
        this.collisionStrategy = collisionStrategy;
    }

    public Image getImage() {
        return defaultSprite;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    protected void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public void collide(Sprite other, Board board) {
        if (collisionStrategy != null) {
            collisionStrategy.collide(this, other, board);
        }
    }

    public boolean isBall() {
        return false;
    }

    public boolean isPlayer() {
        return false;
    }
}
