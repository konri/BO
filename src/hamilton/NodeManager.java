package hamilton;

import java.util.ArrayList;

/*
 * this class include every nodes which we add to workspace. 
 * It return:
 *  index of Node's reference  --> it help to get information from matrix which contains information about possibility path. 
 *  reference of Node's index
 *  amount number of containsNode list.    
 * 
 */
public class NodeManager {
	
	
	private static ArrayList<Node> containsNode = new ArrayList<Node>(); //hold our nodes 
	
	/*
	 * add Node to main list
	 */
	public static void addNode(Node node)
	{
		containsNode.add(node);
		MatrixPermission.addNode(numbersOfNodes());
	}
	
	/*
	 * Get Node by index. 
	 */
	public static Node getNodeByIndex(int index)
	{
		return containsNode.get(index);
	}
	
	/*
	 * Get index of node.
	 */
	public static int getNodeByRefernce(Node node)
	{
		return containsNode.indexOf(node);
	}
	
	/*
	 * Get size of list.
	 */
	public static int numbersOfNodes()
	{
		return containsNode.size();
	}
	
	/*
	 * add permission to current path
	 */
	public static void addPermission(int fromNode, int toNode) 
	{
		try
		{
		MatrixPermission.addPermission(fromNode, toNode);
		}catch(ArrayIndexOutOfBoundsException e )
		{
			throw new ArrayIndexOutOfBoundsException();
		}
	}
	
	/*
	 * get permission to current path
	 */
	public static boolean getPermission(int fromNode, int toNode)
	{
		try
		{
			return MatrixPermission.getPermission(fromNode, toNode);
		}catch(ArrayIndexOutOfBoundsException e )
		{
			throw new ArrayIndexOutOfBoundsException();
		}
		
	}
	
}
