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

    public void move(Board board) {
        this.coordinate = movingStrategy.move(board);
    }
}
