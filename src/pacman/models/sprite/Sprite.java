package pacman.models.sprite;

import pacman.models.Coordinate;
import pacman.models.board.Board;
import pacman.models.player.Player;

import java.awt.Image;

public abstract class Sprite {
    protected Coordinate coordinate;
    protected CollisionStrategy collisionStrategy;

    public Sprite(Coordinate coordinate, CollisionStrategy collisionStrategy) {
        this.coordinate = coordinate;
        this.collisionStrategy = collisionStrategy;
    }

    public abstract Image getImage();

    public Coordinate getCoordinate() {
        return coordinate;
    }

    protected void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public void collide(Player player, Board board) {
        if (collisionStrategy != null) {
            collisionStrategy.collide(this, player, board);
        }
    }
}
