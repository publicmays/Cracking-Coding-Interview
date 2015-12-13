/** 
 * Intro - Singly Linked List
 */

class Node {
	int data = null;
	Node next = null;
	public Node(int data) {
		this.data = data;
	} 
	void appendToTail(int data) {
		Node end = new Node(data);
		Node n = this;
		while (n.n) {
			n = this.next;
		}
		n.next = end;
	}
}

Node deleteNode(Node head, int d) {
	Node n = head;
	if (n.data == d) 
		return head.next;	// remove head

	while (n.next) {
		if (n.next.data == d) {
			n.next = n.next.next;
			return head;	// head didn't change
		}
		n = n.next;
	}
	return head;
}