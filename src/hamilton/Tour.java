package hamilton;

import java.util.ArrayList;

public class Tour {
	private ArrayList<Node> tour = new ArrayList<Node>();

	public Tour() {
		for (int i = 0; i < NodeManager.numbersOfNodes(); i++) {
			tour.add(null);
		}
	}
	
	public Tour(ArrayList<Node> tour)
	{
		this.tour = tour;
	}
	
	
}
