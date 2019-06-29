import javax.swing.ImageIcon;
import java.awt.Image;

public class ImageLoader {
    private static Image ballImage;
    private static Image specialBallImage;

    private static Image loadImage(String path) {
        return new ImageIcon(path).getImage();
    }

    public static Image getWallImage(String complement) {
        if (complement.isEmpty()) {
            return loadImage("src/resources/images/walls/Wall.png");
        } else {
            return loadImage("src/resources/images/walls/Wall-" + complement + ".png");
        }
    }

    public static Image loadDoorImage() {
        return loadImage("src/resources/images/walls/Door.png");
    }

    public static Image getBallImage() {
        if (ballImage == null) {
            ballImage = loadImage("src/resources/images/itens/Ball.png");
        }
        return ballImage;
    }

    public static Image getSpecialBallImage() {
        if (specialBallImage == null) {
            specialBallImage = loadImage("src/resources/images/itens/BallSpecial.png");
        }
        return specialBallImage;
    }
}
