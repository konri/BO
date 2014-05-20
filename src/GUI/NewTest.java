package GUI;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import exceptions.GeneticAlgorithmExeptions;
import geneticAlgorithm.GeneticAlgorithm;
import geneticAlgorithm.Population;
import geneticAlgorithm.Tour;
import geneticAlgorithm.Tour.MethodFitness;
import graph.Node;
import graph.NodeManager;
import hamiltonAlgorithm.HamiltonAlgorithm;
import hamiltonAlgorithm.MatrixPermission;

public class NewTest {
	public static void main(String[] args) {
		/*
		 * Create objects of nodes
		 */
		
		MatrixPermission matrix = new MatrixPermission();
		NodeManager nodeManager = new NodeManager(matrix);
		
		Node node0 = new Node();
		nodeManager.addNode(node0);
		Node node1 = new Node();
		nodeManager.addNode(node1);
		Node node2 = new Node();
		nodeManager.addNode(node2);
		Node node3 = new Node();
		nodeManager.addNode(node3);
		Node node4 = new Node();
		nodeManager.addNode(node4);
		Node node5 = new Node();
		nodeManager.addNode(node5);
		Node node6 = new Node();
		nodeManager.addNode(node6);
		Node node7 = new Node();
		nodeManager.addNode(node7);

		/*
		 * Add some Permission to above nodes.
		 */

//		matrix.addPermission(0, 1);
//		matrix.addPermission(0, 4);
//		matrix.addPermission(1, 2);
//		matrix.addPermission(2, 4);
//		matrix.addPermission(2, 3);
//		matrix.addPermission(4, 3);
//		matrix.addPermission(4, 6);
//		matrix.addPermission(3, 6);
//		matrix.addPermission(3, 5);
//		matrix.addPermission(5, 7);
//		matrix.addPermission(7, 4);
//		matrix.addPermission(5, 2);
//		matrix.addPermission(6, 7);
		
	//	matrix.
		matrix.randomPermission();
		System.out.println("Permission matrix: ");
		System.out.println(matrix); // print of matrix
														// permission

		matrix.setReady(); // setReady to true. We set that program is
										// ready to start.
		HamiltonAlgorithm.setMatrixPermission(matrix);
	
		
//		System.out.println(testPopulacji.getTour(7));
//		System.out.println(HamiltonAlgorithm.getAllAmountGoodConnections(testPopulacji.getTour(7)));
//		System.out.println(HamiltonAlgorithm.getAfterAnotherAmountGoodConnections(testPopulacji.getTour(7)));
//		
//		System.out.println("All: " + testPopulacji.getTour(7).getFittness(MethodFitness.getAllConnect) + 
//							"After: "+ testPopulacji.getTour(7).getFittness(MethodFitness.getAfterAnotherConnect));
//		
//		System.out.println("After: "+ testPopulacji.getTour(7).getFittness(MethodFitness.getAfterAnotherConnect));
//
//		System.out.println("All: " + testPopulacji.getTour(7).getFittness(MethodFitness.getAllConnect) +  
//						   "After: "+ testPopulacji.getTour(7).getFittness(MethodFitness.getAfterAnotherConnect));
//		Tour tmpAA = testPopulacji.getFittest(MethodFitness.getAfterAnotherConnect);
//		Tour tmpAll = testPopulacji.getFittest(MethodFitness.getAllConnect);
//		
//		System.out.println("AA: "+ tmpAA.getFittness(MethodFitness.getAfterAnotherConnect) + " All: " + tmpAll.getFittness(MethodFitness.getAllConnect));
//		
		Population testPopulacji = new Population(100, true);
		GeneticAlgorithm genetic = new GeneticAlgorithm(10,0.1,5,MethodFitness.getAllConnect);
		/******************* Test population *************************/
		System.out.println();
		for (int i = 0; i < 100000; i++)
			if (!genetic.isFull()) {
				try {
					testPopulacji = genetic.solvePopulation(testPopulacji);
				} catch (GeneticAlgorithmExeptions e) {
					e.printStackTrace();
				}

			}
		//
		
		Population hamiltonPaths = genetic.getHamiltonPaths(); //population of correct non-duplicated paths. 
		System.out.println("Correct paths: " + genetic.getAmountGoodPath());
		for (int i = 0; i < genetic.getAmountGoodPath(); i++) {
			System.out.println(HamiltonAlgorithm.checkHamilton(hamiltonPaths
					.getTour(i)) + " : " + hamiltonPaths.getTour(i));
		}
	
		
		
/* zapis */		
//		PrintWriter zapis = null;
//		 try {
//			 zapis =  new PrintWriter("hamilton.txt");
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		 zapis.println(MatrixPermission.toPrint());
//		 zapis.println("Correct paths: " + genetic.getAmountGoodPath());
//		for (int i = 0; i < genetic.getAmountGoodPath(); i++) {
//			zapis.println(HamiltonAlgorithm.checkHamilton(hamiltonPaths
//						.getTour(i)) + " : " + hamiltonPaths.getTour(i));
//			}
//
//		zapis.close();
	}

}
