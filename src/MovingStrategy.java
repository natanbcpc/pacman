import java.util.List;

public interface MovingStrategy {
    Coordinate move(List<Coordinate> possibleCoordinates);
}
