package Creatures;

import Main.Direction;
import Main.Position;
import Tiles.EntryTeleporterTile;
import Tiles.ExitTeleporterTile;
import Tiles.Tile;
import formatters.ImageLoader;

import java.awt.*;

/**
 * Created by jontor on 2018-12-10.
 */
public class PortalusTotalus extends Creature {
    public static final int MAXHEALTH = 300;
    public static final int SPEED = 2;
    public static final int COST = 150;
    public static final int teleportDistance = 250;

    public static final Image image = ImageLoader.getImageLoader().getImage(
            "portalusTotalus.png");

    private EntryTeleporterTile entryTeleporterTile;
    private ExitTeleporterTile exitTeleporterTile;
    int teleportCountDown = teleportDistance;

    public PortalusTotalus(Position pos, Direction dir) {
        super(pos, image, dir, 0, MAXHEALTH, COST);
        setCurrentHealth(MAXHEALTH);
    }

    public Tile createEntryTeleporterTile(){
        if(entryTeleporterTile == null) {
            setImage(ImageLoader.getImageLoader().getImage("portalusTotalus2" +
                    ".png"));
            Position teleportPosition = new Position(getPosition().getX(), getPosition().getY());
            entryTeleporterTile = new EntryTeleporterTile(getDirection(), teleportPosition);
        }
        return entryTeleporterTile;
    }

    public EntryTeleporterTile getEntryTeleporterTile() {
        return entryTeleporterTile;
    }

    @Override
    public void move() {
        getPosition().addVector(getDirection().asVector());
        getHealthbar().setPosition(getPosition());
        if(entryTeleporterTile != null){
            teleportCountDown--;
        }
    }

    public int getTeleportCountDown() {
        return teleportCountDown;
    }

    public Tile createExitTeleporterTile(){
        Position exitPos = new Position(getPosition().getX(), getPosition().getY());
        entryTeleporterTile.setPortalLocation(exitPos);
        exitTeleporterTile = new ExitTeleporterTile(getDirection(),exitPos);
        setCurrentHealth(0);
        return exitTeleporterTile;
    }

}
