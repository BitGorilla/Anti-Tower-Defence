package formatters;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.HashMap;

public class ImageLoader {
    private static ImageLoader loader;
    private HashMap<String, Image> imageStorage = new HashMap<>();
    private int scale;

    public Image getImage(String s) {
        if(imageStorage.containsKey(s)) {
            return imageStorage.get(s);
        }
        else {
            try {
                System.out.println("/images/testImages/" + s);
                Image i = ImageIO.read(this.getClass().getResourceAsStream(
                                "/images/testImages/" + s));
                i=i.getScaledInstance(scale, scale, Image.SCALE_SMOOTH);
                imageStorage.put(s, i);
                return i;
            } catch (IOException e) {
                return null;
            }
        }
    }


    private ImageLoader(){
    }

    public void setScale(int scale){
        this.scale = scale;
    }

    public static synchronized ImageLoader getImageLoader(){
        if (loader != null){
            return null;
        } else {
            return loader=new ImageLoader();
        }
    }
}
