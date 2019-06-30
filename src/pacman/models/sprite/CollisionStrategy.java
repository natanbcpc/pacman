package pacman.models.sprite;

import pacman.models.board.Board;
import pacman.models.player.Player;

public interface CollisionStrategy<Self extends Sprite> {
    void collide(Self self, Player player, Board board);
}
