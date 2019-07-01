package pacman.utils.loader;

import pacman.models.Coordinate;
import pacman.models.block.BlockTypeEnum;
import pacman.models.block.Door;
import pacman.models.board.Board;
import pacman.models.ghost.red.RedGhost;
import pacman.models.sprite.SpriteString;
import pacman.models.ball.Ball;
import pacman.models.block.Block;
import pacman.models.ghost.blue.BlueGhost;
import pacman.models.ghost.Ghost;
import pacman.models.ghost.orange.OrangeGhost;
import pacman.models.ghost.pink.PinkGhost;
import pacman.models.player.Player;
import pacman.models.ball.special.SpecialBall;

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

    private static boolean isBlock(char cell) {
        return cell == SpriteString.BLOCK.getSymbol() ||
                cell == SpriteString.DOOR.getSymbol();
    }

    private static boolean isBall(char cell) {
        return cell == SpriteString.BALL.getSymbol() ||
                cell == SpriteString.SPECIAL_BALL.getSymbol();
    }

    private static boolean isEmptySpace(char cell) {
        return cell == SpriteString.EMPTY.getSymbol();
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

    private static Block loadCorrectBlock(char[][] field, Coordinate coordinate) {
        String complement = "WALL";
        if(coordinate.getY() - 1 >= 0 && field[coordinate.getX()][coordinate.getY() - 1] == '#') {
            complement += "U";
        }
        if(coordinate.getY() + 1 < field[0].length && field[coordinate.getX()][coordinate.getY() + 1] == '#') {
            complement += "D";
        }
        if(coordinate.getX() - 1 >= 0 && field[coordinate.getX() - 1][coordinate.getY()] == '#') {
            complement += "L";
        }
        if(coordinate.getX() + 1 < field.length && field[coordinate.getX() + 1][coordinate.getY()] == '#') {
            complement += "R";
        }

        return new Block(coordinate, BlockTypeEnum.valueOf(complement));
    }


    private static Block createBlock(char[][] field, Coordinate coordinate) {
        char cell = field[coordinate.getX()][coordinate.getY()];

        if (cell == SpriteString.BLOCK.getSymbol()) {
            return loadCorrectBlock(field, coordinate);
        }

        if (cell == SpriteString.DOOR.getSymbol()) {
            return new Door(coordinate);
        }

        return null;
    }

    private static Ball createBall(char cell, Coordinate coordinate) {
        if (cell == SpriteString.BALL.getSymbol()) {
            return new Ball(coordinate);
        }

        if (cell == SpriteString.SPECIAL_BALL.getSymbol()) {
            return new SpecialBall(coordinate);
        }

        return null;
    }

    private static Board createBoard(Coordinate size, char[][] fileMatrix) throws InvalidBoardException {
        Player player = null;
        List<Ghost> ghosts = new ArrayList<>();
        List<Block> blocks = new ArrayList<>();
        List<Ball> balls = new ArrayList<>();

        for (int i = 0; i < size.getY(); i++) {
            for (int j = 0; j < size.getX(); j++) {
                char cell = fileMatrix[i][j];

                if (isPlayer(cell)) {
                    player = new Player(new Coordinate(i, j));
                } else if (isGhost(cell)) {
                    ghosts.add(createGhost(cell, new Coordinate(i, j)));
                } else if (isBlock(cell)){
                    blocks.add(createBlock(fileMatrix, new Coordinate(i, j)));
                } else if (isBall(cell)) {
                    balls.add(createBall(cell, new Coordinate(i, j)));
                } else if (!isEmptySpace(cell)) {
                    throw new InvalidBoardException(String.format("Character '%c' is invalid", cell));
                }
            }
        }

        if (player == null || ghosts.isEmpty()) {
            throw new InvalidBoardException("Board must have at least one player and one ghost");
        }

        if (balls.isEmpty()) {
            throw new InvalidBoardException("Board must have at least one ball");
        }

        return new Board(size, player, ghosts, blocks, balls);

    }

    public static Component loadBoard(Coordinate size, String file) throws FileNotFoundException, InvalidBoardException {
        char[][] fileMatrix = new char[size.getX()][size.getY()];
        Scanner input = new Scanner(new File(file));
        int line = 0;
        int col;
        while (input.hasNextLine()) {
            if (line >= size.getY()) {
                throw new InvalidBoardException(String.format("File is bigger than maxSize (%dx%d)", size.getX(), size.getY()));
            }

            String oneLine = input.nextLine();
            for (col = 0; col < oneLine.length(); col++) {
                if (col >= size.getX()) {
                    throw new InvalidBoardException(String.format("File is bigger than maxSize (%dx%d)", size.getX(), size.getY()));
                }

                fileMatrix[col][line] = oneLine.charAt(col);
            }
            line++;
        }

        return createBoard(size, fileMatrix);
    }
}
