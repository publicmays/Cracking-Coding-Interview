/**
 * 2.5 - Sum Lists
 * You have numbers represented by a linked list, where each node contains
 * a single digit. The digits are stored in reverse order. Write a function
 * that adds the 2 numbers and returns a sum as a linked list
 * FOLLOW UP - 
 * Suppose the digits are stored in forward order.
 * Input (6->1->7) + (2->9->5) = 617 + 295
 * Output (9->1->2) = 912
 */
int convertToNumber(Node head) {
	int total = 0;
	while (head.next) {
		total *= head.data;
		total += head.next.data;
	}
	return total;
}

int convertToLinkedList(int num) {
	Node head = null, tail = null;
	Node temp = null;
	while (num > 0) {
		if (!head) {
			head.data = num % 10;
			tail = head;
		}
		else {
			temp.data= num % 10;
			temp.next = head;
			head = temp;
		}
		num /= 10;
	}
}

Node sumLists(Node num1, num2) {
	int sum = convertToNumber(num1) + convertToNumber(num2);
	return convertToLinkedList(sum);
}

/*
	6 * 10 = 60
	total = 60 + 1

	61 * 10 = 610
	total = 617
*/1

	617

	617