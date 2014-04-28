package geneticAlgorithm;

import exceptions.GeneticAlgorithmExeptions;
import exceptions.GeneticAlgorithmExeptions.ErrorNumber;
import graph.Node;
import hamiltonAlgorithm.HamiltonAlgorithm;

import java.util.Random;

import javax.swing.text.StyleContext.SmallAttributeSet;

public class GeneticAlgorithm {

	
	private int amountGoodPath = 0;
	private boolean isFullPopulation = false;
	private Population correctPathPopulation;
	private MutationAlgorithm mutation;

	
	public GeneticAlgorithm(int populationSize, double mutationSeek){
		correctPathPopulation = new Population(populationSize, false);
		mutation = new MutationAlgorithm(mutationSeek);		
	}
	
	public GeneticAlgorithm(){
		correctPathPopulation = new Population(10, false);
		mutation = new MutationAlgorithm();
	}
	
	public Population solvePopulation(Population population) throws GeneticAlgorithmExeptions {
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
			Tour child = CrossoverAlgorithm.crossOver(parent1, parent2);
			// set new tour to new population
			tmpPopulation.setTour(k, child);
		}
		for (int k = 0; k < tmpPopulation.getSize(); k++)
			mutation.mutation(tmpPopulation.getTour(k));

		return tmpPopulation;

	}
	
	/*
	 * Return population which contains correct Hamiltion's paths. 
	 */
	public Population getHamiltonPaths(){
		return correctPathPopulation;
	}
	
	/*
	 * Return number of amount good path which save in population 
	 */
	public int getAmountGoodPath(){
	return amountGoodPath;
	}
	/*
	 * Return boolean isFullPopulation of correct Hamiltion's paths.  
	 */
	public boolean isFull() {
		return isFullPopulation;
	}
	
	/*
	 * Get random tour from population
	 */
	private Tour getRandomTour(Population population) {
		Random rand = new Random();
		return population.getTour(rand.nextInt(population.getSize()));
	}

	
}
