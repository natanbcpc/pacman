package pacman.utils;

import javax.swing.*;
import java.awt.*;

public enum ImageEnum {
    PACMAN_DEFAULT("src/resources/images/pacman/Pacman-o.png"),
    PACMAN_RIGHT("src/resources/images/pacman/Pacman-r.png"),
    PACMAN_LEFT("src/resources/images/pacman/Pacman-l.png"),
    PACMAN_UP("src/resources/images/pacman/Pacman-u.png"),
    PACMAN_DOWN("src/resources/images/pacman/Pacman-d.png"),
    GHOST_SCARED("src/resources/images/ghosts/GhostScared.png"),
    GHOST_PINK("src/resources/images/ghosts/GhostPink.png"),
    GHOST_RED("src/resources/images/ghosts/GhostRed.png"),
    GHOST_BLUE("src/resources/images/ghosts/GhostBlue.png"),
    GHOST_ORANGE("src/resources/images/ghosts/GhostOrange.png"),
    BALL("src/resources/images/itens/Ball.png"),
    SPECIAL_BALL("src/resources/images/itens/BallSpecial.png"),
    DOOR("src/resources/images/walls/Door.png"),
    WALL("src/resources/images/walls/Wall.png"),
    WALL_U("src/resources/images/walls/Wall-u.png"),
    WALL_D("src/resources/images/walls/Wall-d.png"),
    WALL_L("src/resources/images/walls/Wall-l.png"),
    WALL_R("src/resources/images/walls/Wall-r.png"),
    WALL_UD("src/resources/images/walls/Wall-ud.png"),
    WALL_UL("src/resources/images/walls/Wall-ul.png"),
    WALL_UR("src/resources/images/walls/Wall-ur.png"),
    WALL_DL("src/resources/images/walls/Wall-dl.png"),
    WALL_DR("src/resources/images/walls/Wall-dr.png"),
    WALL_LR("src/resources/images/walls/Wall-lr.png"),
    WALL_UDL("src/resources/images/walls/Wall-udl.png"),
    WALL_UDR("src/resources/images/walls/Wall-udr.png"),
    WALL_ULR("src/resources/images/walls/Wall-ulr.png"),
    WALL_DLR("src/resources/images/walls/Wall-dlr.png"),
    WALL_UDLR("src/resources/images/walls/Wall-udlr.png");

    private Image image;

    ImageEnum(String path) {
        this.image = new ImageIcon(path).getImage();
    }

    public Image getImage() {
        return image;
    }
}
