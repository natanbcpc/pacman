import java.util.List;

public class Board {
    private Coordinate dimensions;

    private List<Sprite> sprites;

    public Board(Coordinate dimensions) {
        this.dimensions = dimensions;
    }

	private String findSpriteStringByCoordinate(int i, int j) {
		for (Sprite sprite : this.sprites) {
			if (sprite.getCoordinate().equals(new Coordinate(i, j))) {
				return sprite.toString();
			}
		}

		return " ";
	}

    @Override
    public String toString() {
    	StringBuilder builder = new StringBuilder("");
        for (int i = 0; i < this.dimensions.getX(); i++) {
            for (int j = 0; j < this.dimensions.getY(); j++) {
                builder.append(findSpriteStringByCoordinate(i, j));
            }
            builder.append('\n');
        }

        return builder.toString();
    }
}
