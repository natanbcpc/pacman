package pacman;

import pacman.models.Coordinate;

public enum LevelEnum {
    LEVEL_2("src/resources/levels/levelDesign02.txt", new Coordinate(21, 21), null),
    LEVEL_1("src/resources/levels/levelDesign01.txt", new Coordinate(21, 21), LEVEL_2);

    private Coordinate size;
    private String path;
    private LevelEnum nextLevel;

    LevelEnum(String path, Coordinate size, LevelEnum nextLevel) {
        this.path = path;
        this.size = size;
        this.nextLevel = nextLevel;
    }

    public Coordinate getSize() {
        return size;
    }

    public String getPath() {
        return path;
    }

    public LevelEnum getNextLevel() {
        return this.nextLevel;
    }
}
