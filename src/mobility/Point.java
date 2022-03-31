package mobility;

public class Point {
    private static final int X_MIN = 0;
    private static final int X_MAX = 800;
    private static final int Y_MIN = 0;
    private static final int Y_MAX = 600;
    private int x;
    private int y;

    public Point(int x, int y){
            this.x = x;
            this.y = y;
    }

    public static boolean checkBounderies(Point newLocation) {
        return ((newLocation.getX() > X_MIN) && (newLocation.getX() < X_MAX)) && ((newLocation.getY() > Y_MIN) && (newLocation.getY() < Y_MAX));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean equals(Object o){
        return ((o instanceof Point) && ((x == ((Point) o).getX()) && (y == ((Point) o).getY())));
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ')';
    }
}
