package exceptions;

public class GeneticAlgorithmExeptions extends Exception {
	public enum ErrorNumber{
		outOfBoundsPopulation,
		notMatchSizeOfTours		
	}
	/**
	 * Default serialVesion
	 */
	private static final long serialVersionUID = 1L;
	private String msg;
	private ErrorNumber error;
	
	public GeneticAlgorithmExeptions(ErrorNumber error){
		this.error = error; 
		
	}

}
