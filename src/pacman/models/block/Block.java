package pacman.models.block;

import pacman.models.Coordinate;
import pacman.models.sprite.Sprite;

import java.awt.*;

public class Block extends Sprite {
    private BlockTypeEnum blockType;

    public Block(Coordinate coordinate, BlockTypeEnum blockType) {
        super(coordinate, null);
        this.blockType = blockType;
    }

    public boolean isDoor() {
        return false;
    }

    @Override
    public Image getImage() {
        return blockType.getImage();
    }
}
