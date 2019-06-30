package pacman.models.structures;

import pacman.models.Coordinate;
import pacman.models.sprite.Sprite;

import java.awt.Image;
import java.util.Objects;

public class Ball extends Sprite {
    private boolean special;

    public Ball(Image ballImage, Coordinate coordinate, boolean special) {
        super(ballImage, coordinate, new BallCollisionStrategy());
        this.special = special;
    }

    public int getPoints() {
        if (special) {
            return 10;
        }

        return 1;
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
}
