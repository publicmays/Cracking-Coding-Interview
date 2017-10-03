/* kth smallest element in BST
Method 1: Using Inorder traversal */

/* traverse down left extreme */
while (root is valid)
	stack.push(root)
	root = root.left

/* process other nodes */
while (node = stack.pop() is valid)
	stop if sufficient number of elements are popped
	if (node.right is valid)
		node = node.right
		while (node is valid)
			stack.push(node)
			node = node.left

/*
Inorder traversal of BST retrieves elements of tree in the sorted order. 
The inorder traversal uses stack to store to be explored nodes of tree 
(threaded tree avoids stack and recursion for traversal, see this post). The idea is to keep track of popped elements which participate in the order statics. Hypothetical algorithm is provided below,
Time complexity: O(n) where n is total nodes in tree..
*/

