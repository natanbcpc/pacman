package pacman.models.player;

import pacman.models.sprite.CollisionStrategy;
import pacman.models.sprite.Sprite;
import pacman.models.structures.Ball;

public class PlayerCollisionStrategy implements CollisionStrategy<Player> {

    public void collide(Player player, Ball ball) {
        player.addPoints(ball.getPoints());
    }

    @Override
    public void collide(Player player, Sprite other) {
        if (other.isBall()) {
            collide(player, (Ball) other);
        }
    }
}

