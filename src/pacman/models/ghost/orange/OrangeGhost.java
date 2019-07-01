package pacman.models.ghost.orange;

import pacman.models.Coordinate;
import pacman.models.ghost.Ghost;
import pacman.models.ghost.GhostType;
import pacman.models.ghost.blue.BlueGhostMovingStrategy;
import pacman.utils.ImageEnum;

import java.awt.*;

public class OrangeGhost extends Ghost {
    public OrangeGhost(Coordinate coord) {
        super(coord, new OrangeGhostMovingStrategy());
    }

    @Override
    protected Image getDefaultSprite() {
        return ImageEnum.GHOST_ORANGE.getImage();
    }

    @Override
    public GhostType getGhostType() {
        return GhostType.ORANGE;
    }
}

