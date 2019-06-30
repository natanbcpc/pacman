package pacman.models.player;

import pacman.models.board.Board;
import pacman.models.ghost.Ghost;
import pacman.models.sprite.CollisionStrategy;
import pacman.models.structures.Ball;

public class PlayerCollisionStrategy implements CollisionStrategy<Player> {
    @Override
    public void collide(Player self, Player player, Board board) {

    }

    @Override
    public void collide(Player self, Ghost ghost, Board board) {

    }

    @Override
    public void collide(Player self, Ball ball, Board board) {
        self.addPoints(ball.getPoints());
        ball.collide(self, board);
    }
}

