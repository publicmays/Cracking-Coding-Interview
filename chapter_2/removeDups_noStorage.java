/** 
 * 2.1 - Remove Duplicates
 * Write code to remove duplicates from an unsorted linked list
 * Follow up 
 * How would you solve this problem if a temporary buffer is not allowed?
 */

void removeDuplicates(Node head) {
	Node current = head;
	while (current) {
		Node runner = current;
		while (runner.next) {
			if (runner.next.data == current.data) 
				runner.next = runner.next.next;
			else
				runner = runner.next;
		}
		current = current.next;
	}
}

/**
 * O(N^2) time 
 * O(1) time
*/

