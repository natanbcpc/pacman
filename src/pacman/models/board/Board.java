package pacman.models.board;

import pacman.models.Coordinate;
import pacman.models.ghost.Ghost;
import pacman.models.player.Player;
import pacman.models.sprite.Sprite;
import pacman.utils.KeyboardAdapter;
import pacman.utils.Loader;

import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Board  extends JPanel implements ActionListener {
    private final int DELAY = 300;
    private final int B_WIDTH = 336;
    private final int B_HEIGHT = 336;
    private final int SPRITE_SIZE = 16;

    private boolean inGame;
    private Timer timer;
    private Coordinate dimensions;

    private List<Ghost> ghosts;
    private Player player;
    private Sprite[][] field;

    public Board(Coordinate dimensions) {
        this.dimensions = dimensions;
        this.inGame = true;
        field = new Sprite[dimensions.getX()][dimensions.getY()];
        ghosts = new ArrayList<>();
        player = new Player(new Coordinate(0, 0));
        Loader.initField(dimensions, field, ghosts, player);
        initLevel();
    }

    private void initLevel() {
        KeyboardAdapter k = new KeyboardAdapter();
        k.setLevel(this);
        addKeyListener(k);
        setBackground(Color.black);
        setFocusable(true);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

        initGame();
    }

    private void initGame() {
        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
    }

    private void doDrawing(Graphics g) {
        if (inGame) {
            int x, y;

            for (x = 0; x < dimensions.getX(); x++) {
                for (y = 0; y < dimensions.getY(); y++) {
                    if (field[x][y] != null) {
                        g.drawImage(field[x][y].getImage(), SPRITE_SIZE * x, SPRITE_SIZE * y, this);
                    }
                }
            }

            for (Ghost ghost : ghosts) {
                g.drawImage(ghost.getImage(),
                        ghost.getX() * SPRITE_SIZE, ghost.getY() * SPRITE_SIZE,this);
            }

            g.drawImage(player.getImage(),
                    player.getX() * SPRITE_SIZE, player.getY() * SPRITE_SIZE, this);

            Toolkit.getDefaultToolkit().sync();
        } else {
//            gameOver(g);
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (inGame) {
//            Here comes the main loop (move, check collisions, etc.)
        }

        repaint();
    }
}
