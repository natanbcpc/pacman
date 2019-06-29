package pacman.models.ghost.blue;

import pacman.models.Coordinate;
import pacman.models.board.Board;
import pacman.models.sprite.MovingStrategy;
import pacman.utils.keyboardDirection.Direction;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class BlueGhostMovingStrategy extends MovingStrategy  {

    @Override
    public Coordinate move(Board board, Coordinate currentCoordinate) {
        int randomIndex = ThreadLocalRandom.current().nextInt(0, Direction.values().length);
        Direction randomDirection = Direction.values()[randomIndex];

        return coordinateForDirection(randomDirection, currentCoordinate);
    }
}
