package pacman.models.ghost.blue;

import pacman.models.Coordinate;
import pacman.models.ghost.Ghost;
import pacman.utils.ImageLoader;

public class BlueGhost extends Ghost {
    public BlueGhost(Coordinate coord) {
        super(ImageLoader.loadBlueGhostImage(), coord, new BlueGhostMovingStrategy());
    }
}
