package pacman.models.sprite;

import pacman.models.board.Board;
import pacman.models.ghost.Ghost;
import pacman.models.player.Player;
import pacman.models.structures.Ball;

public interface CollisionStrategy<Self extends Sprite> {
    void collide(Self self, Player player, Board board);
    void collide(Self self, Ghost ghost, Board board);
    void collide(Self self, Ball ball, Board board);
}
