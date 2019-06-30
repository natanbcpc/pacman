package pacman.models.structures;

import pacman.models.Coordinate;
import pacman.models.sprite.Sprite;

import java.awt.Image;

public class Block extends Sprite {

    private boolean isDoor;

    public Block(Image sprite, Coordinate coordinate, boolean isDoor) {
        super(sprite, coordinate, null);
        this.isDoor = isDoor;
    }

    public boolean isDoor() {
        return isDoor;
    }
}
