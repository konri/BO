package hamilton;

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
		Node node8 = new Node();
		NodeManager.addNode(node8);
		Node node9 = new Node();
		NodeManager.addNode(node9);
		Node node10 = new Node();
		NodeManager.addNode(node10);
		Node node11 = new Node();
		NodeManager.addNode(node11);
		Node node12 = new Node();
		NodeManager.addNode(node12);
		Node node13 = new Node();
		NodeManager.addNode(node13);
		Node node14 = new Node();
		NodeManager.addNode(node14);
		
		
		
		
		
		NodeManager.addPermission(1, 1);
		NodeManager.addPermission(2, 1);
		NodeManager.addPermission(3, 4);
		NodeManager.addPermission(5, 7);
		
		System.out.print("permission:" + 		NodeManager.getPermission(1, 1));
		
		System.out.print(MatrixPermission.toPrint());
	}
	
	
}
