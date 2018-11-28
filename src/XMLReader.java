import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;

public class XMLReader implements LevelReader, LevelXMLConstants{
    private NodeList nodeList;
    private int i;

    private String getTagValue(String tag, Element element){
        NodeList nlList =
                element.getElementsByTagName(tag).item(0).getChildNodes();
        Node nValue = (Node) nlList.item(0);

        return nValue.getNodeValue();
    }


    @Override
    public boolean hasNext() throws IOException {
        return false;
    }

    @Override
    public Level next() throws IOException {
        return null;
    }

    @Override
    public void setSource(InputStream inStream) throws IOException {

    }
}
