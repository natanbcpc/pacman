package pacman.models.structures;

import pacman.models.board.Board;
import pacman.models.ghost.Ghost;
import pacman.models.player.Player;
import pacman.models.sprite.CollisionStrategy;

public class BallCollisionStrategy implements CollisionStrategy<Ball> {

    @Override
    public void collide(Ball ball, Player player, Board board) {
        board.removeBall(ball);
    }

    @Override
    public void collide(Ball ball, Ghost ghost, Board board) {

    }

    @Override
    public void collide(Ball ball, Ball ball2, Board board) {

    }
}
