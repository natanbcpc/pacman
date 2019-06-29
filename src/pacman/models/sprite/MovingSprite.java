package pacman.models.sprite;

import pacman.models.Coordinate;
import pacman.models.Movable;

import java.awt.Image;

public abstract class MovingSprite extends Sprite implements Movable {
    Coordinate coordinate;

    public MovingSprite(Image sprite, Coordinate coordinate) {
        super(sprite);
        this.coordinate = coordinate;
    }

    public int getX() {
        return coordinate.getX();
    }

    public void setX(int x) {
        coordinate.setX(x);
    }

    public int getY() {
        return coordinate.getY();
    }

    public void setY(int y) {
        coordinate.setY(y);
    }
}
