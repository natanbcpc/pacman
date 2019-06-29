package pacman.models.board;

import pacman.models.Coordinate;
import pacman.models.ghost.Ghost;
import pacman.models.player.Player;
import pacman.models.sprite.Sprite;
import pacman.utils.keyboardDirection.KeyboardAdapter;

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

public class Board extends JPanel implements ActionListener {
    private final int DELAY = 300;
    private final int B_WIDTH = 336;
    private final int B_HEIGHT = 336;
    private final int SPRITE_SIZE = 16;

    private boolean inGame;
    private Timer timer;
    private Coordinate dimensions;

    private Player player;
    private List<Ghost> ghosts;
    private List<Sprite> staticSprites;

    private KeyboardAdapter keyboardAdapter;

    public Board(Coordinate dimensions, Player player, List<Ghost> ghosts, List<Sprite> staticSprites) {
        this.dimensions = dimensions;
        this.inGame = true;
        this.player = player;
        this.ghosts = new ArrayList<>(ghosts);
        this.staticSprites = new ArrayList<>(staticSprites);
        initLevel();
    }

    private void initLevel() {
        keyboardAdapter = new KeyboardAdapter();
        keyboardAdapter.setPlayer(this.player);
        addKeyListener(keyboardAdapter);
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

            for (Sprite sprite : staticSprites) {
                g.drawImage(sprite.getImage(), sprite.getCoordinate().getX() * SPRITE_SIZE,
                        sprite.getCoordinate().getY() * SPRITE_SIZE, this);
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
            player.move(this);

            for (Ghost g: ghosts) {
                g.move(this);
            }
        }

        repaint();
    }

    public Player getPlayer() {
        return player;
    }

    public Coordinate getDimensions() {
        return dimensions;
    }
}
