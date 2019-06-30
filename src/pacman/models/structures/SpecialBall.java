package pacman.models.structures;

import pacman.models.Coordinate;

import java.awt.*;

public class SpecialBall extends Ball {
    private static final int POINTS = 10;

    public SpecialBall(Image ballImage, Coordinate coordinate) {
        super(ballImage, coordinate);
    }

    @Override
    public int getPoints() {
        return POINTS;
    }
}
