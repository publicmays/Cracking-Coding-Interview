/** 
 * 17.14 - Smallest K
 * Design an algorithm to find the smallest K numbers in an array
 */

class PartitionResult {
	int leftSize, middleSize;
	public PartitionResult(int left, int middle) {
		this.leftSize = left;
		this.middleSize = middle;
	}
}
int[] smallestK(int[] array, int k) {
	if (k <= 0 || k > array.length)	throw new IllegalArgumentException();
	int threshold = rank(array, k-1);
	int[] smallest = new int[k];
	int count = 0;
	for (int a : array) {
		if (a < threshold) {
			smallest[count] = a;
			++count;
		}
	}
	while (count < k) {						// if there is still room left, this must be for elements equal to threshold element
		smallest[count] = threshold;		// copy those in
		++count;
	}
	return smallest;
}

int rank(int[] array, int k) {
	if (k >= array.length)	throw new IllegalArgumentException();
	return rank(array, k, 0, array.length-1);
}

int rank(int[] array, int k, int start, int end) {
	int pivot = array[randomIntInRange(start, end)];
	PartitionResult partition = partition(array, start, end, pivot);
	int leftSize = partition.leftSize;
	int middleSize = partition.middleSize;

	if (k < leftSize)
		return rank(array, k, start, start+leftSize-1);
	else if (k < leftSize + middleSize)
		return pivot;
	else
		return rank(array, k-leftSize-middleSize, start + leftSize + middleSize, end);
}

PartitionResult partition(int[] array, int start, int end, int pivot) {
	int left = start;		// stays at right edge of the left side
	int right = end;		// stays at left edge of right side
	int middle = start;		// stays at right edge of middle
	while (middle <= right) {
		if (array[middle] < pivot) {
			swap(array, middle, left);
			++middle; ++left;
		}
		else if (array[middle] > pivot) {
			swap(array, middle, right);
			--right;
		}
		else if (array[middle] == pivot) 
			++middle;
	}
	return new Partition(left - start, right - left + 1);		// return size of left, middle
}

/* O(n) time */
