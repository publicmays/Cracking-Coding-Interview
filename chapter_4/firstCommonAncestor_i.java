/**
 * First Common Ancestor - Solution With Links to Parents
 * Design an algorithm and write code to find the 
 * 1st common ancestor of 2 nodes in a binary tree
 * Avoid storing additional nodes in a data structure.
 * Note : this is not necessarily a binary search tree
 */

TreeNode commonAncestor(TreeNode p, TreeNode q) {
	if (p == q)	return null;

	TreeNode ancestor = p;
	while (ancestor != null) {
		if (isOnPath(ancestor, q))
			return ancestor;
		ancestor = ancestor.parent;
	}
	return null;
}

boolean isOnPath(TreeNode ancestor, TreeNode node) {
	while (node != ancestor && node != null)
		node = node.parent;
	return node == ancestor; 
}
/**
 * isOnPath - O(d_q) - d_q is depth of d
 * worst case O((logN)^2) balanced tree
 * worst case O(N^2) unbalanced tree
 * Trace p's path upwards. At each node on this path, 
 * check to see if node is on the path from q to the root. 
 * The first node will be the first common ancestor
 */