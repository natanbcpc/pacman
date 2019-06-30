package pacman.models.ghost;

import pacman.models.Coordinate;
import pacman.models.ghost.blue.BlueGhostMovingStrategy;
import pacman.utils.ImageEnum;

import java.awt.*;

public class RedGhost extends Ghost {
    public RedGhost(Coordinate coord) {
        super(coord, new BlueGhostMovingStrategy());
    }

    @Override
    protected Image getDefaultSprite() {
        return ImageEnum.GHOST_RED.getImage();
    }
}
