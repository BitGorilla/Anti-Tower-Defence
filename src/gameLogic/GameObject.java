package gameLogic;

import java.awt.*;

/**
 * Represents a object to draw on a game field.
 */
public class GameObject {
    Image image;
    Position pos;

    /**
     * Construcor of class.
     *
     * @param pos Center position of the object.
     * @param image An image representation of the object
     */
    public GameObject(Position pos, Image image) {
        this.pos = pos;
        this.image = image;
    }

    /**
     *
     * @return The image representation of the object.
     */
    public Image getImage() {
        return image;
    }

    /**
     * Sets the image of the object.
     *
     * @param image An image representing the object.
     */
    public void setImage(Image image) {
        this.image = image;
    }

    /**
     *
     * @return the center position of the object.
     */
    public Position getPosition() {
        return pos;
    }

    /**
     * Sets the center position of the object.
     *
     * @param pos the center position of the object.
     */
    public void setPosition(Position pos) {
        this.pos = pos;
    }
}
