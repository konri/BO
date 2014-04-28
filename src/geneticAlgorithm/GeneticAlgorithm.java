package geneticAlgorithm;

import exceptions.GeneticAlgorithmExeptions;
import exceptions.GeneticAlgorithmExeptions.ErrorNumber;
import graph.Node;
import hamiltonAlgorithm.HamiltonAlgorithm;

import java.util.Random;

import javax.swing.text.StyleContext.SmallAttributeSet;

public class GeneticAlgorithm {

	private static double mutationRate = 0.1;
	public static int amountGoodPath = 0;
	private static boolean isFullPopulation = false;
	private static Population correctPathPopulation = new Population(100, false);
	
	/*
	 * IF geneticAlgorithm wasnt static class but object class 
	 * in constructor we need to get information how many correct, nonduplicated tours we want to get 
	 * And thanks that we initiation size population.
	 */
	
	
	public static Population solvePopulation(Population population)	throws GeneticAlgorithmExeptions {
		Population tmpPopulation = new Population(population.getSize(), false);
		
		/*
		 * add correct Hamilton path to correctPathPopulation 
		 * First we check if is Hamilton then checkIfExists such a path in population 
		 */
		
		for(int i = 0; i < population.getSize(); i++){
			if(HamiltonAlgorithm.checkHamilton(population.getTour(i))){
				if(!correctPathPopulation.checkIfExists(population.getTour(i),amountGoodPath)){
					correctPathPopulation.setTour(amountGoodPath, population.getTour(i));
					if(amountGoodPath++ > correctPathPopulation.getSize() - 1){
						isFullPopulation = true;
						return tmpPopulation;
					}
				}
			}
		}
	
		
		for (int k = 0; k < tmpPopulation.getSize(); k++) {
			// get randomly parent1 and parent 2 from old population
			Tour parent1 = getRandomTour(population);
			Tour parent2 = getRandomTour(population);
			// create child with crossover
			Tour child = crossOver(parent1, parent2);
			// set new tour to new population
			tmpPopulation.setTour(k, child);
		}
		for (int k = 0; k < tmpPopulation.getSize(); k++)
			mutation(tmpPopulation.getTour(k));

		return tmpPopulation;

	}

	public static Tour crossOver(Tour parent1, Tour parent2) {
		int startPos; // start position of substitution nodes in new child
		int endPos; // end position
		Random rand = new Random();

		Tour child = new Tour(); // child

		do {

			startPos = rand.nextInt(parent1.getSize()); // randome in [0,n)
			endPos = rand.nextInt(parent1.getSize());

		} while (startPos == endPos);

		/*
		 * reverse position if startPos > endPos
		 */
		if (startPos > endPos) {
			int tmp = endPos;
			endPos = startPos;
			startPos = tmp;
		}

		/*
		 * Put Node to child which we choose from parent1
		 */
		for (int i = startPos; i < endPos; i++)
			child.setNode(i, parent1.getNode(i));

		/*
		 * Put node to child in free place from parent2
		 */
		for (int p = 0, j = 0; j < parent2.getSize(); j++) {
			if (j < startPos || j >= endPos) {
				while (child.containsNode(parent2.getNode(p))) {
					p++;
				}
				child.setNode(j, parent2.getNode(p));
			}
		}

		return child;

	}

	/*
	 * Mutation tour swap two nodes if possibility will be lesser than
	 * mutationRate(10%).
	 */
	public static void mutation(Tour tour) {
		Random rand = new Random();
		for (int i = 0; i < tour.getSize(); i++) {
			if (rand.nextDouble() < mutationRate) {
				int randomSecond = rand.nextInt(tour.getSize());// generate
																// second index
																// of swaping
																// node.
				Node node1 = tour.getNode(i);
				Node node2 = tour.getNode(randomSecond);

				// swap between two nodes.
				tour.setNode(i, node2);
				tour.setNode(randomSecond, node1);
			}
		}
	}

	public static Population getHamiltonPaths(){
		return correctPathPopulation;
	}
	/*
	 * Get random tour from population
	 */
	private static Tour getRandomTour(Population population) {
		Random rand = new Random();
		return population.getTour(rand.nextInt(population.getSize()));
	}

	public static boolean isFull() {
		return isFullPopulation;
	}
}
