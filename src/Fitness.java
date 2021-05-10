package src;

/**
 * Fitness computations
 * 
 * @author Benson Hall
 * @version 1.0
 */
public class Fitness {

	/**
	 * Compute the distance between two pixels
	 * 
	 * @param a - first pixel
	 * @param b - second pixel
	 * @return distance between pixels
	 */
	private static double compDistance(Pixel a, Pixel b) {
		double distR = a.getR() - b.getR();
		distR *= distR;
		double distG = a.getG() - b.getG();
		distG *= distG;
		double distB = a.getB() - b.getB();
		distB *= distB;
		return (distR + distG + distB);
	}

	/**
	 * Compute the distance between two images of the same size
	 * 
	 * @param A    - first image
	 * @param B    - second image
	 * @param size - size of images
	 * @return distance between images
	 */
	private static double compDistance(Pixel[] A, Pixel[] B, int size) {
		double distance = 0;
		for (int i = 0; i < size; i++) {
			Pixel a = A[i];
			Pixel b = B[i];
			distance += compDistance(a, b);
		}
		distance = Math.sqrt(distance);
		return distance;
	}

	/**
	 * Compute the fitness of each individual in the population
	 * 
	 * @param original - original image
	 * @param inds     - array of individuals
	 * @param popSize  - population size
	 */
	public static void compFitnessPopulation(Pixel[] original, Individual[] inds, int popSize) {
		for (int i = 0; i < popSize; i++) {
			Pixel[] data = inds[i].getImage().getData();
			int size = data.length;
			
			// compute fitness and assign to the individual
			double fitness = compDistance(original, data, size);
			inds[i].setFitness(fitness);
		}
	}
}
