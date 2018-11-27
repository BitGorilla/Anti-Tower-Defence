import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.HashMap;

public class ImageLoader {
    private static ImageLoader loader;
    private HashMap<String, Image> imageStorage = new HashMap<>();

    public Image getImage(String resourceName){
        if(imageStorage.containsKey(resourceName)) {
            return imageStorage.get(resourceName);
        }
        else {
            try {
                Image i = ImageIO.read(this.getClass().getResourceAsStream(resourceName));
                i=i.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                imageStorage.put(resourceName, i);
                return i;
            } catch (IOException e) {
                return null;
            }
        }
    }


    private ImageLoader(){

    }

    public static synchronized ImageLoader getImageLoader(){
        if (loader != null){
            return null;
        }else{
            return loader=new ImageLoader();
        }
    }
}
