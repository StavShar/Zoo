package plants;

import food.Meat;
import mobility.Point;

/**
 * @author baroh
 *
 */
public class Cabbage extends Plant {
    private static Cabbage instance = null;

    /**
     * Cabbage constructor
     */
    private Cabbage() {
        super("cabbage");
    }


    /**
     * ensuring that Cabbage is a singletone
     * @return the instance of Cabbage
     */
    public static Cabbage getInstance() {
        if(instance == null)
            instance = new Cabbage();
        return instance;
    }

}
