package src;

/**
 * Mutation class
 * 
 * @author Benson Hall
 * @version 1.0
 */
public class Mutate {
	/**
	 * Mutate an individual's pixels based on the rate.
	 * 
	 * @param i    - individual being mutated
	 * @param rate - rate of mutation
	 */
	private static void mutate(Individual i, double rate) {
		// extract data
		PPMImage image = i.getImage();
		int width = image.getWidth();
		int height = image.getHeight();
		int maxColour = image.getMaxColour();
		Pixel[] data = image.getData();
		
		int n = width * height;
		int select = (int) (rate / 100 * n);

		// mutate pixels
		for (int j = 0; j < select; j++) {
			int index = (int) (Math.random() * n);
			int r = (int) (Math.random() * (maxColour + 1));
			int g = (int) (Math.random() * (maxColour + 1));
			int b = (int) (Math.random() * (maxColour + 1));
			data[index] = new Pixel(r, g, b);
		}
		
		// set new data
		image.setData(data);
		i.setImage(image);
	}

	/**
	 * Mutate the "weakest" 3/4 of the population
	 * 
	 * @param population - sorted array of Individuals
	 * @param popSize    - population size
	 * @param rate       - rate of pixels to be mutated
	 */
	public static void mutatePopulation(Individual[] population, int popSize, double rate) {
		for (int i = (int) (popSize / 4); i < popSize; i++) {
			mutate(population[i], rate);
		}
	}
}
