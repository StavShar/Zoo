package plants;

import food.Meat;
import graphics.ZooPanel;
import mobility.Point;

/**
 * @author baroh
 *
 */
public class Lettuce extends Plant {
    private static Lettuce instance = null;

    /**
     * Lettuce constructor
     */
    private Lettuce() {
        super("lettuce");
    }


    /**
     * ensuring that Lettuce is a singletone
     * @return the instance of Lettuce
     */
    public static Lettuce getInstance() {
        if(instance == null)
            instance = new Lettuce();
        return instance;
    }

}
