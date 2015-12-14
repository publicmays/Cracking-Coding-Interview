/** 
 * 2.2 Return Kth to Last 
 * Implement an algorithm to find the kth to last element of a singly linked list
 */

class Index {
	public int value = 0;
}

Node kthToLast(Node head, int k) {
	Index index = new Index();
	return kthToLast(head, k, index);
}

Node kthToLast(Node head, int k, Index index) {
	if (head == null)	return null;
	Node node = kthToLast(head.next, k, index);
	index.value = index.value + 1;
	if (index.value == k)
		return head;
	return node;
}

/* O(N) space */