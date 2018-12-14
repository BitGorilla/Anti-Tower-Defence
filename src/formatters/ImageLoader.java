package formatters;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.HashMap;

/**
 * Class responsible for storing and returning images.
 *
 * @author io16jsn, id15msd
 * @since 2018-12-14
 */
public class ImageLoader {
    private static ImageLoader loader;
    private HashMap<String, Image> imageStorage = new HashMap<>();
    private int scale;

    /**
     * Fetches an image from the imageStore HashMap.
     *
     * @param s name of image file
     * @return Image with the filename s
     */
    public Image getImage(String s) {
        if(imageStorage.containsKey(s)) {
            return imageStorage.get(s);
        }
        else {
            try {
                Image i = ImageIO.read(this.getClass().getResourceAsStream(
                                "/images/newImages/" + s));
                i=i.getScaledInstance(scale, scale, Image.SCALE_SMOOTH);
                imageStorage.put(s, i);
                return i;
            } catch (IOException e) {
                return null;
            }
        }
    }

    /**
     *  Constructor of class.
     */
    private ImageLoader(){
    }

    /**
     * Sets scale parameter for when reading images.
     *
     * @param scale height and width scale of image.
     */
    public void setScale(int scale){
        this.scale = scale;
    }

    /**
     * Creates an ImageLoader. Can only create one instance of class.
     *
     * @return ImageLoader
     */
    public static synchronized ImageLoader getImageLoader(){
        if (loader != null){
            return loader;
        } else {
            return loader=new ImageLoader();
        }
    }
}
