package pacman.models.player;

import pacman.models.Coordinate;
import pacman.utils.ImageLoader;
import pacman.models.sprite.MovingSprite;
import pacman.models.sprite.Sprite;

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
