package pacman.models.ball.special;

import pacman.models.Coordinate;
import pacman.models.ball.Ball;
import pacman.utils.ImageEnum;

import java.awt.*;

public class SpecialBall extends Ball {
    private static final int POINTS = 10;

    public SpecialBall(Coordinate coordinate) {
        super(coordinate);
        this.collisionStrategy = new SpecialBallCollisionStrategy();
    }

    @Override
    public int getPoints() {
        return POINTS;
    }

    @Override
    public Image getImage() {
        return ImageEnum.SPECIAL_BALL.getImage();
    }
}
