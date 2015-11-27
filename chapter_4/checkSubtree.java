/**
 * 4.10 - Check subtree
 * T1 and T2 are very 2 large binary trees
 * with T1 much bigger than T2. Create an
 * alrogirhtm to determine if T2 is a subtree
 * of T1. A Tree T2 is a subtree of T1 if
 * there exists a node n in T1 such that the subtree
 * of n is identical to T2. That is, if you cut off the
 * tree at node n, the 2 trees would be identical.
 */

boolean containsTree(TreeNode t1, TreeNode t2) {
	if (t2 == null)	return true;
	return subTree(t1, t2);
}

boolean subTree(TreeNode r1, TreeNode r2) {
	if (r1 == null)	
		return false;
	else if (r1.data == r2.data && matchTree(r1, r2))
		return true;
	return subTree(r1.left, r2 || subTree(r1.right, r2));
}

boolean matchTree(TreeNode r1, TreeNode r2) {
	if (r2 == null && r1 == null)	
		return true;
	else if (r1 == null || r2 == null) 
		return false;
	else if (r1.data != r2.data)
		return false;
	else 
		return matchTree(r1.left, r2.left) && matchTree(r1.right, r2.right);
}

/**
 * n - # nodes T1
 * m - # nodes T2
 * we call matchTree k (# occurences of T2's root in T1)
 * Time - O(n + km)
 * Memory - O(log(n) + log(m))
 */