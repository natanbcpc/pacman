package pacman.models.ghost.pink;

import pacman.models.Coordinate;
import pacman.models.board.Board;
import pacman.models.sprite.MovingStrategy;

import java.util.concurrent.ThreadLocalRandom;

public class PinkGhostMovingStrategy extends MovingStrategy {

    @Override
    public Coordinate move(Board board, Coordinate currentCoordinate) {
        int randomY = board.getDimensions().getY();
        int randomX = board.getDimensions().getX();

        boolean isPositionInvalid = true;

        while (isPositionInvalid) {
            //Gerando posicoes randomicas dentro do mapa
            randomY = ThreadLocalRandom.current().nextInt(0, board.getDimensions().getY() + 1);
            randomX = ThreadLocalRandom.current().nextInt(0, board.getDimensions().getX() + 1);

            isPositionInvalid = false;
        }

        return new Coordinate(randomX, randomY);
    }
}
