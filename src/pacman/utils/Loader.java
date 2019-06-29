package pacman.utils;

import pacman.models.Coordinate;
import pacman.models.board.Board;
import pacman.models.sprite.SpriteString;
import pacman.models.structures.Ball;
import pacman.models.structures.Block;
import pacman.models.ghost.BlueGhost;
import pacman.models.ghost.Ghost;
import pacman.models.ghost.OrangeGhost;
import pacman.models.ghost.PinkGhost;
import pacman.models.player.Player;
import pacman.models.ghost.RedGhost;
import pacman.models.sprite.Sprite;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loader {
    private static boolean isPlayer(char cell) {
        return cell == SpriteString.PACMAN.getSymbol();
    }

    private static boolean isGhost(char cell) {
        return cell == SpriteString.GHOST_BLUE.getSymbol() ||
                cell == SpriteString.GHOST_ORANGE.getSymbol() ||
                cell == SpriteString.GHOST_PINK.getSymbol() ||
                cell == SpriteString.GHOST_RED.getSymbol();
    }

    private static boolean isStaticSprite(char cell) {
        return cell == SpriteString.BALL.getSymbol() ||
                cell == SpriteString.BLOCK.getSymbol() ||
                cell == SpriteString.DOOR.getSymbol() ||
                cell == SpriteString.SPECIAL_BALL.getSymbol();
    }

    private static Ghost createGhost(char cell, Coordinate coordinate) {
        if (cell == SpriteString.GHOST_BLUE.getSymbol()) {
            return new BlueGhost(coordinate);
        }

        if (cell == SpriteString.GHOST_ORANGE.getSymbol()) {
            return new OrangeGhost(coordinate);
        }

        if (cell == SpriteString.GHOST_PINK.getSymbol()) {
            return new PinkGhost(coordinate);
        }

        if (cell == SpriteString.GHOST_RED.getSymbol()) {
            return new RedGhost(coordinate);
        }

        return null;
    }

    private static Sprite loadCorrectBlock(char[][] field, Coordinate coordinate) {
        String complement = "";
        if(coordinate.getY() - 1 >= 0 && field[coordinate.getX()][coordinate.getY() - 1] == '#') {
            complement += "u";
        }
        if(coordinate.getY() + 1 < field[0].length && field[coordinate.getX()][coordinate.getY() + 1] == '#') {
            complement += "d";
        }
        if(coordinate.getX() - 1 >= 0 && field[coordinate.getX() - 1][coordinate.getY()] == '#') {
            complement += "l";
        }
        if(coordinate.getX() + 1 < field.length && field[coordinate.getX() + 1][coordinate.getY()] == '#') {
            complement += "r";
        }

        return new Block(ImageLoader.getWallImage(complement), coordinate);
    }

    private static Sprite createStaticSprite(char[][] field, Coordinate coordinate) {
        char cell = field[coordinate.getX()][coordinate.getY()];
        if (cell == SpriteString.BLOCK.getSymbol()) {
            return loadCorrectBlock(field, coordinate);
        }
        if (cell == SpriteString.DOOR.getSymbol()) {
            return new Block(ImageLoader.loadDoorImage(), coordinate);
        }
        if (cell == SpriteString.BALL.getSymbol()) {
            return new Ball(ImageLoader.getBallImage(), coordinate, false);
        }
        if (cell == SpriteString.SPECIAL_BALL.getSymbol()) {
            return new Ball(ImageLoader.getSpecialBallImage(), coordinate, true);
        }
        return null;
    }

    private static Board createBoard(Coordinate size, char[][] fileMatrix) {
        Player player = null;
        List<Ghost> ghosts = new ArrayList<>();
        List<Sprite> staticSprites = new ArrayList<>();

        for (int i = 0; i < size.getY(); i++) {
            for (int j = 0; j < size.getX(); j++) {
                char cell = fileMatrix[i][j];

                if (isPlayer(cell)) {
                    player = new Player(new Coordinate(i, j));
                } else if (isGhost(cell)) {
                    ghosts.add(createGhost(cell, new Coordinate(i, j)));
                } else if (isStaticSprite(cell)){
                    staticSprites.add(createStaticSprite(fileMatrix, new Coordinate(i, j)));
                }
            }
        }

        return new Board(size, player, ghosts, staticSprites);
    }

    public static Component loadBoard(Coordinate size, String file) throws FileNotFoundException {
        char[][] fileMatrix = new char[size.getX()][size.getY()];
        Scanner input = new Scanner(new File(file));
        int line = 0;
        int col;
        while (input.hasNextLine()) {
            String oneLine = input.nextLine();
            for (col = 0; col < oneLine.length(); col++) {
                fileMatrix[col][line] = oneLine.charAt(col);
            }
            line++;
        }

        return createBoard(size, fileMatrix);
    }
}
