package pacman.models.ball;

import pacman.models.Coordinate;
import pacman.models.Edible;
import pacman.models.sprite.Sprite;
import pacman.utils.ImageEnum;

import java.awt.Image;
import java.util.Objects;

public class Ball extends Sprite implements Edible {
    private static final int POINTS = 1;

    public Ball(Coordinate coordinate) {
        super(coordinate, new BallCollisionStrategy());
    }

    public int getPoints() {
        return POINTS;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return coordinate.equals(ball.getCoordinate());
    }

    @Override
    public int hashCode() {

        return Objects.hash(coordinate);
    }

    @Override
    public Image getImage() {
        return ImageEnum.BALL.getImage();
    }
}
