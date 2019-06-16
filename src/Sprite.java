import java.util.List;

public abstract class Sprite {
    private Coordinate coordinate;

    private MovingStrategy movingStrategy;

    public Sprite(Coordinate coordinate, MovingStrategy movingStrategy) {
        this.coordinate = coordinate;
        this.movingStrategy = movingStrategy;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void move(List<Coordinate> possibleCoordinates) {
        this.coordinate = movingStrategy.move(possibleCoordinates);
    }

    public abstract boolean isWall();
}
