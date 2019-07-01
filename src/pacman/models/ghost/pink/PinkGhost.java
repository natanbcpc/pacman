package pacman.models.ghost.pink;

import pacman.models.Coordinate;
import pacman.models.ghost.Ghost;
import pacman.models.ghost.GhostType;
import pacman.utils.ImageEnum;

import java.awt.*;

public class PinkGhost extends Ghost {
    public PinkGhost(Coordinate coord) {
        super(coord, new PinkGhostMovingStrategy());
    }

    @Override
    protected Image getDefaultSprite() {
        return ImageEnum.GHOST_PINK.getImage();
    }

    @Override
    public GhostType getGhostType() {
        return GhostType.PINK;
    }
}
