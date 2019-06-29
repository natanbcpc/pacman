package pacman.models.sprite;

import pacman.models.Coordinate;

import java.awt.Image;

public abstract class Sprite {

    protected Image defaultSprite;
    protected Coordinate coordinate;

    public Sprite(Image sprite, Coordinate coordinate) {
        this.defaultSprite = sprite;
        this.coordinate = coordinate;
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
}
