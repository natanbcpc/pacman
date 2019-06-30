package pacman.models.ghost;

import pacman.models.board.Board;
import pacman.models.player.Player;
import pacman.models.sprite.CollisionStrategy;

public class GhostCollisionStrategy implements CollisionStrategy<Ghost> {
    @Override
    public void collide(Ghost self, Player player, Board board) {
        player.removeLife();
        if (player.getLives() <= 0) {
            board.gameOver();
        } else {
            board.reset();
        }
    }
}
