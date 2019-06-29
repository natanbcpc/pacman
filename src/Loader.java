import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Loader {
    static void initField(Coordinate dimensions, Sprite[][] field, List<Ghost> ghosts, Player player) {
        char[][] fieldMatrix = loadLevelDesign(dimensions);
        int x, y;
        for (y = 0; y < dimensions.getY(); y++) {
            for (x = 0; x < dimensions.getX(); x++) {
                field[x][y] = identifySprite(fieldMatrix, x, y);
                if (field[x][y] == null && fieldMatrix[x][y] != SpriteString.EMPTY.getSymbol()) {
                    identifySprite(ghosts, player, fieldMatrix[x][y], new Coordinate(x, y));
                }
            }
        }
    }

    private static char[][] loadLevelDesign(Coordinate dimensions) {
        char[][] fieldMatrix = new char[dimensions.getX()][dimensions.getY()];
        Scanner input;
        try {
            input = new Scanner(new File("src/resources/levels/levelDesign01.txt"));
            int line = 0;
            int col;
            while (input.hasNextLine()) {
                String oneLine = input.nextLine();
                for (col = 0; col < oneLine.length(); col++) {
                    fieldMatrix[col][line] = oneLine.charAt(col);
                }
                line++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return fieldMatrix;
    }

    private static Sprite identifySprite(char[][] field, int x, int y) {
        char cell = field[x][y];
        if (cell == SpriteString.BLOCK.getSymbol()) {
            return loadCorrectBlock(field, x, y);
        }
        if (cell == SpriteString.DOOR.getSymbol()) {
            return new Block(ImageLoader.loadDoorImage());
        }
        if (cell == SpriteString.BALL.getSymbol()) {
            return new Ball(ImageLoader.getBallImage(), false);
        }
        if (cell == SpriteString.SPECIAL_BALL.getSymbol()) {
            return new Ball(ImageLoader.getSpecialBallImage(), true);
        }
        return null;
    }

    private static void identifySprite(List<Ghost> ghosts, Player player, char cell, Coordinate coord) {
        if (cell == SpriteString.PACMAN.getSymbol()) {
            player.setX(coord.getX());
            player.setY(coord.getY());
        } else if (cell == SpriteString.GHOST_BLUE.getSymbol()) {
            ghosts.add(new BlueGhost(coord));
        } else if (cell == SpriteString.GHOST_ORANGE.getSymbol()) {
            ghosts.add(new OrangeGhost(coord));
        } else if (cell == SpriteString.GHOST_PINK.getSymbol()) {
            ghosts.add(new PinkGhost(coord));
        } else if (cell == SpriteString.GHOST_RED.getSymbol()) {
            ghosts.add(new RedGhost(coord));
        }
    }

    private static Sprite loadCorrectBlock(char[][] field, int x, int y) {
        String complement = "";
        if(y - 1 >= 0 && field[x][y - 1] == '#') {
            complement += "u";
        }
        if(y + 1 < field[0].length && field[x][y + 1] == '#') {
            complement += "d";
        }
        if(x - 1 >= 0 && field[x - 1][y] == '#') {
            complement += "l";
        }
        if(x + 1 < field.length && field[x + 1][y] == '#') {
            complement += "r";
        }

        return new Block(ImageLoader.getWallImage(complement));
    }
}
