/**
 * First Common Ancestor - Optimized
 * (Best Worst-Case Runtime)
 * Design an algorithm and write code to find the 
 * 1st common ancestor of 2 nodes in a binary tree
 * Avoid storing additional nodes in a data structure.
 * Note : this is not necessarily a binary search tree
 */

class Result {
	public TreeNode node;
	public boolean isAncestor;
	public Result(TreeNode n boolean isAnc) {
		node = n;
		isAncestor = isAnc;
	}
}
TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	Result r = commonAncestorHelper(root, p, q);
	if (r.isAncestor)	return r.node;
	return null;
}

Result commonAncestorHelper(TreeNode root, TreeNode p, TreeNode q) {
	if (root == null)	return new Result(null, false);
	if (root == p && root == q)	return new Result(root, true);
	// 15, rx = (3, false) | ry = (null, false)
	Result rx = commonAncestorHelper(root.left, p, q);
	Result ry = commonAncestorHelper(root.right, p, q);
	if (rx.isAncestor)	return rx;
	if (ry.isAncestor)	return ry;

	if(rx.node != null && ry.node != null) 
		return new Result(root, true);
	
	else if (root == p || root == q) {
		boolean isAncestor = rx.node != null || ry.node != null;
		return new Result(root, isAncestor);
	}
	else 
		return new Result(rx.node != null ? rx.node : ry.node, false);
}
/**
 * recurse through the entire tree
 * commonAncestor(TreeNode root, TreeNode p, TreeNode q) 
 * 	returns p if root's subtree includes p (and not q)
 * 	returns q if root's subtree includes q (and not p)
 * 	else returns the common ancestor of p and q)
 *
 * 	    20
 *	   /  \
 *	  10   30
 *    / \
 *   5	 15
 *  / \		\
 * 3   7	 17
 *
 *
 *
 * commonAncestorHelper(20, 3, 17)
 * rx = (10, 3, 17)
 * ry = (30, 3, 17)
 *
 *CAH(20, 3, 17) => return rx;
 *{
 *	rx = CAH(10, 3, 17) => Result(10, true)
 *	{
 *		rx = CAH(5, 3, 17) => Result(3, false)
 *		{
 *			rx = CAH(3, 3, 17) => Result(3, false)
 *			{
 *				1. rx = CAH(null, 3, 17)	ry = CAH(null, 3, 17)
 *					null					null	
 *			}
 *			ry = CAH(7, 3, 17) => Result(null, false)
 *			
 *		}
 *		ry = CAH(15, 3, 17) => Result(17, false)
 *		{
 *			rx = CAH(null, 3, 17)
 *				null
 *
 *			ry = CAH(17, 3, 17) => Result(17, false)
 *			{
 *				1.	rx = CAH(null, 3, 17)	ry = CAH(null, 3, 17)
 *					null					null
 *			}
 *
 *		}
 *	}
 *	ry = CAH(30, 3, 17) => Result(null, false)
 *	{
 *		rx = CAH(null, 3, 17)	ry = CAH(null, 3, 17)
 *			null					null
 *	}
 *}
 * rx = (10, 3, 5)
 * ry = (30, 3, 5)
 *
 *CAH(20, 3, 5) => return rx;
 *{
 *	rx = CAH(10, 3, 17) => return rx;
 *	{
 *		rx = CAH(5, 3, 17) => Result(5, true)
 *		{
 *			rx = CAH(3, 3, 17) => Result(3, false)
 *			{
 *				1. rx = CAH(null, 3, 17)	ry = CAH(null, 3, 17)
 *					null					null	
 *			}
 *			ry = CAH(7, 3, 17) => Result(null, false)
 *			
 *		}
 *
 *		ry = CAH(15, 3, 17)  => Result(null, false)
 *		{
 *			rx = CAH(null, 3, 17) => Result(null, false)
 *				null
 *
 *			ry = CAH(17, 3, 17) => Result(null, false)
 *			{
 *				1.	rx = CAH(null, 3, 17)	ry = CAH(null, 3, 17)
 *					null					null
 *			}
 *
 *		}
 *	}
 *
 */