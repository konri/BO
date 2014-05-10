package hamiltonAlgorithm;

import geneticAlgorithm.Tour;
import graph.NodeManager;

public class HamiltonAlgorithm {

	public static boolean checkHamilton(Tour tour) {
		
			for (int i = 0; i < tour.getSize() - 1; i++) {
				if (!MatrixPermission.getPermission(
						NodeManager.getIdNodeByRefernce(tour.getNode(i)),
						NodeManager.getIdNodeByRefernce(tour.getNode(i + 1)))) {
					// System.out.println("false");
				return false;
				}
			}
			if (!MatrixPermission.getPermission(NodeManager
					.getIdNodeByRefernce(tour.getNode(tour.getSize() - 1)),
					NodeManager.getIdNodeByRefernce(tour.getNode(0)))) {
				return false;

			} else {
				return true;
			}
		}

	/*
	 * Get number of all correct connection between two Nodes e.g.
	 *  6=>4=>5=>1=>0=>7=>2=>3
	 *  this return 4 
	 *  because permission is: 6->4, 5->1, 0->7, 7->2
	 */

	
	public static int getAllAmountGoodConnections(Tour tour) {
		int amount = 0;
		
		for (int i = 0; i < tour.getSize() - 1; i++) 
			if (MatrixPermission.getPermission(
					NodeManager.getIdNodeByRefernce(tour.getNode(i)),
					NodeManager.getIdNodeByRefernce(tour.getNode(i + 1)))) 
				amount++;
		
		if(MatrixPermission.getPermission(
				NodeManager.getIdNodeByRefernce(tour.getNode(tour.getSize() - 1 )), 
				NodeManager.getIdNodeByRefernce(tour.getNode(0))))
			amount++;
			
		return amount;
	}
	/*
	 * Get number of correct connection between two Nodes but it must be after another 
	 * if has not connection between Nodes function stop and return actual amount
	 * e.g.
	 *  6=>4=>5=>1=>0=>7=>2=>3
	 *  this return 1 
	 *  because permission is: 6->4, 5->1, 0->7, 7->2 
	 * 
	 */
	public static int getAfterAnotherAmountGoodConnections(Tour tour){
		int amount = 0;
		for(int i = 0; i < tour.getSize() - 1; i++){
			if(MatrixPermission.getPermission(
					NodeManager.getIdNodeByRefernce(tour.getNode(i)),
					NodeManager.getIdNodeByRefernce(tour.getNode(i+  1)))){
				amount++;
			}else{
				return amount;
			}
		}
		if(MatrixPermission.getPermission(
				NodeManager.getIdNodeByRefernce(tour.getNode(tour.getSize() - 1)), 
				NodeManager.getIdNodeByRefernce(tour.getNode(0))))
			amount++;
		return amount;
	}

}
