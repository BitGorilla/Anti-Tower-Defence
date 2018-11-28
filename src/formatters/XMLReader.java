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

public class XMLReader implements LevelReader, LevelXMLConstants{
    private NodeList tileNodeList;
    private NodeList towerNodeList;
    private NodeList mapTypeNodeList;
    private int i;

    private String getTagValue(String tag, Element element){
        NodeList nlList =
                element.getElementsByTagName(tag).item(0).getChildNodes();
        Node nValue = (Node) nlList.item(0);

        return nValue.getNodeValue();
    }


    @Override
    public boolean hasNext() throws IOException {
        return tileNodeList.getLength()>i;
    }

    @Override
    public void next() throws IOException {
        Node node = tileNodeList.item(0);
        i++;

        if (node.getNodeType() == Node.ELEMENT_NODE){
            if (node.getNodeName().equals("tile")){
                System.out.println(node.getNodeName());
                System.out.println(node.getAttributes().getNamedItem("attr").getNodeValue());
                System.out.println(getTagValue("pos", (Element) node));
            }

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

            tileNodeList = doc.getElementsByTagName("tile");
        } catch (ParserConfigurationException e) {
            throw new IOException("Unable to configure parser");
        } catch (SAXException e) {
            throw new IOException("Not correct format");
        }
    }
}
