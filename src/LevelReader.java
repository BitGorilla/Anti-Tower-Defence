import java.io.IOException;
import java.io.InputStream;

public interface LevelReader {

    public boolean hasNext() throws IOException;

    public Level next() throws IOException;

    public void setSource(InputStream inStream) throws IOException;
}
