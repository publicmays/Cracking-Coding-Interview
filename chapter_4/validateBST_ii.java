/**
 * 4.5 Validate BST
 * Implement a function to check if a binary tree is a binary search tree
 */

Integer last_printed = null;
boolean checkBST(TreeNode n) {
	return checkBST(n, null, null);
}

boolean checkBST(TreeNode n, Integer min, Integer max) {
	if (n == null)		return true;

	if ((min != null && n.data <= min) || (max != null && n.data > max))
		return false;
	if (!checkBST(n.left, min, n.data) || !checkBST(n.right, n.data, max))
		return false;
	return true;
}
/**
 * Min / Max Solution
 * Time O(N) - any algorithm must touch n nodes
 * Space (O log N)	- recursive calls on stack since you recurse up the depth of the tree
 * N = # of nodes
 * 	    20
 *	   /  \
 *	  10   30
 *    / \
 *   5	 15
 *  / \		\
 * 3   7	 17
 * 
 * Left
 * checkBST(null, null, 3) - true					
 * checkBST(3, null, 5)							checkBST(7, 5, null)						
 *		3 > 5 - not false								7 <= 5 - not false	
 * checkBST(5, null, 10)						checkBST(15, 10, null)
 *		5 > 10 - not false								15 <= 10 - not false
 * 																	checkBST(17, 15, null)
 *																			17 <= 15 - not false
 * checkBST(10, null, 20)						checkBST(30, 20, null)
 * 		10 > 20 - not false								30 <= 20 - not false
 *
 *
 * Right
 * checkBST(null, 30, null) - true
 * checkBST(30, 20, null)
 * 30 <= 20 - not false	
 */