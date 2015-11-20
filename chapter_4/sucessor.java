/**
 * 4.6 Successor
 * Write an algorithm to find the next node 
 * (in-order sucessor) of a given node in a binary search tree. 
 * You may assume that each node has a link to its parent
 */

TreeNode inorderSucc(TreeNode n) {
	if (n == null)				return null;

	if (n.right != null)		return leftMostChild(n.right);
	else {
		TreeNode _n = n;
		TreeNode parent = _n.parent;

		while (parent != null && parent.left != _n) {
			_n = parent;
			parent = parent.parent;
		}
		return parent;
	}
}

TreeNode leftMostChild(TreeNode n) {
	if (n == null)	return null;

	while (n.left != null)
		n = n.left
	return n;
}
/**
 * Pseudocode
 * 
 * Node inorderSucc(Node n) {
 * 	if (n has a right subtree)		return leftmost child of right subtree
 * 	else
 * 		while n is a right child of n.parent
 * 			n = n.parent 		// go up
 * 		return n.parent			// parent hasn't been traversed
 *  
 * }
 */

