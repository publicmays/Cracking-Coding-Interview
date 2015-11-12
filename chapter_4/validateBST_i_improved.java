/**
 * 4.5 Validate BST
 * Implement a function to check if a binary tree is a binary search tree
 */

Integer last_printed = null;
boolean checkBST(TreeNode n) {
	if (n == null)			return true;
	if (!checkBST(n.left))	return false;
	if (last_printed != null && last_printed > n.data)		return false;
	if (!checkBST(n.right))	return false;

	return true;	// all good
}
/**
 * get rid of array
 * track last element and compare as you go
 * use Integer instead of int so we can know when last_printed has been set to a value
 */ 