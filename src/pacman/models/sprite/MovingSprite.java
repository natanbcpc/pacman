package pacman.models.sprite;

import pacman.models.Coordinate;
import pacman.models.board.Board;

import java.awt.Image;

public abstract class MovingSprite extends Sprite {
    private MovingStrategy movingStrategy;
    private Coordinate initialPosition;

    public MovingSprite(Image sprite, Coordinate coordinate, MovingStrategy movingStrategy, CollisionStrategy collisionStrategy) {
        super(sprite, coordinate, collisionStrategy);
        this.movingStrategy = movingStrategy;
        this.initialPosition = coordinate;
    }

    public void move(Board board) {
        coordinate = this.movingStrategy.move(board, coordinate);
    }

    public void reset() {
        super.coordinate = initialPosition;
    }

    public int getX() {
        return coordinate.getX();
    }

    public int getY() {
        return coordinate.getY();
    }
}
