package creatures;

import gameLogic.Direction;
import gameLogic.Position;
import tiles.EntryTeleporterTile;
import tiles.ExitTeleporterTile;
import tiles.Tile;
import formatters.ImageLoader;

import java.awt.*;

/**
 * Portalus Totalus is a type of creature that extends the class Creature.
 * This creature can place portals on the tiles in the game field so that
 * other creatures can move through the portals.
 * @author io16jsn, io16ohl
 * @since 2018-12-10
 */
public class PortalusTotalus extends Creature {
    public static final int MAXHEALTH = 600;
    public static final int SPEED = 3;
    public static final int COST = 150;
    public static final int teleportDistance = 250;

    public static final Image image = ImageLoader.getImageLoader().getImage(
            "portalusTotalus.png");

    private EntryTeleporterTile entryTeleporterTile;
    private ExitTeleporterTile exitTeleporterTile;
    int teleportCountDown = teleportDistance;

    /**
     * Constructor
     * @param pos
     * @param dir
     */
    public PortalusTotalus(Position pos, Direction dir) {
        super(pos, image, dir, 0, MAXHEALTH, COST);
        setCurrentHealth(MAXHEALTH);
    }

    /**
     * Creates a new entry teleporter tile
     * @return tile that is changed to teleporter tile.
     */
    public Tile createEntryTeleporterTile(){
        if(entryTeleporterTile == null) {
            setImage(ImageLoader.getImageLoader().getImage("portalusTotalus2" +
                    ".png"));
            Position teleportPosition = new Position(getPosition().getX(),
                    getPosition().getY());
            entryTeleporterTile = new EntryTeleporterTile(getDirection(),
                    teleportPosition);
        }
        return entryTeleporterTile;
    }

    /**
     * Get the entry teleporter tile that was created
     * @return teleporter tile
     */
    public EntryTeleporterTile getEntryTeleporterTile() {
        return entryTeleporterTile;
    }

    /**
     * Creates a count down when a entry teleporter tile is created
     */
    @Override
    public void move() {
        getPosition().addVector(getDirection().asVector());
        getHealthbar().setPosition(getPosition());
        if(entryTeleporterTile != null){
            teleportCountDown--;
        }
    }

    /**
     * Get the teleporter count down
     * @return int
     */
    public int getTeleportCountDown() {
        return teleportCountDown;
    }

    /**
     * Creates a exit teleporter tile after the count down is finished
     * @return exit teleporter tile
     */
    public Tile createExitTeleporterTile(){
        Position exitPos = new Position(getPosition().getX(), getPosition().getY());
        entryTeleporterTile.setPortalLocation(exitPos);
        exitTeleporterTile = new ExitTeleporterTile(getDirection(),exitPos);
        setCurrentHealth(0);
        return exitTeleporterTile;
    }

}
