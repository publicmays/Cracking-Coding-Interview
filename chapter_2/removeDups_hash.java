/** 
 * 2.1 - Remove Duplicates
 * Write code to remove duplicates from an unsorted linked list
 * Follow up 
 * How would you solve this problem if a temporary buffer is not allowed?
 */

removeDuplicates(Node n) {
	HashSet<Integer> set = new HashSet<Integer>();
	Node previous = null;

	while (n) {
		if (set.contains(n.data)) 
			previous.next = n.next;

		else {
			set.add(n.data);
			previous = n;
		}
		n = n.next;
	}
}

/** 
 * O(N) time
 */