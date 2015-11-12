/**
 * 4.4 Check Balanced
 * Implement a function to check if a binary tree is balanced.
 * For the purposes of this question, a balanced tree is defined
 * to be a tree such that the heights of the two subtrees of any
 * node never differ by more than one
 */

int getHeight(TreeNode root) {
	if (root == null)	return 0;
	return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
}

boolean isBalanced(TreeNode root) {
	if (root == null)	return true;	// base case
	int heightDiff = getHeight(root.left) - getHeight(root.right);

	if (Math.abs(heightDiff) > 1)	
		return false;
	else 
		return isBalanced(root.left) && isBalanced(root.right);
}

/**
 * For each node, compute heights of each subtree
 * getHeight calls repeatedly on the same nodes
 * O(N log N)
 */