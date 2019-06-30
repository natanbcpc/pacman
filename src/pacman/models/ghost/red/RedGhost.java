package pacman.models.ghost.red;

import pacman.models.Coordinate;
import pacman.models.ghost.Ghost;
import pacman.models.ghost.blue.BlueGhostMovingStrategy;
import pacman.utils.ImageLoader;

public class RedGhost extends Ghost {
    public RedGhost(Coordinate coord) {
        super(ImageLoader.loadRedGhostImage(), coord, new RedGhostMovingStrategy());
    }
}
