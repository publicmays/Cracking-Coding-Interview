/** 
 * 2.2 Return Kth to Last 
 * Implement an algorithm to find the kth to last element of a singly linked list
 */

Node printKthToLast(Node head, int k) {
	if (head == null)	return 0;

	int index = printKthToLast(head.next, k) + 1;
	if (index == k)
		System.out.println(kth + "th to last node is " + head.data);
	return index;
}

