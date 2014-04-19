package hamilton;

import java.util.Random;

public class Test {

	public static void main(String[] args)
	{
		Node node0 = new Node();
		NodeManager.addNode(node0);
		Node node1 = new Node();
		NodeManager.addNode(node1);
		Node node2 = new Node();
		NodeManager.addNode(node2);
		Node node3 = new Node();
		NodeManager.addNode(node3);
		Node node4 = new Node();
		NodeManager.addNode(node4);
		Node node5 = new Node();
		NodeManager.addNode(node5);
		Node node6 = new Node();
		NodeManager.addNode(node6);
		Node node7 = new Node();
		NodeManager.addNode(node7);
		
		MatrixPermission.addPermission(0,1);
		MatrixPermission.addPermission(0,4);
		MatrixPermission.addPermission(1,2 );
		MatrixPermission.addPermission(2,4 );
		MatrixPermission.addPermission(4,3 );
		MatrixPermission.addPermission(4,6);
		MatrixPermission.addPermission(3,6 );
		MatrixPermission.addPermission(3,5 );
		MatrixPermission.addPermission(5,7 );
		MatrixPermission.addPermission(6,7 );
		MatrixPermission.addPermission(4,3 );
		MatrixPermission.addPermission(1,3 );
		MatrixPermission.addPermission(2,8 );
		MatrixPermission.addPermission(6,4 );
		MatrixPermission.addPermission(8,9 );
		MatrixPermission.allPermission();
		
		System.out.print(MatrixPermission.toPrint());
		
		//Tour newTour = new Tour();

//		newTour.setNode(0, node3);
//		newTour.setNode(1, node5);
//		newTour.setNode(2, node7);
//		newTour.setNode(3, node6);
//		newTour.setNode(4, node4);
//		newTour.setNode(5, node2);
//		newTour.setNode(6, node1);
//		newTour.setNode(7, node0);
		
		MatrixPermission.setReady();
		
//		newTour.generateRandomize();
//		
//		while(!HamiltonAlgorithm.checkHamilton(newTour))
//		{
//			newTour.generateRandomize();
//		}
//		System.out.println(newTour + ": " + HamiltonAlgorithm.checkHamilton(newTour));
		

//		
//		System.out.print("permission:" + 		NodeManager.getPermission(1, 1));
//		
//		//System.out.print(MatrixPermission.toPrint());
//		
//		System.out.println();
//		
		
		Population testPopulacji = new Population(100, true);

//		Random rand = new Random();
		
//		
//		System.out.println("Rodzic1: " + testPopulacji.getTour(3));
//		System.out.println("Rodzic2: " + testPopulacji.getTour(5));
//		System.out.println("Child:   " + GeneticAlgorithm.crossOver(testPopulacji.getTour(3), testPopulacji.getTour(5)));
//		GeneticAlgorithm.mutation(testPopulacji.getTour(5));
//		System.out.println("muttation: " + testPopulacji.getTour(5));
//		
//		System.out.print(testPopulacji);
//		
		
		System.out.println();
		for(int i =0; i < 10000; i++)
			if(!GeneticAlgorithm.isFull()){
				testPopulacji  = GeneticAlgorithm.solvePopulation(testPopulacji);
				
			}
				
//		
		System.out.print(testPopulacji);
		System.out.println();
		
		for(int i=0; i < testPopulacji.getSize(); i++)
		{
			System.out.println(HamiltonAlgorithm.checkHamilton(testPopulacji.getTour(i))
								+ " : " +
								testPopulacji.getTour(i)
							   );
		}
		
	}
	
	
}
