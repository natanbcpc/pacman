package pacman.models.player;

import pacman.models.board.Board;
import pacman.models.sprite.CollisionStrategy;
import pacman.models.sprite.Sprite;
import pacman.models.structures.Ball;

public class PlayerCollisionStrategy implements CollisionStrategy<Player> {

    public void collideBall(Player player, Ball ball) {
        player.addPoints(ball.getPoints());
    }

    @Override
    public void collide(Player player, Sprite other, Board board) {
        if (other.isBall()) {
            collideBall(player, ((Ball) other));
        }
    }
}

