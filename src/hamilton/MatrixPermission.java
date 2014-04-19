package hamilton;

public class MatrixPermission {

	private static boolean isReady = false;
	private static int[][] matrixPermission = new int[10][10];
	
	public static void addNode(int lastIndex) {
		if (lastIndex > matrixPermission.length)
			expandMatrix();

	}

	public static void addPermission(int fromNode, int toNode) throws ArrayIndexOutOfBoundsException {
		if (fromNode > matrixPermission.length || fromNode < 0
			 || toNode > matrixPermission.length || toNode < 0) {
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
	
	public static void setReady()
	{
		isReady = true;
	}
	
	public static boolean getReady()
	{
		return isReady;
	}
	
	public static String toPrint() {
		String tmpString = "____________________________\n";
		for (int i = 0; i < matrixPermission.length; i++) {
			tmpString += i + "|";
			for (int j = 0; j < matrixPermission.length; j++) {
				tmpString += "|" + matrixPermission[i][j];
			}
			tmpString += "\n";
		}
		return tmpString;

	}
	//TODO:
	public static void randomPermission()
	{
		
	}
	
	public static void allPermission()
	{
		for(int i = 0; i < matrixPermission.length; i++)
			for(int j=0; j< matrixPermission[i].length; j++)
			{
				if(i!=j)
					addPermission(i, j);
			}
	}
	
	

}
