package formatters;

import java.io.IOException;
import java.io.InputStream;

public interface LevelReader {

    public boolean hasNext() throws IOException;

    public void next() throws IOException;

    public void setSource(InputStream inStream) throws IOException;
}
