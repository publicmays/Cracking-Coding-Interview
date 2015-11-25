/**
 * 4.9 - BST Sequences
 * This is not the solution from the book
 * A binary search tree was created by traversing through an array 
 * from left to right and inserting each element. Given a binary
 * search tree with distinct elements, print all possible arrays that
 * could have led to this tree
 */

LinkedList<LinkedList<TreeNode>> allSeq;

public bstSequences(TreeNode root) {
	LinkedList<TreeNode> visited = new LinkedList<>();
	LinkedList<TreeNode> possible = new LinkedList<>();

	bstHelper(root, visited, possible);
	print(allSeq);
}
private bstHelper(TreeNode root, LinkedList<TreeNode> visited, LinkedList<TreeNode> possible) {

	visited.add(root);

	if (root.left)	
		possible.add(root.left);
	if (root.right)	
		possible.add(root.right);
	if (possible.isEmpty())
		allSeq.add(visited);

	for (TreeNode pos : possible) {
		_visited = visited.clone();
		_possible = possible.clone();
		_possible.remove(pos);

		bstHelper(pos, _visited, _possible);
	}
}
private print(LinkedList<LinkedList<TreeNode>> allSeq) {
	for (LinkedList<TreeNode> linkedList : allSeq) 
		for (TreeNode node : linkedList)
			System.out.print(node.val + " ");
		System.out.println();
}

/**
 * visited - nodes already visited in the current sequence
 * possible - all of the possible next steps in the current sequence
 */