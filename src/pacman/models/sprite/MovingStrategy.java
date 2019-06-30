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

    protected Coordinate treatIfShortcut(Coordinate newCoordinate, Board board) {
        //Checking if the player is out from right path
        if (newCoordinate.getX() < 0) {
            return new Coordinate(board.getDimensions().getX(), newCoordinate.getY());
        }

        //Checking if the player is out from left path
        if (newCoordinate.getX() > board.getDimensions().getX()) {
            return new Coordinate(0, newCoordinate.getY());
        }

        return newCoordinate;
    }
}
