package pacman.models.structures;

import pacman.models.board.Board;
import pacman.models.sprite.CollisionStrategy;
import pacman.models.sprite.Sprite;

public class BallCollisionStrategy implements CollisionStrategy<Ball> {

    public void collidePlayer(Ball ball, Board board) {
        board.removeBall(ball);
    }

    @Override
    public void collide(Ball ball, Sprite other, Board board) {
        if (other.isPlayer()) {
            collidePlayer(ball, board);
        }
    }
}
