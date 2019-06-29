import java.awt.Image;

public abstract class MovingSprite extends Sprite implements Movable {
    public MovingSprite(Image sprite, Coordinate coordinate) {
        super(sprite);
    }
}
