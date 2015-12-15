/**
 * 2.6 - Palindrome
 * Implement a function to check if a linked list is a palindrome
 */

 boolean isPalindrome(Node head) {
 	Node fast = head;
 	Node slow = head;

 	Stack<Integer> stack = new Stack<Integer>();

 	while (fast && fast.next) {
 		stack.push(slow.data);
 		slow = slow.next;
 		fast = fast.next.next;
 	}
 	if (fast)		// has odd # of elements, so skip the middle element
 		slow = slow.next;

 	while (slow) {
 		int top = stack.pop().intValue();

 		// if values are different, then it's not a palindrome
 		if (top != slow.data)
 			return false;
 		slow = slow.next;
 	}
 	return true;
 }

 /*
 Push elements from first half of linked list onto stack.
 When fast runner (which is moving at 2x speed) reachers the end of the
 linked list, then we know we're at the middle 
 */
