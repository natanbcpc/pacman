import java.awt.Image;

public abstract class Ghost extends MovingSprite {
    protected boolean scared;

    public Ghost(Image sprite, Coordinate coordinate) {
        super(sprite, coordinate);
        scared = false;
    }

    @Override
    public Image getImage() {
        return this.defaultSprite;
//        change if scared
    }

    @Override
    public void move(Sprite[][] field) {

    }
}