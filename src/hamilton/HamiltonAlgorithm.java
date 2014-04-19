package hamilton;

public class HamiltonAlgorithm {

	public static boolean checkHamilton(Tour tour) {
		if (MatrixPermission.getReady()) {
			for (int i = 0; i < tour.getSize() - 1; i++) {
				if (!MatrixPermission.getPermission(
						NodeManager.getIdNodeByRefernce(tour.getNode(i)), 
						NodeManager.getIdNodeByRefernce(tour.getNode(i + 1)))) {
					System.out.println("false");
					return false;
				}
			}
				if(!MatrixPermission.getPermission(
						NodeManager.getIdNodeByRefernce(tour.getNode(tour.getSize() - 1)), 
						NodeManager.getIdNodeByRefernce(tour.getNode(0)))){
					
					return false;
				}else{
					System.out.println("true");
					return true;
				}			
		}else{
			return false;
		}
		
	}
	
	
}
