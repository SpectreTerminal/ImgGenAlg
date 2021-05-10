package src;

/**
 * Crossover class
 * 
 * @author Benson Hall
 * @version 1.0
 */
public class Crossover {
	/**
	 * Recombine. Children of the parent individuals gain data from both parents.
	 * 
	 * @param parent1 - first parent Individual
	 * @param parent2 - second parent Individual
	 * @param child1  - first child Individual
	 * @param child2  - second child Individual
	 */
	private static void recombine(Individual parent1, Individual parent2, Individual child1, Individual child2) {
		int width = parent1.getImage().getWidth();
		int height = parent1.getImage().getHeight();
		int imageSize = width * height;
		int crossover = (int) (Math.random() * imageSize);

		// get parent values
		Pixel[] p1 = parent1.getImage().getData();
		Pixel[] p2 = parent2.getImage().getData();

		// get children values
		PPMImage cp1 = child1.getImage();
		PPMImage cp2 = child2.getImage();
		Pixel[] data1 = cp1.getData();
		Pixel[] data2 = cp2.getData();
		
		// up to crossover, child1 inherits from parent1, child2 inherits from parent2
		for (int i = 0; i < crossover; i++) {
			data1[i] = p1[i].clone();
			data2[i] = p2[i].clone();
		}

		// after crossover, child1 inherits from parent2, child2 inherits from parent1
		// copy pixel data from crossover to the end
		for (int i = crossover; i < imageSize; i++) {
			data1[i] = p2[i].clone();
			data2[i] = p1[i].clone();
		}

		// assign data values
		cp1.setData(data1);
		cp2.setData(data2);

		child1.setImage(cp1);
		child2.setImage(cp2);
	}

	/**
	 * Crossover algorithm - individuals breed to create new offspring
	 * 
	 * @param population - array of individuals
	 * @param popSize    - size of the population
	 */
	public static void crossover(Individual[] population, int popSize) {
		int half = popSize / 2;
		// precaution: an odd number of parents cannot work - causes array out of bounds
		// exception
		if (half % 2 == 1) {
			half -= 1;
		}
		for (int i = 0; i < half; i += 2) {
			recombine(population[i], population[i + 1], population[half + i], population[half + i + 1]);
		}
	}
}
