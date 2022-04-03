package mobility;

/**
 * interface of orientation in space
 */
public interface Ilocatable {

    /**
     * returning the location
     * @return location
     */
    Point getLocation();

    /**
     * location setter
     * @param p - point location
     * @return true if it succeeds
     */
    boolean setLocation(Point p);
}
