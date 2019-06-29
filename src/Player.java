import java.awt.Image;

public class Player extends MovingSprite {
    public Player(Coordinate coord) {
        super(ImageLoader.loadPacmanDefaultImage(), coord);
    }

    @Override
    public Image getImage() {
        return this.defaultSprite;
//        open and close mouth / face correct direction
    }

    @Override
    public void move(Sprite[][] field) {
    }
}
