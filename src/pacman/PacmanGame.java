package pacman;

import pacman.models.board.Board;
import pacman.models.Coordinate;

import javax.swing.JFrame;

public class PacmanGame extends JFrame {
    public PacmanGame() {
        initWindow();
    }

    private void initWindow() {
        add(new Board(new Coordinate(21, 21)));

        setResizable(false);
        pack();

        setTitle("PacMan");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
