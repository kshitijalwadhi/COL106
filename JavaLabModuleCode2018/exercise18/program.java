public class program {
	public int[][] test(int M1[][], int M2[][]) {
		/*
		 * Exercise 18: Matrix addition- Given two matrices M1 and M2, the objective to
		 * add them. Each matrix is provided as an int[][], a 2 dimensional integer
		 * array. The expected output is also 2 dimensional integer array.
		 */

		int row_len = M1.length;
		int col_len = M1[0].length;

		int addition[][] = new int[row_len][col_len];
		for (int i = 0; i < row_len; i++) {
			for (int j = 0; j < col_len; j++) {
				addition[i][j] = M1[i][j] + M2[i][j];
			}
		}
		return addition;
	}
}
