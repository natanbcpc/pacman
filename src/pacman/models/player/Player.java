package pacman.models.player;

import pacman.models.Coordinate;
import pacman.utils.ImageLoader;
import pacman.models.sprite.MovingSprite;
import pacman.utils.keyboardDirection.Direction;

import java.awt.Image;

public class Player extends MovingSprite {

    private Direction direction;
    private int points;

    public Player(Coordinate coord) {
        super(ImageLoader.loadPacmanDefaultImage(), coord, new PlayerMovingStrategy(), new PlayerCollisionStrategy());
        this.direction = null;
    }

    @Override
    public Image getImage() {
        return this.defaultSprite;
//        open and close mouth / face correct direction
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getPoints() {
        return points;
    }

    public void addPoints(int points) {
        this.points += points;
        System.out.println(this.points);
    }
}
