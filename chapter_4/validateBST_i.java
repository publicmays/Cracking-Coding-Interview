/**
 * 4.5 Validate BST
 * Implement a function to check if a binary tree is a binary search tree
 */

int index = 0;
void copyBST(TreeNode root, int[] array) {
	if (root == null)	return;

	copyBST(root.left, array);
	array[index++] = root.data;
	copyBST(root.right, array);
}

boolean checkBST(TreeNode root) {
	int[] array = new int[root.size];
	copyBST(root, array);
	for (int i = 1; i < array.length; ++i) 
		if (array[i-1] > array[i])
			return false;
	return true;
}
/**
 * in-order traversal, copy elements into an array
 * check if array is sorted
 */