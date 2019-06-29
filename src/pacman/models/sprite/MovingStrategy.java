package pacman.models.sprite;

import pacman.models.Coordinate;
import pacman.models.board.Board;
import pacman.utils.keyboardDirection.Direction;

public abstract class MovingStrategy {
    protected abstract Coordinate move(Board board, Coordinate currentCoordinate);

    protected Coordinate coordinateForDirection(Direction direction, Coordinate currentCoordinate) {
        switch(direction) {
            case RIGHT:
                return new Coordinate(currentCoordinate.getX() + 1, currentCoordinate.getY());
            case LEFT:
                return new Coordinate(currentCoordinate.getX() - 1, currentCoordinate.getY());
            case UP:
                return new Coordinate(currentCoordinate.getX(), currentCoordinate.getY() - 1);
            case DOWN:
                return new Coordinate(currentCoordinate.getX(), currentCoordinate.getY() + 1);
            default:
                return currentCoordinate;
        }
    }
}
