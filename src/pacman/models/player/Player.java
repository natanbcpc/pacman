package pacman.models.player;

import pacman.models.Coordinate;
import pacman.utils.ImageEnum;
import pacman.models.sprite.MovingSprite;
import pacman.utils.keyboardDirection.Direction;

import java.awt.Image;

public class Player extends MovingSprite {
    private static final int POINTS_FOR_EXTRA_LIFE = 10000;

    private static final Image DEFAULT_SPRITE = ImageEnum.PACMAN_DEFAULT.getImage();
    private static final Image LEFT_SPRITE = ImageEnum.PACMAN_LEFT.getImage();
    private static final Image RIGHT_SPRITE = ImageEnum.PACMAN_RIGHT.getImage();
    private static final Image UP_SPRITE = ImageEnum.PACMAN_UP.getImage();
    private static final Image DOWN_SPRITE = ImageEnum.PACMAN_DOWN.getImage();

    private Direction direction;
    private int points;
    private int lives;

    private boolean isMouthOpen;

    public Player(Coordinate coord) {
        super(coord, new PlayerMovingStrategy(), null);
        this.direction = null;
        this.points = 0;
        this.lives = 3;
        this.isMouthOpen = true;
    }

    @Override
    public Image getImage() {

        if(direction == null) {
            return DEFAULT_SPRITE;
        }

        // open and close mouth / face correct direction
        if (!isMouthOpen) {
            toggleMouthState();
            return DEFAULT_SPRITE;
        }

        toggleMouthState();
        switch (direction) {
            case RIGHT:
                return RIGHT_SPRITE;
            case LEFT:
                return LEFT_SPRITE;
            case UP:
                return UP_SPRITE;
            case DOWN:
                return DOWN_SPRITE;
            default:
                return DEFAULT_SPRITE;
        }
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

    private void toggleMouthState() {
        isMouthOpen = !isMouthOpen;
    }

    @Override
    public void reset(){
        super.reset();
        direction = null;
    }
}
