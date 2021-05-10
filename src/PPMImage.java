package src;

/**
 * PPM Image abstract data type
 * 
 * @author Benson Hall
 * @version 1.0
 */
public class PPMImage {
    private Pixel[] data;
    private final int width;
    private final int height;
    private final int maxColour;

    /**
     * PPM Image constructor
     * 
     * @param data - array of width * height pixels
     * @param width - width of image
     * @param height - height of image
     * @param maxColour - maximum value for a colour
     */
    public PPMImage(Pixel[] data, int width, int height, int maxColour){
        this.data = data;
        this.width = width;
        this.height = height;
        this.maxColour = maxColour;
    }

    /**
     * Get a deep copy of the data of the image.
     * 
     * @return data - deep copy of the image data
     */
    public Pixel[] getData(){
        Pixel[] copy = new Pixel[this.width * this.height];   
        for(int i = 0; i < copy.length; i++){
            copy[i] = this.data[i].clone();
        }
        return copy;
    }

    /**
     * Get the width of the image
     * 
     * @return width - width of the image
     */
    public int getWidth(){
        return this.width;
    }

    /**
     * Get the height of the image
     * 
     * @return height - height of the image
     */
    public int getHeight(){
        return this.height;
    }

    /**
     * Get the maximum possible colour
     * 
     * @return maxColour - maximum value for a colour
     */
    public int getMaxColour(){
        return this.maxColour;
    }

    /**
     * Set new data for the image
     * 
     * @param data - new data
     */
    public void setData(Pixel[] data){
        this.data = data;
    }

    /**
     * Clone an image
     * 
     * @return img - deep copy of the image
     */
    @Override
    public PPMImage clone(){
        Pixel[] copy = this.getData();
        PPMImage img = new PPMImage(copy, this.width, this.height, this.maxColour);
        return img;
    }
}
