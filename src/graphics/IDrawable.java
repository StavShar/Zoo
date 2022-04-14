package graphics;

import java.awt.*;

/**
 * interface of objects who can be able to be drawn
 */
public interface IDrawable {
    /**
     * path of the image
     */
    public final static String PICTURE_PATH = "…";

    /**
     * loading images in the correct color
     * @param nm - image color
     */
    public void loadImages(String nm);

    /**
     * drawing an object
     * @param g
     */
    public void drawObject (Graphics g);

    /**
     * returning the color of the object
     * @return
     */
    public String getColor();
}
