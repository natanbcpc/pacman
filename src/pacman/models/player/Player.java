package pacman.models.player;

import pacman.models.Coordinate;
import pacman.utils.ImageLoader;
import pacman.models.sprite.MovingSprite;
import pacman.utils.keyboardDirection.Direction;

import java.awt.Image;

public class Player extends MovingSprite {
    private static final int POINTS_FOR_EXTRA_LIFE = 10000;
    private Direction direction;
    private int points;
    private int lives;

    public Player(Coordinate coord) {
        super(ImageLoader.loadPacmanDefaultImage(), coord, new PlayerMovingStrategy(), new PlayerCollisionStrategy());
        this.direction = null;
        this.points = 0;
        this.lives = 3;
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
        int oldPoints = this.points;

        this.points += points;

        if (oldPoints / POINTS_FOR_EXTRA_LIFE < this.points / POINTS_FOR_EXTRA_LIFE) {
            addLife();
        }

        System.out.println("Points: " + this.points);
    }

    public int getLives() {
        return lives;
    }

    public void addLife() {
        this.lives++;
        System.out.println("Lives: " + this.lives);
    }

    public void removeLife() {
        this.lives--;
        System.out.println("Lives: " + this.lives);
    }
}
