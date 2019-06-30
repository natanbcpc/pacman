package pacman.models.ball;

import pacman.models.board.Board;
import pacman.models.player.Player;
import pacman.models.sprite.CollisionStrategy;

public class BallCollisionStrategy implements CollisionStrategy<Ball> {
    @Override
    public void collide(Ball self, Player player, Board board) {
        player.addPoints(self.getPoints());
        board.removeBall(self);
    }
}
