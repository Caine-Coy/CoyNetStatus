import java.awt.Point;
/**
 * 
 * @author 'Caine'/Joe Benson
 * A class that holds valuable methods used by all. For easily readable code.
 * @version 1.1
 *
 */

public class CoyFunctions {
    //COORDINATE FUNCTIONS
    /**
     * 
     * @param x int coordinate
     * @param y int coordinate
     * @return a point made of x and Y
     */
    public Point makePoint(int x,int y) {
        Point point = new Point();
        point.x = x;
        point.y = y;
        return point;
        
    }
    
     /**Clamps a value between two values.
      * Returns min value if below min,
      * Returns max value if above max.
      *
      * @param value in double
      * @param min value output in double
      * @param max value output in double
      * @return clamped value
      */
    public double clamp(double value, double min,double max) {

        if (value < min) {
            return min;
        }
        else if (value > max) {
            return max;
        }
        else {
            return value;
        }
        
    }
    
    /**Clamps a value between two values.
      * Returns min value if below min,
      * Returns max value if above max.
      * This is the overload for int.
      *
      * @param value in int
      * @param min value output in int
      * @param max value output in int
      * @return clamped value
      */
    public int clamp(int value, int min,int max) {

        if (value < min) {
            return min;
        }
        else if (value > max) {
            return max;
        }
        else {
            return value;
        }
        
    }
    
    /**Simplify the bounding system so it is easy to manipulate.
     * 
     * @param int x of hitting object
     * @param int y of hitting object 
     * @param int minX of collided object
     * @param int maxX of collided object
     * @param int minY of collided object
     * @param int maxY of collided object
     * @return if in bounds or not.
     */
    public boolean inBounds(int x,int y,int minX,int maxX,int minY,int maxY) {
        if (x >= minX) {
            if (x <= maxX) {
                if (y >= minY) {
                    if (y <= maxY) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    //NETWORK FUNCTIONS
    static String convertMACtoString(byte[] MACBytes){
        String[] hex = new String[MACBytes.length]; 
        for (int i = 0; i < MACBytes.length; i++) {
            hex[i] = String.format("%02X", MACBytes[i]);
        }
        return String.join("-", hex);
    }
}
