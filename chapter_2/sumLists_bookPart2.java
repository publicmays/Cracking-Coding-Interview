/**
 * 2.5 - Sum Lists
 * You have numbers represented by a linked list, where each node contains
 * a single digit. The digits are stored in reverse order. Write a function
 * that adds the 2 numbers and returns a sum as a linked list
 * Input : 7->1->6 + 5->9->2 = 617 + 295
 * Output : 2 -> 1 -> 9 = 912
 */

Node addLists(Node l1, Node l2, int carry) {
	if (l1 == null && l2 == null && carry == 0)	return null;

	Node result = Node();
	int value = carry;
	if (l1)
		value += l1.data;
	if (l2) 
		value += l2.data;
	result.data = value % 10;		// 2nd digit of num
	if (l1 || l2) {
		Node more = addLists(l1 == null ? null : l1.next, 
							l1 == null ? null : l2.next, 
							value >= 10 ? 1 : 0);
		result.setNext(more);
	}
	return result;
}
	