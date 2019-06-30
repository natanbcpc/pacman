package pacman.models.sprite;

public interface CollisionStrategy<Self extends Sprite> {
    void collide(Self self, Sprite other);
}
