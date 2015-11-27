/**
 * 4.11 - Random Node
 * You are implementing a binary tree from scratch
 * implement insert, find, delete, getRandomNode()
 * which returns a random node from the tree. All nodes
 * should be equally likely to be chosen. Design and
 * implement an algorithm for getRandomNode
 * and explain how you would implement the rest of the methods
 */

class TreeNode {
	private int data;
	private int size = 0;
	public TreeNode left, right;

	public TreeNode(int data) {
		this.data = data;
		this.size = 1;
	}

	public TreeNode getRandomNode() {
		int leftSize = left == null ? 0 : left.size();
		Random random = new Random();
		int index = random.nextInt(size);
		if (index == leftSize)
			return this;
		else if (index < leftSize)
			return left.getRandomNode();
		else
			return right.getRandomNode();
	}

	public void insertInOrder(int d) {
		if (d <= data) 
			if (left)
				left.insertInOrder(d);
			else
				left = new TreeNode(d);
		
		else 
			if (right)
				right.insertInOrder(d);
			else
				right = new TreeNode(d);
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

	public int size() {	return size; }
	public int data() {	return data; }

}