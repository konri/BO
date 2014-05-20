package hamiltonAlgorithm;

import java.util.Random;

public class MatrixPermission {

	private boolean isReady = false;
	private int[][] matrixPermission;;
	private int amountNodes = 0;
	private Random rand = new Random();
	
	public MatrixPermission(int length){
		matrixPermission = new int[length][length];
		
	}
	public MatrixPermission(){
		matrixPermission = new int[10][10];
		
	}	
	
	public void addNode(int lastIndex) {
		if (lastIndex > matrixPermission.length)
			expandMatrix();
		amountNodes++;
	}

	public void addPermission(int fromNode, int toNode) throws ArrayIndexOutOfBoundsException {
		if (fromNode > matrixPermission.length || fromNode < 0
				|| toNode > matrixPermission.length || toNode < 0
				|| fromNode > amountNodes
				|| toNode > amountNodes) {
			throw new ArrayIndexOutOfBoundsException();
		}

		matrixPermission[toNode][fromNode] = 1;
		matrixPermission[fromNode][toNode] = 1;

	}

	public boolean getPermission(int fromNode, int toNode) throws ArrayIndexOutOfBoundsException {
		if (fromNode > matrixPermission.length || fromNode < 0
				|| toNode > matrixPermission.length || toNode < 0) {
			throw new ArrayIndexOutOfBoundsException();
		}

		if (matrixPermission[fromNode][toNode] == 1)
			return true;
		else
			return false;
	}

	private void expandMatrix() {
		int[][] tmp = new int[matrixPermission.length + 10][matrixPermission.length + 10];
		for (int i = 0; i < tmp.length; i++)
			for (int j = 0; j < tmp.length; j++)
				tmp[i][j] = 0;

		for (int i = 0; i < matrixPermission.length; i++)
			for (int j = 0; j < matrixPermission.length; j++)
				tmp[i][j] = matrixPermission[i][j];

		matrixPermission = tmp;

	}

	public void setReady() {
		isReady = true;
	}

	public boolean getReady() {
		return isReady;
	}
	
	public int getAmountNodes()
	{
		return amountNodes;				
	}
	
	public void randomPermission() {
		for(int i = 0; i < getAmountNodes(); i++)
			for(int j = 0; j < getAmountNodes(); j++){
				if(rand.nextInt(2) == 1)
					if(i!=j)
						addPermission(i, j);
			}
	}

	public void allPermission() {
		for (int i = 0; i < getAmountNodes(); i++)
			for (int j = 0; j < getAmountNodes(); j++)
				if (i != j)
					addPermission(i, j);

	}
	
	public String toString() {
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
