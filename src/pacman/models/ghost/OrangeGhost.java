package pacman.models.ghost;

import pacman.models.Coordinate;
import pacman.utils.ImageLoader;

public class OrangeGhost extends Ghost {
    public OrangeGhost(Coordinate coord) {
        super(ImageLoader.loadOrangeGhostImage(), coord, null);
    }
}

