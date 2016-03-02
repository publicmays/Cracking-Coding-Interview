/**
 * 17.20 - Continuous Median
 */

Comparator<Integer> maxHeapComparator, minHeapCompartor;
PriorityQueue<Integer> maxHeap, minHeap;

void addNewNumber(int randomNumber) {
	if (maxHeap.size() == minHeap.size()) {
		if (minHeap.peek() && randomNumber > minHeap.peek()) {
			maxHeap.offer(minHeap.poll());
			minHeap.offer(randomNumber);
		}
		else 
			maxHeap.offer(randomNumber);
	}
	else {
		if (randomNumber < maxHeap.peek()) {
			minHeap.offer(maxHeap.poll());
			max.offer(randomNumber);
		}
		else {
			minHeap.offer(randomNumber);
		}
	}
}

double getMedian() {
	if (maxHeap.isEmpty())	return 0;
	if (maxHeap.size() == minHeap.size()) 
		return ((double)minHeap.peek() + (double)maxHeap.peek())/2;
	// if maxHeap and minHeap are diff, maxHeap must have 1 extra element
	else 
		return maxHeap.peek();
}


/**
 * maxHeap
 * Maintains condition
 * maxHeap.size() >= minHeap.size()
 */

/**
 * maxHeap is always at least as big as minHeap. 
 */
