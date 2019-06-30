package pacman.models.ghost.red;

import pacman.models.Coordinate;
import pacman.models.board.Board;
import pacman.models.sprite.MovingStrategy;

import java.util.ArrayList;
import java.util.Comparator;

public class RedGhostMovingStrategy extends MovingStrategy {

    @Override
    protected Coordinate move(Board board, Coordinate currentCoordinate) {
        Coordinate playerCoordinate = board.getPlayer().getCoordinate();

        int currentX = currentCoordinate.getX();
        int currentY = currentCoordinate.getY();

        Coordinate leftCoordinate = new Coordinate(currentX - 1, currentY);
        Coordinate rightCoordinate = new Coordinate(currentX + 1, currentY);
        Coordinate upCoordinate = new Coordinate(currentX, currentY + 1);
        Coordinate downCoordinate = new Coordinate(currentX, currentY - 1);

        int leftDistance = distance(leftCoordinate, playerCoordinate);
        int rightDistance = distance(rightCoordinate, playerCoordinate);
        int upDistance = distance(upCoordinate, playerCoordinate);
        int downDistance = distance(downCoordinate, playerCoordinate);

        ArrayList<Integer> values = new ArrayList<>();
        if(!board.hasWallOnCoordinate(leftCoordinate)) {
            values.add(leftDistance);
        }

        if(!board.hasWallOnCoordinate(rightCoordinate)) {
            values.add(rightDistance);
        }

        if(!board.hasWallOnCoordinate(upCoordinate)) {
            values.add(upDistance);
        }

        if(!board.hasWallOnCoordinate(downCoordinate)) {
            values.add(downDistance);
        }

        int minValue = values.stream().min(Comparator.naturalOrder()).orElse(0);

        if(minValue == leftDistance && !board.hasWallOnCoordinate(leftCoordinate)) {
            return leftCoordinate;
        } else if(minValue == rightDistance && !board.hasWallOnCoordinate(rightCoordinate)) {
            return rightCoordinate;
        } else if(minValue == upDistance && !board.hasWallOnCoordinate(upCoordinate)) {
            return upCoordinate;
        } else if(minValue == downDistance && !board.hasWallOnCoordinate(downCoordinate)){
            return downCoordinate;
        }

        return currentCoordinate;
    }
}
