package mobility;

/**
 *Representing location with (x,y) coordinates
 *
 * @version 1.0 1 apr 2022
 * @author Stav Sharabi
 * */
public class Point {
    private static final int X_MIN = 0;
    private static final int X_MAX = 800;
    private static final int Y_MIN = 0;
    private static final int Y_MAX = 600;
    private int x;
    private int y;

    /**
     * constructor of Point class
     * @param x - x coordinate
     * @param y - y coordinate
     */
    public Point(int x, int y){
            this.x = x;
            this.y = y;
    }

    /**
     * checking if the (x,y) coordinates of the new location are legal
     * @param newLocation - the new location
     * @return true if they are legal
     */
    public static boolean checkBounderies(Point newLocation) {
        return ((newLocation.getX() > X_MIN) && (newLocation.getX() < X_MAX)) && ((newLocation.getY() > Y_MIN) && (newLocation.getY() < Y_MAX));
    }

    /**
     * returning the x
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * returning the minimum of x coordinate
     * @return x minimum
     */
    public static int getXMin(){
        return X_MIN;
    }

    /**
     * returning the maximum of x coordinate
     * @return x maximum
     */
    public static int getXMax(){
        return X_MAX;
    }

    /**
     * returning the minimum of y coordinate
     * @return y minimum
     */
    public static int getYMin(){
        return Y_MIN;
    }

    /**
     * returning the maximum of y coordinate
     * @return y maximum
     */
    public static int getYMax(){
        return Y_MAX;
    }

    /**
     * returning the y
     * @return y
     */
    public int getY() {
        return y;
    }

    @Override
    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals()
     */
    public boolean equals(Object o){
        return ((o instanceof Point) && ((x == ((Point) o).getX()) && (y == ((Point) o).getY())));
    }

    @Override
    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return "(" + x + "," + y + ')';
    }
}
