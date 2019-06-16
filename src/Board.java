import java.util.List;

public class Board {
    private Coordinate dimensions;

    private List<Sprite> sprites;

    public Board(Coordinate dimensions) {
        this.dimensions = dimensions;
    }

    @Override
    public String toString() {
        String board[][] = new String[this.dimensions.getX()][this.dimensions.getY()];
        for (int i = 0; i < this.dimensions.getX(); i++) {
            for (int j = 0; j < this.dimensions.getY(); j++) {
                board[i][j] = " ";
            }
        }

        for (Sprite sprite : this.sprites) {
            board[sprite.getCoordinate().getX()][sprite.getCoordinate().getY()] = sprite.toString();
        }

        return null;
    }
}
