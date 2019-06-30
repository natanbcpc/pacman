package pacman.models.board;

import pacman.models.Coordinate;
import pacman.models.ghost.Ghost;
import pacman.models.player.Player;
import pacman.models.sprite.Sprite;
import pacman.models.structures.Ball;
import pacman.models.structures.Block;
import pacman.utils.keyboardDirection.KeyboardAdapter;

import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Board extends JPanel implements ActionListener {
    private final int DELAY = 300;
    private final int B_WIDTH = 336;
    private final int B_HEIGHT = 336;
    private final int SPRITE_SIZE = 16;

    private boolean inGame;
    private boolean reset;
    private Timer timer;
    private Coordinate dimensions;

    private Player player;
    private List<Ghost> ghosts;
    private List<Block> blocks;
    private List<Ball> balls;
    private List<Ball> removeBalls;

    private KeyboardAdapter keyboardAdapter;

    public Board(Coordinate dimensions, Player player, List<Ghost> ghosts, List<Block> blocks, List<Ball> balls) {
        this.dimensions = dimensions;
        this.inGame = true;
        this.player = player;
        this.ghosts = new ArrayList<>(ghosts);
        this.blocks = new ArrayList<>(blocks);
        this.balls = new ArrayList<>(balls);
        this.removeBalls = new ArrayList<>();
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

    private void drawCenteredString(Graphics g, String text) {
        Graphics2D g2d = (Graphics2D)g.create();
        FontMetrics fm = g2d.getFontMetrics();

        int x = (getWidth() - fm.stringWidth(text)) / 2;
        int y = ((getHeight() - fm.getHeight()) / 2) + fm.getAscent();

        g.drawString(text, x, y);
    }

    private void doDrawing(Graphics g) {
        if (inGame) {
            int x, y;

            for (Block block : blocks) {
                g.drawImage(block.getImage(), block.getCoordinate().getX() * SPRITE_SIZE,
                        block.getCoordinate().getY() * SPRITE_SIZE, this);
            }

            for (Ball ball : balls) {
                g.drawImage(ball.getImage(), ball.getCoordinate().getX() * SPRITE_SIZE,
                        ball.getCoordinate().getY() * SPRITE_SIZE, this);
            }

            for (Ghost ghost : ghosts) {
                g.drawImage(ghost.getImage(),
                        ghost.getX() * SPRITE_SIZE, ghost.getY() * SPRITE_SIZE,this);
            }

            g.drawImage(player.getImage(),
                    player.getX() * SPRITE_SIZE, player.getY() * SPRITE_SIZE, this);

            Toolkit.getDefaultToolkit().sync();
        } else {
            drawCenteredString(g, "Game Over");
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (inGame) {
//            Here comes the main loop (move, check collisions, etc.)
            player.move(this);
            checkCollisions();

            for (Ghost g: ghosts) {
                g.move(this);
            }
            checkCollisions();
        }

        if (reset) {
            player.reset();
            for (Ghost ghost: ghosts) {
                ghost.reset();
            }
            reset = false;
        }

        repaint();
    }

    private void checkCollisions() {
        Coordinate playerCoordinate = player.getCoordinate();

        for (Ghost ghost : ghosts) {
            if (ghost.getCoordinate().equals(playerCoordinate)) {
                player.collide(ghost, this);
            }
        }

        for (Ball ball : balls) {
            if (ball.getCoordinate().equals(playerCoordinate)) {
                player.collide(ball, this);
            }
        }
        balls.removeAll(removeBalls);
        removeBalls.clear();
    }

    public Player getPlayer() {
        return player;
    }

    public Coordinate getDimensions() {
        return dimensions;
    }

    public void removeBall(Ball ball) {
        removeBalls.add(ball);
    }

    public void reset() {
        reset = true;
    }

    public void gameOver() {
        inGame = false;
    }
}
