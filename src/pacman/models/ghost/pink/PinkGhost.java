package pacman.models.ghost.pink;

import pacman.models.Coordinate;
import pacman.models.ghost.Ghost;
import pacman.utils.ImageLoader;

public class PinkGhost extends Ghost {
    public PinkGhost(Coordinate coord) {
        super(ImageLoader.loadPinkGhostImage(), coord, new PinkGhostMovingStrategy());
    }
}
