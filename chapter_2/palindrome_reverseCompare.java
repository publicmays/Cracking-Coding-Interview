/**
 * 2.6 - Palindrome
 * Implement a function to check if a linked list is a palindrome
 */
class HeadAndTail {
	public Node head;
	public Node tail;

	public HeadAndTail(Node head, Node tail) {
		this.head = head;
		this.tail = tail;
	}
}

boolean isPalindrome(Node head) {
	HeadAndTail reversed = reverse(head);
	Node reversedHead = reversed.head;
	return isEqual(head, reversedHead);
}

HeadAndTail reverse(Node head) {
	if (!head)	return null;
	HeadAndTail ht = reverse(head.next);
	Node clonedHead = head.clone();
	clonedHead.next = null;

	if (!ht)
		return new HeadAndTail(clonedHead, clonedHead);

	ht.tail.next = clonedHead;
	return new HeadAndTail(ht.head, clonedHead);
}

boolean isEqual(Node one, Node two) {
	Node head1 = one;
	Node head2 = two;

	while (head1 && head2) {
		if (head1.data != head2.data)
			return false;
		head1 = head1.next;
		head2 = head2.next;
	}
	return head1 == null && head2 == null;
}

/*

 1
 	2	
 		3

clonedHead = 3
ht = (3,3)

clonedHead = 2
ht.tail = 2
ht = (3, 2);

clonedHead = 1
ht.tail = 1
ht = (3, 1)
*/