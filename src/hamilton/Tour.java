package hamilton;

import java.util.ArrayList;
import java.util.Collections;

public class Tour {
	private ArrayList<Node> tour = new ArrayList<Node>();

	public Tour() {

		// TODO: Czy nie usunac tego tutaj i w generateRandomize zamiast set dac
		// add. Bo tutaj jest nie potrzebna petla??

		for (int i = 0; i < NodeManager.getSizeOfNodes(); i++) {
			tour.add(null);
		}
	}

	public Tour(ArrayList<Node> tour) {
		this.tour = tour;
	}

	/*
	 * Generate randomize tour of nodes
	 */
	public void generateRandomize() {
		for (int i = 0; i < NodeManager.getSizeOfNodes(); i++) {
			setNode(i, NodeManager.getReferenceNodeByIndex(i));
		}
		Collections.shuffle(tour);
	}

	/*
	 * set Node for exactly position in tour.
	 */
	public void setNode(int index, Node node) {
		tour.set(index, node);
	}

	/*
	 * get Note from indexTour
	 */
	public Node getNode(int indexTour) {
		return tour.get(indexTour);
	}
	
	public int getSize()
	{
		return tour.size();
	}
	
	public String toString(){
		String tmp ="";
		for(int i= 0; i < getSize(); i++)
			if(i < getSize() - 1)
				tmp += NodeManager.getIdNodeByRefernce(getNode(i)) + "->";
			else
				tmp += NodeManager.getIdNodeByRefernce(getNode(i)) + "\n";
		
	return tmp;
	}

}
