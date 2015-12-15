/**
 * 2.4 Partition
 * Write code to partition a linked list around a value x, such that 
 * all nodes less than x come before all nodes greater than or equal
 * to x. 
 */
Node partition(Node node, int x) {
	Node beforeStart = null, beforeEnd = null, afterStart = null, afterEnd = null;

	while (node) {
		node.next = null;
		if (node.data < x) {		// insert node into end of before list
			if (!beforeStart) {
				beforeStart = node;
				beforeEnd = beforeStart;
			}
			else {
				beforeEnd.next = node;
				beforeEnd = node;
			}
		}
		else {						// insert node into end of after list
			if (!afterStart) {
				afterStart = node;
				afterEnd = afterStart;
			}
			else {
				afterEnd.next = node;
				afterEnd = node;
			}
		}
		node = node.next;
	}
	if (!beforeStart)
		return afterStart;

	// merge before list and after list
	beforeEnd.next = afterStart;
	return beforeStart;
}