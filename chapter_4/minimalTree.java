/**
 * 4.2 Minimal Tree
 * Given a sorted (increasing order) array with unique 
 * integer elements, write an algorithm to create a 
 * binary search tree with minimal height
 */

TreeNode createMinimalBST(int array[]) {
	return createMinimalBST(array, 0, array.length - 1);
}

TreeNode createMinimalBST(int arr[], int start, int end) {
	if (end < start)	return null;
	int mid = (start + end) / 2;
	TreeNode n = new TreeNode(arr[mid]);
	n.left = createMinimalBST(arr, start, mid-1);
	n.right = createMinimalBST(arr, mid+1, end);
	return n;
}

/**
 * Insert into the tree the middle element of the array
 * Insert (into the left subtree) the left subarray elements
 * 		assign n.left
 * Insert (into the right subtree) the right subarray elements
 * 		assign n.right
 * return the root treenode 
 */