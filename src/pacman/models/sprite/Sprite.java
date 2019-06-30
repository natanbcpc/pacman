package pacman.models.sprite;

import pacman.models.Coordinate;

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

    public void collide(Sprite other) {
        if (collisionStrategy != null) {
            collisionStrategy.collide(this, other);
        }
    }

    public boolean isBall() {
        return false;
    }
}
