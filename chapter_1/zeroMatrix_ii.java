/** 
 * 1.8 - Zero Matrix
 * Write an algorithm such that if an element in an NxN matrix is 0, 
 * its entire row and column are set to 0
 */

void setZero(int[][] matrix) {
	boolean rowHasZero = false;
	boolean colHasZero = false;

	for(int j = 0; j < matrix[0].length; ++j) {
		if (matrix[0][j] == 0) {
			rowHasZero = true;
			break;
		}
	}

	for (int i = 0; i < matrix.length; ++i) {
		if (matrix[i][0] == 0) {
			colHasZero = 0;
			break;
		}
	}

	for (int i = 1; i < matrix.length; ++i) {
		for (int j = 1; j < matrix[0].length; ++j) {
			if (matrix[i][j] == 0) {
				matrix[i][0] = 0;
				matrix[0][j] = 0;
			}

		}
	}

	// nullify rows based on values in first column
	for (int i = 1; i < matrix.length; ++i) 
		if (matrix[i][0] == 0)
			nullifyRow(matrix, i);

	for (int j = 1; j < matrix[0].length; ++j) 
		if (matrix[0][j] == 0)
			nullifyColumn(matrix, j);

	// nullify first row & column
	if (rowHasZero)
		nullifyRow(matrix, 0);
	if (colHasZero)
		nullifyColumn(matrix, 0);
	
}

/**
 * reduce space by using first row as replacement for row array
 * and first column as column array
 * Space O(1)
 */