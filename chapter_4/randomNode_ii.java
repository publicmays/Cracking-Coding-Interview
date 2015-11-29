/**
 * 4.11 - Random Node
 * You are implementing a binary tree from scratch
 * implement insert, find, delete, getRandomNode()
 * which returns a random node from the tree. All nodes
 * should be equally likely to be chosen. Design and
 * implement an algorithm for getRandomNode
 * and explain how you would implement the rest of the methods
 */

class Tree {
	TreeNode root = null;
	public int size() {	return root == null ? 0 : root.size();	}
	public TreeNode getRandomNode() {
		if (root == null)	return null;
		Random random = new Random();
		int i = random.nextInt(size());
		return root.getIthNode(i);
	}
	public void insertInOrder(int value) {
		if (root == null)
			root = new TreeNode(value);
		else
			root.insertInOrder(value);
	}
}

class TreeNode {
	// constructor & var are the same
	public TreeNode getIthNode(int i) {
		int leftSize = left == null ? 0 : left.size();
		if (i == leftSize)
			return this;
		else if (i < leftSize)
			left.getIthNode(i);
		else
			return right.getIthNode(i - (leftSize+1));	// skipping over leftSize + 1 nodes, so subtract them
	}
	public void insertInOrder(int d) {
		if (d <= data)
			if (left == null)
				left = new TreeNode(d);
			else
				left.insertInOrder(d);
		else
			if (right == null)
				new TreeNode(d);
			else
				right.insertInOrder(d);
		++size;
	}
	public TreeNode find(int d) {
		if (d == data)
			return this;
		else if (d <= data)
			return left != null ? left.find(d) : null;
		else if (d > data)
			return right != null ? right.find(d) : null;
		return null;
	}
	
	public int size() {	return size;	}
	public int data() {	return data;	}
}

/**
 * balanced tree - Time O(logN)
 */