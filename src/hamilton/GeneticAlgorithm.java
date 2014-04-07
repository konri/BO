package hamilton;

import java.util.Random;

public class GeneticAlgorithm {

	private static double mutationRate = 0.1;
	
	
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
	 * Mutation tour 
	 * swap two nodes if possibility will be lesser than mutationRate(10%). 
	 * 
	 */
	public static void mutation(Tour tour)
	{
		Random rand = new Random();
		for(int i = 0; i < tour.getSize(); i++)
		{
			if(rand.nextDouble() < mutationRate)
			{
				int randomSecond = rand.nextInt(tour.getSize());// generate second index of swaping node. 
				Node node1 = tour.getNode(i); 
				Node node2 = tour.getNode(randomSecond);
				
				//swap between two nodes.
				tour.setNode(i, node2);
				tour.setNode(randomSecond, node1);
			}
		}
	}

}
