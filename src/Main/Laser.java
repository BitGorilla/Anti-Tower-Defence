package Main;

import java.awt.*;

public class Laser {

    private Position lineStart;
    private Position lineEnd;
    private int lifeTime;
    private Color color;

    public Laser(Position lineStart, Position lineEnd, Color color) {
        this.lineStart = lineStart;
        this.lineEnd = lineEnd;
        this.color = color;
        lifeTime = 10;
    }

    public Position getLineStart() {
        return lineStart;
    }

    public Position getLineEnd() {
        return lineEnd;
    }

    public int getLifeTime() {
        return lifeTime;
    }

    public void reduceLifeTime() {
        lifeTime--;
    }

    public Color getColor() {
        return color;
    }
}
