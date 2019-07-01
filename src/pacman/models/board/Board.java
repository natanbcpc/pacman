package pacman.models.board;

import pacman.models.Coordinate;
import pacman.models.ghost.Ghost;
import pacman.models.player.Player;
import pacman.models.ball.Ball;
import pacman.models.block.Block;
import pacman.utils.ImageEnum;
import pacman.utils.keyboardDirection.KeyboardAdapter;

import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Board extends JPanel implements ActionListener {
    private static final int DELAY = 200;
    private static final int B_WIDTH = 336;
    private static final int B_HEIGHT = 368;
    private static final int SPRITE_SIZE = 16;
    private static final int POWER_UP_ROUNDS = 60;

    private boolean inGame;
    private boolean reset;
    private int powerUpRounds;
    private Timer timer;
    private Coordinate dimensions;

    private Player player;
    private List<Ghost> ghosts;
    private List<Block> blocks;
    private List<Ball> balls;
    private List<Ball> removeBalls;

    private KeyboardAdapter keyboardAdapter;
    private String endGameMessage;

    public Board(Coordinate dimensions, Player player, List<Ghost> ghosts, List<Block> blocks, List<Ball> balls) {
        this.dimensions = dimensions;
        this.inGame = true;
        this.reset = false;
        this.powerUpRounds = 0;
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
        FontMetrics fm = g.getFontMetrics();

        int x = (getWidth() - fm.stringWidth(text)) / 2;
        int y = ((getHeight() - fm.getHeight()) / 2) + fm.getAscent();

        g.setColor(Color.WHITE);
        g.drawString(text, x, y);
    }

    private void drawLives(Graphics g) {
        g.drawImage(ImageEnum.PACMAN_RIGHT.getImage(), SPRITE_SIZE, (int) (B_HEIGHT - 1.5 * SPRITE_SIZE), this);
        g.setColor(Color.WHITE);
        g.drawString(Integer.toString(player.getLives()), 2 * SPRITE_SIZE, (int) (B_HEIGHT - 0.75 * SPRITE_SIZE));
    }

    private void drawPoints(Graphics g) {
        FontMetrics fm = g.getFontMetrics();
        String text = Integer.toString(player.getPoints());

        int x = B_WIDTH - (fm.stringWidth(text) + SPRITE_SIZE);
        int y = (int) (B_HEIGHT - 0.75 * SPRITE_SIZE);
        g.drawString(text,x,y);
    }

    private void doDrawing(Graphics g) {
        if (inGame) {
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
            drawCenteredString(g, endGameMessage);
        }
        drawLives(g);
        drawPoints(g);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        //The game starts when the player moves
        boolean gameStarted = player.getDirection() != null;

        if (inGame && gameStarted) {
            //Here comes the main loop (move, check collisions, etc.)

            for (Ghost ghost : ghosts) {
                if (powerUpRounds > 0) {
                    powerUpRounds--;
                } else {
                    ghost.setScared(false);
                }
            }

            player.move(this);
            checkCollisions();

            for (Ghost g: ghosts) {
                g.move(this);
            }
            checkCollisions();

            if (balls.isEmpty()) {
                playerWin();
            }
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
                ghost.collide(player, this);
            }
        }

        for (Ball ball : balls) {
            if (ball.getCoordinate().equals(playerCoordinate)) {
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

    public boolean hasDoorOrFreePathOnCoordinate(Coordinate coordinate) {
        for (Block b: blocks) {
            if(b.getCoordinate().equals(coordinate)) {
                return b.isDoor();
            }
        }

        return true;
    }

    public Player getPlayer() {
        return player;
    }

    public List<Ghost> getGhosts() {
        return ghosts;
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
        endGameMessage = "Game Over";
    }

    public void playerWin() {
        inGame = false;
        endGameMessage = "You Win!";
    }

    public void powerUp() {
        this.powerUpRounds = POWER_UP_ROUNDS;
        for (Ghost ghost : ghosts) {
            ghost.setScared(true);
        }
    }
}
