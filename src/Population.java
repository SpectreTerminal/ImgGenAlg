package src;

/**
 * Generate a population.
 * 
 * @author Benson Hall
 * @version 1.0
 */
public class Population {
	/**
	 * Generate a random array of pixel data
	 * 
	 * @param width     - width of the image
	 * @param height    - height of the image
	 * @param maxColour - maximum value for a colour
	 * @return random array of data
	 */
	private static Pixel[] generateRandomImage(int width, int height, int maxColour) {
		Pixel[] data = new Pixel[width * height];
		// populate the array with pixel data
		for (int i = 0; i < data.length; i++) {
			int r = (int) (Math.random() * (maxColour + 1));
			int g = (int) (Math.random() * (maxColour + 1));
			int b = (int) (Math.random() * (maxColour + 1));
			Pixel p = new Pixel(r, g, b);
			data[i] = p;
		}
		return data;
	}

	/**
	 * Generate a population of individuals
	 * 
	 * @param size      - size of population
	 * @param width     - width of image
	 * @param height    - height of image
	 * @param maxColour - maximum value for a colour
	 * @return population - array of Individuals
	 */
	public static Individual[] generatePopulation(int size, int width, int height, int maxColour) {
		Individual[] population = new Individual[size];
		for (int i = 0; i < size; i++) {
			population[i] = generateIndividual(width, height, maxColour);
		}
		return population;
	}

	/**
	 * Create an individual
	 * 
	 * @param width     - width of the image
	 * @param height    - height of the image
	 * @param maxColour - maximum value for a colour
	 * @return i - new Individual
	 */
	private static Individual generateIndividual(int width, int height, int maxColour) {
		Pixel[] data = generateRandomImage(width, height, maxColour);
		PPMImage img = new PPMImage(data, width, height, maxColour);
		Individual i = new Individual(img, 0);
		return i;
	}
}
