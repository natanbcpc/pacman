package pacman.models.sprite;

import pacman.models.Coordinate;
import pacman.models.board.Board;

import java.awt.Image;

public abstract class MovingSprite extends Sprite {

    private MovingStrategy movingStrategy;

    public MovingSprite(Image sprite, Coordinate coordinate, MovingStrategy movingStrategy) {
        super(sprite, coordinate);
        this.movingStrategy = movingStrategy;
    }

    public void move(Board board) {
        coordinate = this.movingStrategy.move(board);
    }

    public int getX() {
        return coordinate.getX();
    }

    public int getY() {
        return coordinate.getY();
    }
}
