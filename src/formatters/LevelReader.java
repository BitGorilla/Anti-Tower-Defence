package formatters;

import Main.Map;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public interface LevelReader {

    boolean hasNext() throws IOException;

    ArrayList<Map> getMaps();

    void setSource(InputStream inStream) throws IOException;
}
