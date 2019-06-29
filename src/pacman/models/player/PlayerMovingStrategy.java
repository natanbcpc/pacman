package pacman.models.player;

import pacman.models.Coordinate;
import pacman.models.board.Board;
import pacman.models.sprite.MovingStrategy;
import pacman.utils.keyboardDirection.Direction;

public class PlayerMovingStrategy implements MovingStrategy {

    @Override
    public Coordinate move(Board board) {
        Player player = board.getPlayer();
        Direction direction = player.getDirection();

        if (direction == null) {
            return player.getCoordinate();
        }

        switch(direction) {
            case RIGHT:
                return new Coordinate(player.getX() + 1, player.getY());
            case LEFT:
                return new Coordinate(player.getX() - 1, player.getY());
            case UP:
                return new Coordinate(player.getX(), player.getY() - 1);
            case DOWN:
                return new Coordinate(player.getX(), player.getY() + 1);
            default:
                return player.getCoordinate();
        }
    }
}
