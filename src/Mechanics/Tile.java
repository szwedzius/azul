package Mechanics;

import java.io.Serializable;

/**
 * The Colour enum determines the type of tile
 */
public enum Tile implements Serializable {
    BLACK("black.png"),
    RED("red.png"),
    WHITE("white.png"),
    YELLOW("yellow.png"),
    BLUE("blue.png"),
    FIRSTTILE("firsttile.png");

    private String imageName;

    Tile(String imageName) {
        this.imageName = imageName;
    }

    public String getImageName() {
        return imageName;
    }
}



