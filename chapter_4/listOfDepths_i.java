/**
 * 4.3 List of Depths DFS Solution
 * Given a binary tree, design an algorithm which 
 * creates a linked list of all the nodes at each
 * depth (ex. if you have a tree with depth D, you'll
 * have D linked lists
 */

void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
	if (root == null)	return;		// base case

	LinkedList<TreeNode> list = null;
	if (lists.size() == level){
		lists.add(list);
	}
	else {
		list = lists.get(level);
	}
	list.add(root);
	createLevelLinkedList(root.left, lists, level+1);
	createLevelLinkedList(lists, root.right, level+1);
}

ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
	ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
	createLevelLinkedList(root, lists, 0);
	return lists;
}