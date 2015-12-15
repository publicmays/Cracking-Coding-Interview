/**
 * 2.7 Intersection
 * Given 2 (singly) linked lists, determine if the 2 lists intersect.
 * Return the intersecting node. Note that the intersection is defined
 * based on reference, not value that is if the kth node of the 
 * first linked list is the exact same node (by reference) as the jth
 * node of the 2nd linked list, then they are intersection
 */
class Result {
	public Node tail;
	public int size;
	public Result(Node tail, int size) {
		this.tail = tail;
		this.size = size;
	}
}

Node findIntersection(Node list1, Node list2) {
	if (!list1 || !list2)	return null;
	
	Result result1 = getTailAndSize(list1);
	Result result2 = getTailAndSize(list2);

	if (result.tail != result.tail)
		return null;
	Node shorter = result1.size < result2.size ? list1 : list2;
	Node longer = result1.size < result2 ? list2 : list1;

	// advance pointer for the longer linked list by diff in lengths
	longer = getKthNode(longer, Math.abs(result1.size - result2.size));
	while (shorter != longer) {
		shorter = shorter.next;
		longer = longer.next;
	}
	return longer;		// return either one
}

Result getTailAndSize(Node list) {
	int size = 1;
	Node current = list;
	while (current.next) {
		++size;	current = current.next;
	}
	return new Result(current, size);	// current = tail
}

Node getKthNode(Node head, int k) {
	for(int i = 0; i < k; ++i)
		head = head.next;
	return head;
}
/*
O(A + B) time, O(1) space
A - length of list1

Intersection - tails must be the same
3 - 1 - 5 - 9
			 \
			  7 - 2 - 1
		     /
		4 - 6

1. Run through each linked list to get the lengths and the tails
2. Compare the tails. If they are diff (by ref, not by value), return immediately
3. set 2 pointers to start of each linked list
4. on the longer list, advance its pointer by the difference in lengths
5. traverse on each linked list until the pointers are the same
*/

