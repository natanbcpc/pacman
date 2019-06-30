package pacman.models.player;

import pacman.models.Coordinate;
import pacman.models.board.Board;
import pacman.models.sprite.MovingStrategy;
import pacman.utils.keyboardDirection.Direction;

public class PlayerMovingStrategy extends MovingStrategy {

    public Coordinate move(Board board, Coordinate currentCoordinate) {
        Player player = board.getPlayer();
        Direction direction = player.getDirection();

        if (direction == null) {
            return player.getCoordinate();
        }

        Coordinate newCoordinate = coordinateForDirection(direction, currentCoordinate);
        if (board.hasWallOnCoordinate(newCoordinate)) {
            return player.getCoordinate();
        }

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
