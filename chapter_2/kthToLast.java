/** 
 * 2.2 Return Kth to Last 
 * Implement an algorithm to find the kth to last element of a singly linked list
 */

Node kthToLast(Node head, int k) {
	Node current = head;
	Node kthToLast = head;
	int i = 0;
	while (i < k && current) {
		if (current == null)
			return null;
		current = current.next;
	}
	while (current) {
		current = current.next;
		kthToLast = kthToLast.next;
	}
	return kthToLast;
}

/* O(N) time, O(1) space */