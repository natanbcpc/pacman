package pacman.models.ghost.pink;

import pacman.models.Coordinate;
import pacman.models.board.Board;
import pacman.models.sprite.MovingStrategy;

import java.util.concurrent.ThreadLocalRandom;

public class PinkGhostMovingStrategy extends MovingStrategy {

    @Override
    public Coordinate move(Board board, Coordinate currentCoordinate) {
        Coordinate newCoordinate = generateRandomCoordinate(board);
        boolean isPositionInvalid = ! board.hasDoorOrFreePathOnCoordinate(newCoordinate);

        while (isPositionInvalid) {
            //Gerando posicoes randomicas dentro do mapa
            newCoordinate = generateRandomCoordinate(board);
            isPositionInvalid = ! board.hasDoorOrFreePathOnCoordinate(newCoordinate);
        }

        return newCoordinate;
    }

    private Coordinate generateRandomCoordinate(Board board) {
        int randomY = ThreadLocalRandom.current().nextInt(0, board.getDimensions().getY() + 1);
        int randomX = ThreadLocalRandom.current().nextInt(0, board.getDimensions().getX() + 1);

        return new Coordinate(randomX, randomY);
    }
}
