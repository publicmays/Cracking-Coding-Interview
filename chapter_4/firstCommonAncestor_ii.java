/**
 * First Common Ancestor - Solution With Links to Parents 
 * (Best Worst-Case Runtime)
 * Design an algorithm and write code to find the 
 * 1st common ancestor of 2 nodes in a binary tree
 * Avoid storing additional nodes in a data structure.
 * Note : this is not necessarily a binary search tree
 */
TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	if (!covers(root, p) || !covers(root, q))	return null;
	else if (covers(p,q))	return p;
	else if (covers(q,p))	return q;

	/* Traverse upwards until you find a node that covers p */
	TreeNode sibling = getSibling(p);
	TreeNode parent = p.parent;
	while (!covers(sibling, q)) {
		sibling = getSibling(parent);
		parent = parent.parent;
	}
	return parent;
}

boolean covers(TreeNode root, TreeNode p) {
	if (root == null)	return false;
	if (root == p)		return true;
	return covers(root.left, p) || covers(root.right, p);
}

TreeNode getSibling(TreeNode node) {
	if (node == null || node.parent == null)	return null;
	TreeNode parent = node.parent;
	return parent.left == node ? parent.right : parent.left;
}


/**
 * O(t) time - t size of subtree for 1st common ancestor
 * Worst case - O(n) - # nodes in tree
 * each node in subtree is searched once 
 */