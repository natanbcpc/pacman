package pacman.utils.keyboardDirection;

import pacman.models.player.Player;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardAdapter extends KeyAdapter {

    private Player player;

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_LEFT:
                player.setDirection(Direction.LEFT);
                break;
            case KeyEvent.VK_RIGHT:
                player.setDirection(Direction.RIGHT);
                break;
            case KeyEvent.VK_UP:
                player.setDirection(Direction.UP);
                break;
            case KeyEvent.VK_DOWN:
                player.setDirection(Direction.DOWN);
                break;
        }
    }
}
