package pacman.models.sprite;

import pacman.models.Coordinate;
import pacman.models.board.Board;

import java.awt.Image;

public abstract class MovingSprite extends Sprite {
    private Coordinate coordinate;

    private MovingStrategy movingStrategy;

    public MovingSprite(Image sprite, Coordinate coordinate, MovingStrategy movingStrategy) {
        super(sprite);
        this.coordinate = coordinate;
        this.movingStrategy = movingStrategy;
    }

    public void move(Board board) {
        this.coordinate = this.movingStrategy.move(board);
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

    public Coordinate getCoordinate() {
        return coordinate;
    }
}
