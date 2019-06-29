package pacman.models.ghost;

import pacman.models.Coordinate;
import pacman.utils.ImageLoader;

public class BlueGhost extends Ghost {
    public BlueGhost(Coordinate coord) {
        super(ImageLoader.loadBlueGhostImage(), coord);
    }
}
