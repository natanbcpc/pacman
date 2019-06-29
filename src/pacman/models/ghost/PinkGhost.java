package pacman.models.ghost;

import pacman.models.Coordinate;
import pacman.utils.ImageLoader;

public class PinkGhost extends Ghost {
    public PinkGhost(Coordinate coord) {
        super(ImageLoader.loadPinkGhostImage(), coord);
    }
}
