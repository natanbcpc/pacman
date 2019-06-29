package pacman.models.ghost;

import pacman.models.Coordinate;
import pacman.models.ghost.blue.BlueGhostMovingStrategy;
import pacman.utils.ImageLoader;

public class RedGhost extends Ghost {
    public RedGhost(Coordinate coord) {
        super(ImageLoader.loadRedGhostImage(), coord, new BlueGhostMovingStrategy());
    }
}
