package src;

/**
 * Driver code.
 * 
 * @author Benson Hall
 * @version 1.0
 */
public class Driver {
	public static void main(String[] args) {
		String filename = "data/me.ppm";
		PPMImage image = IO.readImage(filename);
		PPMImage attempt = Evolve.evolveImage(image, 10000, 60, 0.20);
		IO.writeImage("data/attemptMe.ppm", attempt);
		System.out.println("Complete!");
	}
}
