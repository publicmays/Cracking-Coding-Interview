/**
 * 2.6 - Palindrome
 * Implement a function to check if a linked list is a palindrome
 */

class Result {
	public Node node;
	public boolean result;
}

boolean isPalindrome(Node head) {
	int length = lengthOfList(head);
	Result p isPalindromeRecurse(head, length);
	return p.result;
}

Result isPalindrome Recurse(Node head, int length) {
	if (!head || length <= 0)
		return new Result(head, true);		// even # of nodes
	else if (length == 1)
		return new Result(head.next, true);	// odd # of nodes

	Result res = isPalindromeRecurse(head.next, length-2);

	if (!res.result || !res.node)
		return res;
	res.result = (head.data == res.node.data);
	res.node = res.node.next;
	return res;
}

int lengthOfList(Node n) {
	int size = 0;
	while (n) 
		++size; n =n.next;
	return size;
}
/*
isPalindrome: list = 0(1(2(3(4)3)2)1)0	len = 9
	isPalindrome: list = 1(2(3(4)3)2)1)0	len = 7
		isPalindrome: list = 2(3(4)3)2)1)0	len = 5
			isPalindrome: list = 3(4)3)2)1)0	len = 3
				isPalindrome: list = 4)3)2)1)0	len = 1
				returns node 3b, true
			returns node 2b, true
		returns node 1b, true
	returns node 0b, true
returns null, true
*/