package formatters;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.print.Doc;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.ElementType;
import java.util.ArrayList;

public class XMLReader implements LevelReader, LevelXMLConstants{
    private NodeList nodeList;
    private int i = 0;

    private int height;
    private int width;
    private String name;
    private int startCredit;
    private ArrayList<String> tileList;

    private String getTagValue(String tag, Element element){
        NodeList nlList =
                element.getElementsByTagName(tag).item(0).getChildNodes();
        Node nValue = (Node) nlList.item(0);

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

            if (tempNode.getNodeType()==Node.ELEMENT_NODE){
                System.out.println(tempNode.getAttributes().getNamedItem(
                        ROAD).getNodeValue());
            }
        }
    }

    private void readTileTypes(Node tilesNode) {
        for (int j=0; j<tilesNode.getChildNodes().getLength();j++){
            Node tempNode = tilesNode.getChildNodes().item(j);

            if (tempNode.getNodeType()==Node.ELEMENT_NODE){
                System.out.println(tempNode.getAttributes().getNamedItem(
                        TYPE).getNodeValue());
            }
        }
    }

    @Override
    public boolean hasNext() {
        return i<nodeList.getLength();
    }

    @Override
    public void next() {
        Node node = nodeList.item(i);
        i++;

        if (node.getNodeType() == Node.ELEMENT_NODE){

            Node metaNode = getNodeByTag(META, node);
            Node tilesNode = getNodeByTag(TILES, node);

            setMapAttributes(metaNode, tilesNode);

            System.out.println(height+" "+width+" "+name+" "+startCredit);

            readTileRoads(tilesNode);
            readTileTypes(tilesNode);
            System.out.println(" ");
        }
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
