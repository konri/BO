package hamilton;

public class Population {
	private Tour[] tours;
	private int amountPopulation;
	/*
	 * Create a population initialize: true -- if we want to create a begin
	 * population
	 */
	public Population(int amountPopulation, boolean initialize) {
		this.amountPopulation = amountPopulation;
		tours = new Tour[amountPopulation];

		if (initialize) {
			for (int i = 0; i < amountPopulation; i++) {
				tours[i] = new Tour();
				tours[i].generateRandomize();
			}
		}
	}

	public Tour getTour(int index) {
		return tours[index];
	}

	public void setTour(int index, Tour tour) {
		tours[index] = tour;
	}

	public String toString()
	{
		String tmp = "";
		for(int i=0; i<amountPopulation; i++)
			tmp += getTour(i);
		return tmp;
	}
}
