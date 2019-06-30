package pacman.models.ghost;

import pacman.models.Coordinate;
import pacman.models.ghost.blue.BlueGhostMovingStrategy;
import pacman.utils.ImageEnum;

import java.awt.*;

public class OrangeGhost extends Ghost {
    public OrangeGhost(Coordinate coord) {
        super(coord, new BlueGhostMovingStrategy());
    }

    @Override
    protected Image getDefaultSprite() {
        return ImageEnum.GHOST_ORANGE.getImage();
    }
}

