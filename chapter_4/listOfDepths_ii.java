/**
 * 4.3 List of Depths BFS Iterative Solution
 * Given a binary tree, design an algorithm which 
 * creates a linked list of all the nodes at each
 * depth (ex. if you have a tree with depth D, you'll
 * have D linked lists
 */

ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
	ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();

	LinkedList<TreeNode> list = new LinkedList<TreeNode>();
	if (root != null) {
		list.add(root);
	}
	while (list.size() > 0) {
		lists.add(list);
		LinkedList<TreeNode> parents = list;
		list = new LinkedList<TreeNode>();
		for (TreeNode parent : parents) {
			if(parent.left != null) {
				list.add(parent.left);
			}
			if (parent.right != null) {
				list.add(parent.right);
			}
		}
	}
	return lists;
}

