/** 
 * 1.8 - Zero Matrix
 * Write an algorithm such that if an element in an NxN matrix is 0, 
 * its entire row and column are set to 0
 */

void setZero(int[][] matrix) {
	boolean[] row = new boolean[matrix.length];
	boolean[] column = new boolean[matrix[0].length];

	for (int i = 0; i < matrix.length; ++i) {
		for (int j = 0; j < matrix[0].length; ++j) {
			if (matrix[i][j] == 0) {
				row[i] = true;
				col[i] = true;
			}
		}
	}

	for (int i = 0; i < row.length; ++i) 
		if (row[i])
			nullifyRow(matrix, i);
	}

	for (int j = 0; j < column.length; ++j) 
		if (column[j])
			nullifyColumn(matrix, j);
}

void nullifyRow (int[][] matrix, int row) {
	for (int j = 0; j < matrix[0].length; ++j)
		matrix[row][j] = 0;
}

void nullifyColumn(int[][] matrix, int col) {
	for (int i = 0; i < matrix.length; ++i) 
		matrix[i][col] = 0;
}


/* O (3 N^2) time, O(N) space */