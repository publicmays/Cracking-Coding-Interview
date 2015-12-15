/**
 * 2.5 - Sum Lists
 * You have numbers represented by a linked list, where each node contains
 * a single digit. The digits are stored in reverse order. Write a function
 * that adds the 2 numbers and returns a sum as a linked list
 * Input : 7->1->6 + 5->9->2 = 617 + 295
 * Output : 2 -> 1 -> 9 = 912
 */

int convertToNumber(Node head) {
	int digit = 1;
	int count = 0;
	int num = head.data;
	head = head.next;
	while (head) {
		digit *= 10
		num += head * digit;
		head = head.next;
	}
	return num;
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
			temp = num % 10;
			tail.next = temp;
			tail = temp;
		}
		num /= 10;
	}
	return head;
}

Node sumLists(Node num1, Node num2) {
	int sum = convertToNumber(num1) + convertToNumber(num2);
	return convertToLinkedList(sum);
}
/*
617
617 % 10 = 7
617 / 10 = 61

61 % 10 = 1
60 / 10 = 6

6 % 10 = 6
6 / 10 = 0
 */