package src;

import java.util.Arrays;

/**
 * Evolve algorithm.
 * 
 * @author Benson Hall
 * @version 1.0
 */
public class Evolve {
	/**
	 * Evolve an image.
	 * 
	 * @param original - original image to replicate
	 * @param numGen   - number of generations
	 * @param popSize  - size of the population
	 * @param rate     - mutation rate
	 * @return attempt at replication
	 */
	public static PPMImage evolveImage(PPMImage original, int numGen, int popSize, double rate) {
		int width = original.getWidth();
		int height = original.getHeight();
		int maxColour = original.getMaxColour();
		Individual[] population = Population.generatePopulation(popSize, width, height, maxColour);
		
		// Initiate the fitness of each individual.
		// Sort individuals in increasing order of fitness.
		Fitness.compFitnessPopulation(original.getData(), population, popSize);
		Arrays.sort(population);
		
		for (int i = 1; i <= numGen; i++) {
			System.out.println("Generation " + i);

			// manipulate individuals
			Crossover.crossover(population, popSize);
			Mutate.mutatePopulation(population, popSize, rate);
			
			// compute fitness and sort
			Fitness.compFitnessPopulation(original.getData(), population, popSize);
			Arrays.sort(population);
			
			// TODO debug
			System.out.println("Best individual: " + population[0].getFitness() + "\n");
		}
		
		// first individual has lowest fitness, best replica
		return population[0].getImage();
	}
}
