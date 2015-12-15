/**
 * 2.6 - Palindrome
 * Implement a function to check if a linked list is a palindrome
 */

boolean isPalindrome(Node head) {
	Stack stack = new Stack();
	Queue queue = new Queue();
	while (head) {
		stack.push(head.data);
		queue.add(head.data);
		head = head.next;
	}
	int i = 0;
	while (i < stack.size()) {
		if (stack.pop() != queue.remove())
			return false;
	}
	return true;
}

/*
123 4 567
rac e car

765 4 321
*/