import javax.swing.JFrame;
import java.awt.EventQueue;

public class Main {
    public static void main(String args[]) {
        EventQueue.invokeLater(() -> {
            JFrame pacmanGame = new PacmanGame();
            pacmanGame.setVisible(true);
        });
    }
}
