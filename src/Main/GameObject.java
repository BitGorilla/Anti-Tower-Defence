package Main;

import java.awt.*;

public class GameObject {
    Image image;
    Position pos;

    public GameObject(Position pos, Image image) {
        this.pos = pos;
        this.image = image;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Position getPosition() {
        return pos;
    }

    public void setPosition(Position pos) {
        this.pos = pos;
    }
}
