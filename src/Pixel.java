package src;
/**
 * Pixel abstract data type.
 * 
 * @author Benson Hall
 * @version 1.0
 */
public class Pixel {
    // pixel RGB values
    private int r;
    private int g;
    private int b;

    /**
     * Pixel constructor
     * 
     * @param r - red pixel value
     * @param g - green pixel value
     * @param b - blue pixel value
     */
    public Pixel(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    /**
     * Get red pixel value
     * 
     * @return r - red pixel value
     */
    public int getR() {
        return this.r;
    }

    /**
     * Get green pixel value
     * 
     * @return g - green pixel value
     */
    public int getG() {
        return this.g;
    }

    /**
     * Get blue pixel value
     * 
     * @return b - blue pixel value
     */
    public int getB() {
        return this.b;
    }

    /**
     * Set new red pixel value
     * 
     * @param r - new red pixel value
     */
    public void setR(int r) {
        this.r = r;
    }

    /**
     * Set new green pixel value
     * 
     * @param g - new green pixel value
     */
    public void setG(int g) {
        this.g = g;
    }

    /**
     * Set new blue pixel value
     * 
     * @param b - new blue pixel value
     */
    public void setB(int b) {
        this.b = b;
    }

    /**
     * Clone a pixel's data
     * 
     * @return p - deep copy of the pixel
     */
    @Override
    public Pixel clone() {
        Pixel p = new Pixel(this.r, this.g, this.b);
        return p;
    }
}