import java.awt.Image;

public class Ball extends Sprite {
    private boolean special;

    public Ball(Image ballImage, boolean special) {
        super(ballImage);
        this.special = special;
    }
}
