package formatters;

import tiles.*;
import gameLogic.CenterPositionCalculator;
import gameLogic.Direction;
import gameLogic.Map;
import gameLogic.Position;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * Reads a XML file and translates it to playable levels.
 *
 * @author io16jsn, id15msd, id15lbn, io16ohl
 * @since 2018-12-14
 */
public class XMLReader implements LevelReader, LevelXMLConstants{
    private NodeList nodeList;
    private int i = 0;
    private int height;
    private int width;
    private String name;
    private int startCredit;
    private int winCondition;
    private ArrayList<Map> maps;
    private int gameWindowWidth;

    public XMLReader(int gameWindowWidth) {
        this.gameWindowWidth = gameWindowWidth;
    }

    /**
     * Get a nodes element by its tag
     * @param tag that is requested
     * @param node current node
     * @return requested node
     */
    private Node getNodeByTag(String tag, Node node){
        return ((Element) node).getElementsByTagName(tag).item(0);
    }

    /**
     * Get the value that the item contains
     * @param node current node
     * @return value as a String
     */
    private String getValue(Node node){
        return node.getChildNodes().item(0).getNodeValue();
    }

    /**
     * Set the data in the node to the constants that builds up the map
     * @param metaNode
     * @param tilesNode
     */
    private void setMapAttributes(Node metaNode, Node tilesNode){
        height = Integer.parseInt(getValue(getNodeByTag(HEIGHT,metaNode)));
        width = Integer.parseInt(getValue(getNodeByTag(WIDTH,metaNode)));
        name = getValue(getNodeByTag(NAME,metaNode));
        startCredit = Integer.parseInt(getValue(getNodeByTag(STARTCREDIT,
                metaNode)));
        winCondition = Integer.parseInt(getValue(getNodeByTag(WINCONDITION,
                metaNode)));
        ImageLoader.getImageLoader().setScale(gameWindowWidth/width);
    }

    /**
     * This class use reflection for creating tile classes depending on XML data
     * It also use CPC, center position calculator, to get the area that the
     * tile represents.
     * Finally a tile is given a image.
     * @param parentTileNode
     * @return a arraylist of Tiles
     */
    private ArrayList<Tile> buildTiles(Node parentTileNode){
        ArrayList<Tile> tiles = new ArrayList<>();
        CenterPositionCalculator CRC;
        NodeList tileNodes = parentTileNode.getChildNodes();
        Node tileNode;
        String type;
        String road;
        Direction direction;
        Position upperLeft;
        Position lowerRight;
        Image tileImage;
        int counter = 1;
        for (int j = 0; j < parentTileNode.getChildNodes().getLength(); j++) {
            tileNode = tileNodes.item(j);
            if (tileNode.getNodeType()==Node.ELEMENT_NODE) {
                type = tileNode.getAttributes().getNamedItem(TYPE).getNodeValue();
                road = tileNode.getAttributes().getNamedItem(ROAD).getNodeValue();
                direction = getDirection(road);
                CRC = new CenterPositionCalculator(gameWindowWidth, width, counter);
                counter++;
                upperLeft = new Position(CRC.getxMinValue(), CRC.getyMinValue());
                lowerRight = new Position(CRC.getxMaxValue(), CRC.getyMaxValue());
                tileImage = getTileImage(road, type);
                try {
                    tiles.add(TileCreator.createTile(type, tileImage, direction,
                            CRC.getCenterPosition(), upperLeft, lowerRight));
                } catch (ClassNotFoundException | InstantiationException |
                        InvocationTargetException | IllegalAccessException |
                        NoSuchMethodException e) {
                    e.printStackTrace();
                    System.err.println("No/bad tile type: " + type);
                    tiles.add(new BlankTile(tileImage, direction,
                            CRC.getCenterPosition(),
                            upperLeft
                            , lowerRight));
                }
            }
        }
        return tiles;
    }

    /**
     * Return the right image that is related to a specific tile name
     * @param road
     * @param type
     * @return
     */
    private Image getTileImage(String road, String type) {
        StringBuilder sb = new StringBuilder();
        sb.append(road);
        sb.append(type);
        ImageLoader loader = ImageLoader.getImageLoader();
        try {
            if (road.equals("BLANK")) {
                switch (type) {
                    case "TREE":
                        return loader.getImage("tree.png");
                    case "WATER":
                        return loader.getImage("water.png");
                    case "SlowTile":
                        return loader.getImage("slow.png");
                    default:
                        return loader.getImage("blank2.png");
                }
            } else {
                switch (type) {
                    case "BlankTile":
                        return loader.getImage("road.png");
                    case "GoalTile":
                        return loader.getImage("start.png");
                    case "StartTile":
                        return loader.getImage("start.png");
                    case "SlowTile":
                        return loader.getImage("slowTile.png");
                    case "SpikeTile":
                        return loader.getImage("spike.png");
                    case "MisdirectionTile":
                        return loader.getImage("misdirection.png");
                    case "SpeedTile":
                        return loader.getImage("speedTile.png");
                    case "RegenerationTile":
                        return loader.getImage("regeneration.png");
                    case "FlipperTile":
                        switch (road) {
                            case "EAST":
                                return loader.getImage("FLipperTile-East.png");
                            case "WEST":
                                return loader.getImage("FLipperTile-West.png");
                            case "NORTH":
                                return loader.getImage("FLipperTile-North.png");
                            case "SOUTH":
                                return loader.getImage("FLipperTile-South.png");
                        }
                    default:
                        return loader.getImage("blank2.png");
                }
            }
        } catch (IllegalArgumentException e) {
            return loader.getImage("blank.png");
        }
    }

    /**
     * Get direction of that the tile contains, to get a path for the creatures.
     * @param road
     * @return
     */
    private Direction getDirection(String road) {
        String[] strings = road.split("-");
        try {
            return Direction.valueOf(strings[strings.length - 1]);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    /**
     * Check if the nodeList have more nodes to read or not
     * @return true is it still has nodes left, else false.
     */
    @Override
    public boolean hasNext() {
        return i<nodeList.getLength();
    }

    /**
     * Get the map and build it if the arraylist still have more left.
     * @return maps as a arraylist.
     */
    public ArrayList<Map> getMaps() {
        ArrayList<Map> maps = new ArrayList<>();
        while(hasNext()) {
            maps.add(buildMap());
        }
        return maps;
    }

    /**
     * Build a map that have all parameters:
     * name, start credits and tiles.
     * @return map
     */
    private Map buildMap() {
        Node node = nodeList.item(i);
        i++;

        if (node.getNodeType() == Node.ELEMENT_NODE){
            Node metaNode = getNodeByTag(META, node);
            Node tilesNode = getNodeByTag(TILES, node);
            Map map;
            setMapAttributes(metaNode, tilesNode);
            map = new Map(name, startCredit, winCondition, buildTiles(tilesNode));
            return map;
        }
        return null;
    }


    /**
     * Tells the xml reader where it should read from
     * @param inStream inputStream
     * @throws IOException ParserConfigurationException and SAXException
     */
    @Override
    public void setSource(InputStream inStream) throws IOException {
        //Sets the source and parses the XML data to a DOM tree.
        try {
            DocumentBuilderFactory dbFactory =
                    DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inStream);
            Element data=doc.getDocumentElement();
            data.normalize();

            nodeList = doc.getElementsByTagName(MAP);
        } catch (ParserConfigurationException e) {
            throw new IOException("Unable to configure parser");
        } catch (SAXException e) {
            throw new IOException("Not correct format");
        }
    }

    /**
     *
     * @return width of map
     */
    public int getWidth(){
        return width;
    }
}

