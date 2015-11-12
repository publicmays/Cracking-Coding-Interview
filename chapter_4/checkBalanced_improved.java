/**
 * 4.4 Check Balanced
 * Implement a function to check if a binary tree is balanced.
 * For the purposes of this question, a balanced tree is defined
 * to be a tree such that the heights of the two subtrees of any
 * node never differ by more than one
 */

int checkHeight(TreeNode root) {
	if (root == null)	return 0;

	int leftHeight = checkHeight(root.left);
	int rightHeight = checkHeight(root.right);
	int heightDiff = leftHeight - rightHeight;

	if (leftHeight == -1)			return -1;
	if (rightHeight == -1) 			return -1;
	if (Math.abs(heightDiff) > 1)	return -1;
	else
		return Math.max(leftHeight, rightHeight) + 1;
}

boolean isBalanced(TreeNode root) {
	return checkHeight(root) != -1; 
}
/**
 * O(N) time
 * O(H) space
 * H - height of tree
 * Get height can check if tree is balanced as same time it's checking heights
 * when subtree isn't balanced return -1
 * check height of each subtree as we recurse down from the root
 * on each node we recursively get the heights of the left and right subtrees
 * through the checkHeight method
 * if the subtree is balanced, then checkHeight will return the actual height of the subtree
 * if the subtree is not balanced, checkHeight will return -1
 * break and return -1 from current call
 */