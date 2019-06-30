package pacman.models.block;

import pacman.utils.ImageEnum;

import java.awt.*;

public enum BlockTypeEnum {
    DOOR(ImageEnum.DOOR),
    WALL(ImageEnum.WALL),
    WALLU(ImageEnum.WALL_U),
    WALLD(ImageEnum.WALL_D),
    WALLL(ImageEnum.WALL_L),
    WALLR(ImageEnum.WALL_R),
    WALLUD(ImageEnum.WALL_UD),
    WALLUL(ImageEnum.WALL_UL),
    WALLUR(ImageEnum.WALL_UR),
    WALLDL(ImageEnum.WALL_DL),
    WALLDR(ImageEnum.WALL_DR),
    WALLLR(ImageEnum.WALL_LR),
    WALLUDL(ImageEnum.WALL_UDL),
    WALLUDR(ImageEnum.WALL_UDR),
    WALLULR(ImageEnum.WALL_ULR),
    WALLDLR(ImageEnum.WALL_DLR),
    WALLUDLR(ImageEnum.WALL_UDLR);

    private ImageEnum imageEnum;

    BlockTypeEnum(ImageEnum imageEnum) {
        this.imageEnum = imageEnum;
    }

    public Image getImage() {
        return imageEnum.getImage();
    }
}
