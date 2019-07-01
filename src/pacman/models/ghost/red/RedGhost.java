package pacman.models.ghost.red;

import pacman.models.Coordinate;
import pacman.models.ghost.Ghost;
import pacman.models.ghost.GhostType;
import pacman.models.ghost.red.RedGhostMovingStrategy;
import pacman.utils.ImageEnum;

import java.awt.*;

public class RedGhost extends Ghost {
    public RedGhost(Coordinate coord) {
        super(coord, new RedGhostMovingStrategy());
    }

    @Override
    protected Image getDefaultSprite() {
        return ImageEnum.GHOST_RED.getImage();
    }

    @Override
    public GhostType getGhostType() {
        return GhostType.RED;
    }
}
