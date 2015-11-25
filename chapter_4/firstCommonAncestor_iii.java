/**
 * First Common Ancestor - Solution Without Links to Parents 
 * (Best Worst-Case Runtime)
 * Design an algorithm and write code to find the 
 * 1st common ancestor of 2 nodes in a binary tree
 * Avoid storing additional nodes in a data structure.
 * Note : this is not necessarily a binary search tree
 */
TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	if (!covers(root, p) || !covers(root, q))	return null;
	return ancestorHelper(root, p, q);
}

TreeNode ancestorHelper(TreeNode root, TreeNode p, TreeNode q) {
	if (root == null)	return null;
	else if (root == p)	return p;
	else if (root == q)	return q;

	boolean pIsOnLeft = covers(root.left, p);
	boolean qIsOnLeft = covers(root.left, q);

	if (pIsOnLeft != qIsOnLeft)	return root;
	TreeNode childSide = pIsOnLeft ? root.left : root.right;
	return ancestorHelper(childSide, p, q);
}

boolean covers(TreeNode root, TreeNode q) {
	if (root == null)	return false;
	if (root == p)		return true;
	return covers(root.left, p) || covers(root.right, p);
}
/** 
 * O(n) time on balanced tree
 * covers is called on 2n nodes in the first call 
 * n nodes on left side, n nodes for right side
 * algorithm branches left or right
 * 2n/2 nodes then 2n/4 ... O(n)
 * Follow a chain in which p and q are on the same side
 * if p and q are both on the left of the node,
 * branch left to look for common ancestor
 * if they are both on the right, branch right to look for the 
 * common ancestor. When p and q are no longer on the same side, you
 * have fond the first common ancestor
 */