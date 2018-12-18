package formatters;

import gameLogic.Map;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Interface LevelReader
 *
 * @author  id15msd
 * @since 2018-12-14
 */
public interface LevelReader {

    boolean hasNext() throws IOException;

    ArrayList<Map> getMaps();

    void setSource(InputStream inStream) throws IOException;
}
