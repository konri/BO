package hamiltonAlgorithm;

import java.util.Random;

public class MatrixPermission {

	private static boolean isReady = false;
	private static int[][] matrixPermission = new int[10][10];
	private static int amountNodes = 0;
	private static Random rand = new Random();

	public static void addNode(int lastIndex) {
		if (lastIndex > matrixPermission.length)
			expandMatrix();
		amountNodes++;
	}

	public static void addPermission(int fromNode, int toNode) throws ArrayIndexOutOfBoundsException {
		if (fromNode > matrixPermission.length || fromNode < 0
				|| toNode > matrixPermission.length || toNode < 0
				|| fromNode > amountNodes
				|| toNode > amountNodes) {
			throw new ArrayIndexOutOfBoundsException();
		}

		matrixPermission[toNode][fromNode] = 1;
		matrixPermission[fromNode][toNode] = 1;

	}

	public static boolean getPermission(int fromNode, int toNode) throws ArrayIndexOutOfBoundsException {
		if (fromNode > matrixPermission.length || fromNode < 0
				|| toNode > matrixPermission.length || toNode < 0) {
			throw new ArrayIndexOutOfBoundsException();
		}

		if (matrixPermission[fromNode][toNode] == 1)
			return true;
		else
			return false;
	}

	private static void expandMatrix() {
		int[][] tmp = new int[matrixPermission.length + 10][matrixPermission.length + 10];
		for (int i = 0; i < tmp.length; i++)
			for (int j = 0; j < tmp.length; j++)
				tmp[i][j] = 0; // TODO: czy dac tutaj -1 dla nie istniejacych
								// node?

		for (int i = 0; i < matrixPermission.length; i++)
			for (int j = 0; j < matrixPermission.length; j++)
				tmp[i][j] = matrixPermission[i][j];

		matrixPermission = tmp;

	}

	public static void setReady() {
		isReady = true;
	}

	public static boolean getReady() {
		return isReady;
	}
	
	public static int getAmountNodes()
	{
		return amountNodes;				
	}
	public static void randomPermission() {
		for(int i = 0; i < getAmountNodes(); i++)
			for(int j = 0; j < getAmountNodes(); j++){
				if(rand.nextInt(2) == 1)
					if(i!=j)
						addPermission(i, j);
			}
	}

	public static void allPermission() {
		for (int i = 0; i < getAmountNodes(); i++)
			for (int j = 0; j < getAmountNodes(); j++)
				if (i != j)
					addPermission(i, j);

	}
	
	public static String toPrint() {
		String tmpString = "____________________________\r\n";
		for (int i = 0; i < getAmountNodes(); i++) {
			tmpString += i + "|";
			for (int j = 0; j < getAmountNodes(); j++) {
				tmpString += "|" + matrixPermission[i][j];
			}
			tmpString += "\r\n";
		}
		return tmpString;

	}

}
