package pacman.models.sprite;

import pacman.models.Coordinate;
import pacman.models.board.Board;

public interface MovingStrategy {
    Coordinate move(Board board);
}
