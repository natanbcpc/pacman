package pacman.models.structures;

import pacman.models.Coordinate;
import pacman.models.sprite.Sprite;

import java.awt.Image;

public class Ball extends Sprite {
    private boolean special;

    public Ball(Image ballImage, Coordinate coordinate, boolean special) {
        super(ballImage, coordinate);
        this.special = special;
    }
}
