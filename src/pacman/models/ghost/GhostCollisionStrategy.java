package pacman.models.ghost;

import pacman.models.board.Board;
import pacman.models.player.Player;
import pacman.models.sprite.CollisionStrategy;

public class GhostCollisionStrategy implements CollisionStrategy<Ghost> {
    @Override
    public void collide(Ghost self, Player player, Board board) {
        if (self.isScared()) {
            self.reset();
            player.eat(self);
            if (player.getLives() <= 0) {
                board.gameOver();
            } else {
                board.reset();
            }
        } else {
            player.removeLife();
        }
    }
}
