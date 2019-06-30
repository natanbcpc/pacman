package pacman.models.ghost.blue;

import pacman.models.Coordinate;
import pacman.models.ghost.Ghost;
import pacman.utils.ImageEnum;

import java.awt.*;

public class BlueGhost extends Ghost {
    public BlueGhost(Coordinate coord) {
        super(coord, new BlueGhostMovingStrategy());
    }

    @Override
    protected Image getDefaultSprite() {
        return ImageEnum.GHOST_BLUE.getImage();
    }
}
