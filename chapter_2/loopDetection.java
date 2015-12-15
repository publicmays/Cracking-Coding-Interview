/** 
 * 2.8 Loop Detection
 * Given a circular linked list, implement an algorithm that returns the node at the
 * beginning of the loop. 
 * DEFINITION
 * Circular linked list : A (corrupt) linked list in which a ode's next pointer
 * points to an earlier node, so as to make a loop in the linked list
 * EXAMPLE
 * INPUT : A -> B -> C -> D -> E -> C [ the same C as earlier ]
 * Output : C
 */
Node findBeginning(head) {
	Node slow = head;
	Node fast = head;

	// find meeting point. This will be LOOP_SIZE - k steps into the linked list
	while (fast && fast.next) {
		slow = slow.next;
		fast = fast.next.next;
		if (slow == fast)		// collision
			break;
	}
	if (fast == null || fast.next == null)	// error check, no meeting point
		return null;
	slow = head;
	while (slow != fast) {
		slow = slow.next;
		fast = fast.next;
	}
	return fast;
}
/*
1. Create 2 pointers - fast and slow
2. Move fast at a rate of 2 steps and a slow pointer at a rate of 1 step
3. when they collide, move slow pointer to linked list head. keep fast pointer where it is
4. move slow and fast at rate of 1 step. return new collision point 
*/