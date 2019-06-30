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
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
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
//            gameOver(g);
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

        repaint();
    }

    private void checkCollisions() {
        Coordinate playerCoordinate = player.getCoordinate();

        for (Ghost ghost : ghosts) {
            if (ghost.getCoordinate().equals(playerCoordinate)) {
                player.collide(ghost, this);
                ghost.collide(player, this);
            }
        }

        for (Ball ball : balls) {
            if (ball.getCoordinate().equals(playerCoordinate)) {
                player.collide(ball, this);
                ball.collide(player, this);
            }
        }
        balls.removeAll(removeBalls);
        removeBalls.clear();
    }

    public boolean hasWallOnCoordinate(Coordinate coordinate) {
        for (Block b: blocks) {
            if(b.getCoordinate().equals(coordinate)) {
                return true;
            }
        }

        return false;
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
}
