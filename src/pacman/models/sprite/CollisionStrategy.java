package pacman.models.sprite;

import pacman.models.board.Board;

public interface CollisionStrategy<Self extends Sprite> {
    void collide(Self self, Sprite other, Board board);
}
