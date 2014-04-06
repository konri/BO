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

		
		
		
		
		NodeManager.addPermission(1, 1);
		NodeManager.addPermission(2, 1);
		NodeManager.addPermission(3, 4);
		NodeManager.addPermission(5, 7);
		
		System.out.print("permission:" + 		NodeManager.getPermission(1, 1));
		
		//System.out.print(MatrixPermission.toPrint());
		
		System.out.println();
		
		Population testPopulacji = new Population(10, true);
		Random rand = new Random();
		
		System.out.println("Rodzic1: " + testPopulacji.getTour(3));
		System.out.println("Rodzic2: " + testPopulacji.getTour(5));
		System.out.println("Child:   " + GeneticAlgorithm.crossOver(testPopulacji.getTour(3), testPopulacji.getTour(5)));
		
		
		
		System.out.print(testPopulacji);
		
	}
	
	
}
