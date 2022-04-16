package graphics;

import java.awt.*;

/**
 * interface of objects who can be able to be drawn
 */
public interface IDrawable {

    /**
     * path of the image
     */
    public final static String PICTURE_PATH = "C:\\Git Project\\Zoo\\src\\graphics\\pictures\\";

    /**
     * loading images for both directions in the correct color and animal type
     * @param nm - image name including type and color of the animal
     */
    public void loadImages(String nm);

    /**
     * drawing the animal in his location
     * @param g
     */
    public void drawObject (Graphics g);

    /**
     * returning the color of the object
     * @return
     */
    public String getColor();
}
