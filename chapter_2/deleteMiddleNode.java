/** 
 * 2.3 Delete Middle Node
 * Implement an algorithm to delete a node in the middle of a singly linked list 
 * given only access to that node
 */

boolean deleteNode(Node n) {
	if (n == null || n.next == null)
		return false;
	n.data = n.next.data;
	n.next = n.next.next;
	return true;
}

/**
 * Node can't be solved if the node to be deleted 
 * is the last node in the linked list
 */