package src;

/**
 * Individual abstract data type. Each individual holds a PPM image and a
 * fitness value. Higher fitness value is bad.
 * 
 * @author Benson Hall
 * @version 1.0
 */
public class Individual implements Comparable<Individual> {
	private PPMImage image;
	private double fitness;

	/**
	 * Individual constructor.
	 * 
	 * @param img     - image
	 * @param fitness - fitness value
	 */
	public Individual(PPMImage img, double fitness) {
		this.image = img;
		this.fitness = fitness;
	}

	/**
	 * Get a deep copy of the image
	 * 
	 * @return image - deep copy of the image
	 */
	public PPMImage getImage() {
		return this.image.clone();
	}

	/**
	 * Get the fitness value of the individual
	 * 
	 * @return fitness - fitness value of the individual
	 */
	public double getFitness() {
		return this.fitness;
	}

	/**
	 * Set a new image for the individual
	 * 
	 * @param img - new image
	 */
	public void setImage(PPMImage img) {
		this.image = img;
	}

	/**
	 * Set new fitness value for the individual
	 * 
	 * @param fitness - new fitness value
	 */
	public void setFitness(double fitness) {
		this.fitness = fitness;
	}

	/**
	 * Clone an individual.
	 * 
	 * @return i - deep copy of the Individual object
	 */
	@Override
	public Individual clone() {
		PPMImage newImage = this.getImage();
		Individual i = new Individual(newImage, this.fitness);
		return i;
	}

	/**
	 * Compare individuals.
	 * 
	 * @param o - Individual to compare to
	 * @return 1 if the calling Individual has a higher or equal fitness, -1
	 *         otherwise
	 */
	@Override
	public int compareTo(Individual o) {
		if (this.fitness >= o.getFitness()) {
			return 1;
		} else {
			return -1;
		}
	}
}