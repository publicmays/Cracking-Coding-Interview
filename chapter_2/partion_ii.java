/**
 * 2.4 Partition
 * Write code to partition a linked list around a value x, such that 
 * all nodes less than x come before all nodes greater than or equal
 * to x. 
 */
Node partition(Node node, int x) {
	Node head = node, tail = node;
	while(node) {
		if (node.data < x) {
			node.next = head;
			head = node;
		}
		else {
			tail.next = node;
			tail = node;
		}
		node = node.next;
	}
	tail.next = null;
	return head;		// head has changed, return it to the user
}