package pacman.models.ghost.orange;

import pacman.models.Coordinate;
import pacman.models.board.Board;
import pacman.models.ghost.Ghost;
import pacman.models.ghost.GhostType;
import pacman.models.sprite.MovingStrategy;
import pacman.utils.keyboardDirection.Direction;

import java.util.*;

public class OrangeGhostMovingStrategy extends MovingStrategy {

    @Override
    protected Coordinate move(Board board, Coordinate currentCoordinate) {

        ArrayList<Coordinate> ghostsCoordinates = new ArrayList<>();

        for(Ghost g: board.getGhosts()) {
            if(g.getGhostType() != GhostType.ORANGE) {
                ghostsCoordinates.add(g.getCoordinate());
            }
        }

        int currentX = currentCoordinate.getX();
        int currentY = currentCoordinate.getY();

        Coordinate leftCoordinate = new Coordinate(currentX - 1, currentY);
        Coordinate rightCoordinate = new Coordinate(currentX + 1, currentY);
        Coordinate upCoordinate = new Coordinate(currentX, currentY + 1);
        Coordinate downCoordinate = new Coordinate(currentX, currentY - 1);

        //Adding distances
        Map<Direction, Integer> values = new HashMap<>();

        if(!board.hasWallOnCoordinate(leftCoordinate)) {
            int distance = distanceAvarage(leftCoordinate, ghostsCoordinates);
            values.put(Direction.LEFT, distance);
        }

        if(!board.hasWallOnCoordinate(rightCoordinate)) {
            int distance = distanceAvarage(rightCoordinate, ghostsCoordinates);
            values.put(Direction.RIGHT, distance);
        }

        if(!board.hasWallOnCoordinate(upCoordinate)) {
            int distance = distanceAvarage(upCoordinate, ghostsCoordinates);
            values.put(Direction.UP, distance);
        }

        if(!board.hasWallOnCoordinate(downCoordinate)) {
            int distance = distanceAvarage(downCoordinate, ghostsCoordinates);
            values.put(Direction.DOWN, distance);
        }

        Optional<Map.Entry<Direction, Integer>> maxValue = values.entrySet().stream()
                .max(Comparator.comparingInt(Map.Entry::getValue));

        if(maxValue.isPresent()) {
            Direction direction = maxValue.get().getKey();
            return coordinateForDirection(direction, currentCoordinate);
        }

        return currentCoordinate;
    }

    private int distanceAvarage(Coordinate currentCoordinate, ArrayList<Coordinate> ghostsCoordinates) {
        int distance = (distance(currentCoordinate, ghostsCoordinates.get(0)) +
                distance(currentCoordinate, ghostsCoordinates.get(1)) +
                distance(currentCoordinate, ghostsCoordinates.get(2))) / 3;
        return distance;
    }
}
