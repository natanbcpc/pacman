package pacman.models.ball.special;

import pacman.models.ball.BallCollisionStrategy;
import pacman.models.board.Board;
import pacman.models.player.Player;
import pacman.models.sprite.CollisionStrategy;

public class SpecialBallCollisionStrategy implements CollisionStrategy<SpecialBall> {
    private BallCollisionStrategy ballCollisionStrategy;

    public SpecialBallCollisionStrategy() {
        this.ballCollisionStrategy = new BallCollisionStrategy();
    }

    @Override
    public void collide(SpecialBall self, Player player, Board board) {
        ballCollisionStrategy.collide(self, player, board);
        board.powerUp();
    }
}
