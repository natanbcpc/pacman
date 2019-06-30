package pacman.models.structures;

import pacman.models.Coordinate;
import pacman.models.sprite.Sprite;

import java.awt.Image;

public class Block extends Sprite {
    public Block(Image sprite, Coordinate coordinate) {
        super(sprite, coordinate, null);
    }
}
