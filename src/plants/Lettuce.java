package plants;

import mobility.Point;
import utilities.MessageUtility;

/**
 * @author baroh
 *
 */
public class Lettuce extends Plant {
    public Lettuce(Point p) {
        super("lettuce", p);
        //MessageUtility.logConstractor("Lettuce", "Lettuce");
    }
}
