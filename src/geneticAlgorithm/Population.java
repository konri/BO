package geneticAlgorithm;

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

	public Tour getTour(int index) throws ArrayIndexOutOfBoundsException {
		if(index < 0 || index >= amountPopulation)
			throw new ArrayIndexOutOfBoundsException();
		
		return tours[index];
	}

	public void setTour(int index, Tour tour) throws ArrayIndexOutOfBoundsException {
		if(index < 0 || index > amountPopulation)
			throw new ArrayIndexOutOfBoundsException();
		tours[index] = tour;
	}
	
	public void deleteTour(int index)
	{
		//tours[index] = null;
		for(int i = index; i < (getSize() - 1); i++)
		{
			tours[index] = tours[index+1];
		}
		tours[getSize() - 1 ] = null;
	}
	
	
	public int getSize()
	{
		return tours.length;
	}
	
	public String toString()
	{
		String tmp = "";
		for(int i=0; i<amountPopulation; i++)
			tmp += getTour(i);
		return tmp;
	}
}
