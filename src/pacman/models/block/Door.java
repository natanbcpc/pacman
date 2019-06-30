package pacman.models.block;

import pacman.models.Coordinate;

public class Door extends Block {
    public Door(Coordinate coordinate) {
        super(coordinate, BlockTypeEnum.DOOR);
    }

    @Override
    public boolean isDoor() {
        return true;
    }
}
