package pacman.models.sprite;

import pacman.models.Coordinate;
import pacman.models.board.Board;
import pacman.models.ghost.Ghost;
import pacman.models.player.Player;
import pacman.models.structures.Ball;

import java.awt.Image;

public abstract class Sprite {
    protected Image defaultSprite;
    protected Coordinate coordinate;
    protected CollisionStrategy collisionStrategy;

    public Sprite(Image sprite, Coordinate coordinate, CollisionStrategy collisionStrategy) {
        this.defaultSprite = sprite;
        this.coordinate = coordinate;
        this.collisionStrategy = collisionStrategy;
    }

    public Image getImage() {
        return defaultSprite;
    }

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

    public void collide(Ghost ghost, Board board) {
        if (collisionStrategy != null) {
            collisionStrategy.collide(this, ghost, board);
        }
    }

    public void collide(Ball ball, Board board) {
        if (collisionStrategy != null) {
            collisionStrategy.collide(this, ball, board);
        }
    }
}
