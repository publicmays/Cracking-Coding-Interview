/**
 * 1.7 Rotate Matrix
 * Given an image represented by an NxN matrix, where each pixel in the image
 * is 4 bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
 */

void rotate (int[][] m, int n) {
	for (int layer = 0; layer < n/2; ++layer) {
		int first = layer;
		int last = n-1-layer;
		for (int i = first; i < last; ++i) {
			int offset = i-first;
			int topCopy = m[first][i];								// save top
			int top = m[first][i];
			int left = m[last-offset][first];
			int bottom = m[last][last-offset];
			int right = m[i][last];

			top = left;
			left = bottom;
			bottom = right;
			right = topCopy;
		}
	} 
}

/* O(N^2), touch all N^2 elements */