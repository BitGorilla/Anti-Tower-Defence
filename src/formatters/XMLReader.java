package formatters;

import Main.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class XMLReader implements LevelReader, LevelXMLConstants{
    private NodeList nodeList;
    private int i = 0;

    private int height;
    private int width;
    private String name;
    private int startCredit;
    private ArrayList<Map> maps;
    private int gameWindowWidth;

    public XMLReader(int gameWindowWidth) {
        this.gameWindowWidth = gameWindowWidth;
    }

    private String getTagValue(String tag, Element element){
        NodeList nlList =
                element.getElementsByTagName(tag).item(0).getChildNodes();
        Node nValue = nlList.item(0);

        return nValue.getNodeValue();
    }

    private Node getNodeByTag(String tag, Node node){
        return ((Element) node).getElementsByTagName(tag).item(0);
    }

    private String getValue(Node node){
        return node.getChildNodes().item(0).getNodeValue();
    }

    private void setMapAttributes(Node metaNode, Node tilesNode){

        height = Integer.parseInt(getValue(getNodeByTag(HEIGHT,metaNode)));
        width = Integer.parseInt(getValue(getNodeByTag(WIDTH,metaNode)));
        name = getValue(getNodeByTag(NAME,metaNode));
        startCredit = Integer.parseInt(getValue(getNodeByTag(STARTCREDIT,
                metaNode)));
    }

    private void readTileRoads(Node tilesNode) {
        for (int j=0; j<tilesNode.getChildNodes().getLength();j++){
            Node tempNode = tilesNode.getChildNodes().item(j);

            if (tempNode.getNodeType()==Node.ELEMENT_NODE) {
                if(tempNode.getAttributes().getNamedItem(
                        ROAD).getNodeValue() != "") {
                    System.out.println(tempNode.getAttributes().getNamedItem(
                            ROAD).getNodeValue());
                }
            }
        }
    }

    private ArrayList<Tile> buildTiles(Node parentTileNode){
        ArrayList<Tile> tiles = new ArrayList<>();
        CenterPositionCalculator CRC;
        NodeList tileNodes = parentTileNode.getChildNodes();
        for (int j=0; j<parentTileNode.getChildNodes().getLength();j++) {
            Node tileNode = tileNodes.item(j);
            if (tileNode.getNodeType()==Node.ELEMENT_NODE) {
                String type =
                        tileNode.getAttributes().getNamedItem(TYPE).getNodeValue();
                Direction dir =
                        Direction.valueOf(tileNode.getAttributes().getNamedItem(ROAD).getNodeValue());
                CRC = new CenterPositionCalculator(gameWindowWidth, width, j + 1);
                Position upperLeft = new Position(CRC.getxMinValue(),
                        CRC.getyMinValue());
                Position lowerRight = new Position(CRC.getxMaxValue(), CRC.getyMaxValue());

                try {
                    tiles.add(TileCreator.createTile(type, dir, CRC.getCenterPosition(),
                            upperLeft
                            , lowerRight));
                } catch (ClassNotFoundException | InstantiationException |
                        InvocationTargetException | IllegalAccessException |
                        NoSuchMethodException e) {
                    e.printStackTrace();
                    System.err.println("No/bad tile type: " + type);
                    tiles.add(new BlankTile(dir, CRC.getCenterPosition(), upperLeft
                            , lowerRight));
                }
            }
        }
        return tiles;
    }

    private void readTileTypes(Node tilesNode) {
        for (int j=0; j<tilesNode.getChildNodes().getLength();j++){
            Node tempNode = tilesNode.getChildNodes().item(j);

            if (tempNode.getNodeType()==Node.ELEMENT_NODE){
                if(tempNode.getAttributes().getNamedItem(
                        TYPE).getNodeValue() != "") {
                    System.out.println(tempNode.getAttributes().getNamedItem(
                            TYPE).getNodeValue());
                }
            }
        }
    }

    @Override
    public boolean hasNext() {
        return i<nodeList.getLength();
    }

    @Override
    public Map buildMap() {
        Node node = nodeList.item(i);
        i++;

        if (node.getNodeType() == Node.ELEMENT_NODE){

            Node metaNode = getNodeByTag(META, node);
            Node tilesNode = getNodeByTag(TILES, node);
            Map map;
            setMapAttributes(metaNode, tilesNode);
            map = new Map(name, startCredit, buildTiles(tilesNode));
            return map;
            //System.out.println(height+" "+width+" "+name+" "+startCredit);

            //readTileRoads(tilesNode);
            //readTileTypes(tilesNode);
            //System.out.println(" ");
        }
        return null;
    }

    @Override
    public void setSource(InputStream inStream) throws IOException {
        //Sets the source and parses the XML data to a DOM tree.
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inStream);
            Element data=doc.getDocumentElement();
            //Fixa så att tex inte flera textnoder finns efter varandra
            data.normalize();

            nodeList = doc.getElementsByTagName(MAP);
        } catch (ParserConfigurationException e) {
            throw new IOException("Unable to configure parser");
        } catch (SAXException e) {
            throw new IOException("Not correct format");
        }
    }
}
