package pacman.models.player;

import pacman.models.Coordinate;
import pacman.utils.ImageLoader;
import pacman.models.sprite.MovingSprite;
import pacman.utils.keyboardDirection.Direction;

import java.awt.Image;

public class Player extends MovingSprite {

    private Direction direction;

    public Player(Coordinate coord) {
        super(ImageLoader.loadPacmanDefaultImage(), coord, new PlayerMovingStrategy());
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
}
