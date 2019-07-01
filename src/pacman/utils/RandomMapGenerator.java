package pacman.utils;

import pacman.models.Coordinate;
import pacman.models.sprite.SpriteString;

public class RandomMapGenerator {
    private static int centerX, centerY;

    public static char[][] generateRandomMap(Coordinate dimensions) {
        centerX = (dimensions.getX() - 1) / 2;
        centerY = (dimensions.getY() - 1) / 2;

        char[][] field = new char[dimensions.getX()][dimensions.getY()];

        fillDefaultParts(field, dimensions);

        return field;
    }

    private static void fillDefaultParts(char[][] field, Coordinate dimensions) {
        wallArround(field, dimensions);
        positionPacman(field);
        positionGhosts(field);
    }

    private static void wallArround(char[][] field, Coordinate dimensions) {
        int x, y;

        // Wall around the middle section
        // Blocks on the left
        for (x = 0; x < centerX - 5; x++) {
            field[x][centerY - 4] = SpriteString.BLOCK.getSymbol();
            field[x][centerY - 3] = SpriteString.EMPTY.getSymbol();
            field[x][centerY - 2] = SpriteString.BLOCK.getSymbol();
            field[x][centerY - 1] = SpriteString.EMPTY.getSymbol();
            field[x][centerY] = SpriteString.BLOCK.getSymbol();
            field[x][centerY + 1] = SpriteString.EMPTY.getSymbol();
            field[x][centerY + 2] = SpriteString.BLOCK.getSymbol();
        }
        // Blocks on the right
        for (x = centerX + 6; x < dimensions.getX(); x++) {
            field[x][centerY - 4] = SpriteString.BLOCK.getSymbol();
            field[x][centerY - 3] = SpriteString.EMPTY.getSymbol();
            field[x][centerY - 2] = SpriteString.BLOCK.getSymbol();
            field[x][centerY - 1] = SpriteString.EMPTY.getSymbol();
            field[x][centerY] = SpriteString.BLOCK.getSymbol();
            field[x][centerY + 1] = SpriteString.EMPTY.getSymbol();
            field[x][centerY + 2] = SpriteString.BLOCK.getSymbol();
        }

        field[centerX - 6][centerY - 3] = SpriteString.BLOCK.getSymbol();
        field[centerX + 6][centerY - 3] = SpriteString.BLOCK.getSymbol();
        field[centerX - 6][centerY + 1] = SpriteString.BLOCK.getSymbol();
        field[centerX + 6][centerY + 1] = SpriteString.BLOCK.getSymbol();

        // Wall around the upper section
        wallAroundSection(field, dimensions, 0, centerY - 3, 0);

        // Wall around the lower section
        wallAroundSection(field, dimensions, centerY + 2, dimensions.getY(),
                dimensions.getY() - 1);
    }

    private static void wallAroundSection(char[][] field, Coordinate dimensions, int sectionStart,
                                          int sectionEnd, int fullLinePosition) {
        int y;
        int x;
        for (y = sectionStart; y < sectionEnd; y++) {
            field[0][y] = SpriteString.EMPTY.getSymbol();
            field[dimensions.getX() - 1][y] = SpriteString.EMPTY.getSymbol();
            field[1][y] = SpriteString.BLOCK.getSymbol();
            field[dimensions.getX() - 2][y] = SpriteString.BLOCK.getSymbol();
        }
        for (x = 2; x < dimensions.getX() - 2; x++) {
            field[x][fullLinePosition] = SpriteString.BLOCK.getSymbol();
        }
    }

    private static void positionPacman(char[][] field) {
        field[centerX][3 * centerY / 2] = SpriteString.PACMAN.getSymbol();
    }

    private static void positionGhosts(char[][] field) {
        int x, y;

        for (y = centerY - 3; y <= centerY + 1; y++) {
            for (x = centerX - 3; x <= centerX + 3; x++) {
                field[x][y] = SpriteString.EMPTY.getSymbol();
            }
        }

        for (y = centerY - 2; y <= centerY; y++) {
            for (x = centerX - 2; x <= centerX + 2; x++) {
                field[x][y] = SpriteString.BLOCK.getSymbol();
            }
        }

        field[centerX][centerY - 3] = SpriteString.GHOST_RED.getSymbol();
        field[centerX][centerY - 2] = SpriteString.DOOR.getSymbol();
        field[centerX - 1][centerY - 1] = SpriteString.GHOST_BLUE.getSymbol();
        field[centerX][centerY - 1] = SpriteString.GHOST_PINK.getSymbol();
        field[centerX + 1][centerY - 1] = SpriteString.GHOST_ORANGE.getSymbol();
    }

    public static void main(String[] args) {
        int a = 21;
        char[][] f = generateRandomMap(new Coordinate(a, a));

        for (int y = 0; y < a; y++) {
            for (int x = 0; x < a; x++) {
                System.out.print(f[x][y]);
            }
            System.out.println();
        }
    }
}
