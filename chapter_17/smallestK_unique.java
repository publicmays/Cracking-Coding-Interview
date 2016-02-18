/** 
 * 17.14 - Smallest K
 * Design an algorithm to find the smallest K numbers in an array
 */

int[] smallestK(int[] array, int k) {
	if (k <= 0 || k > array.length)	throw new IllegalArgumentException();
	int threshold = rank(array, k-1);
	int count = 0;
	for (int a : array) {
		if (a <= threshold) {
			smallest[count] = a;
			++count;
		}
	}
	return smallest;
}
// get (k-1)th element 
int rank(int[] array, int rank) {
	return rank(array, 0, array.length-1, rank);
}

int rank(int[] array, int left, int right, int rank) {
	int pivot = array[randomIntInRange(left, right)];
	int leftEnd = partition(array, left, right, pivot);
	int leftSize = leftEnd - left + 1;
	if (rank == leftSize-1)
		return max(array, left, leftEnd);
	else if (rank < leftSize)
		return rank(array, left, leftEnd, rank);
	else
		return rank(array, leftEnd + 1, right, rank-leftSize);
}

// partition so all elements <= pivot come before all elements > pivot
int partition(int[] array, int left, int right, int pivot) {
	whiel (left <= right) {
		if (array[left] > pivot) {
			swap(array, left, right); 
			--right;
		}
		else if (array[right] <= pivot) {
			swap(array, left, right);
			++left;
		}
		else 
			++left; --right;
	}
	return left-1;
}

// inclusive
int randomIntInRange(int min, int max) {
	Random rand = new Random();
	return random.nextInt(max+1-min,) + min;
}

// get largest element in array between left & right indices
int max(int[] array, int left, int right) {
	int max = Integer.MIN_VALUE;
	for (int left; i <= right; ++i) 
		max = Math.max(array[i], max);
	return max;
}


/**
 * O(n) time
 * Pseudo code
 * 1. Pick a random element in the array and use it as a pivot. Partition elements around the pivot, keeping track of 
 * the number of elements on the left side of the partition
 * 2. If there are exactly i elements on the left , then you just return the biggest element on the left
 * 3. If the left side is bigger than i, repeat the algorithm on just the left part of the array
 * 4. If the left side is smaller than i, repeat the algorithm on the right, but look for the element with rank i-leftSize
 */