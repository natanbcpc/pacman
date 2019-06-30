package pacman;

import pacman.models.Coordinate;
import pacman.utils.loader.InvalidBoardException;
import pacman.utils.loader.Loader;

import javax.swing.JFrame;
import java.io.FileNotFoundException;

public class PacmanGame extends JFrame {
    public PacmanGame() {
        initWindow();
    }

    private void initWindow() {
        try {
            add(Loader.loadBoard(new Coordinate(21, 21), "src/resources/levels/levelDesign01.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (InvalidBoardException e) {
            e.printStackTrace();
        }

        setResizable(false);
        pack();

        setTitle("PacMan");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
