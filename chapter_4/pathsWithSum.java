/**
 * 4.12 - Paths with Sum
 * You are given a binary tree in which each node contains an integer value
 * which might be positive or negative. Design an algorithm to count the
 * number of paths that sum to a given value. The path does not need to start or
 * end at the root or a leaf, but it must go downwards (traveling only from parent
 * nodes to child nodes)
 */

int countPathWithSum(TreeNode root, int targetSum) {
	if (root == null)	return 0;
	HashMap<Integer, Integer> paths = new HashMap<Integer, Integer>();
	incrementHashTable(paths, 0, 1);	// needed if target path starts at root
	return countPathsWithSum(root, targetSum, 0, paths);
}

int countPathswithSum(TreeNode node, int targetSum, int runningSum, HashMap<Integer, Integer> paths) {
	if (node == null)	return 0;	// base case
	runningSum += node.data;
	incrementHashTable(paths, runningSum, 1);

	int sum = runningSum - targetSum;
	int totalPaths = paths.containsKey(sum) ? paths.get(sum) : 0;
	totalPaths += countPathsWithSum(node.left, targetSum, runningSum, paths);
	totalPaths += countPathsWithSum(node.right, targetSum, runningSum, paths);

	incrementHashTable(paths, runningSum, -1);	// remove runningSum
	return totalPaths;
}

void incrementHashTable(HashMap<Integer, Integer> hashTable, int key, int delta) {
	if (!hashTable.containsKey(key))
		hashTable.put(key, 0);
	hashTable.put(key, hashTable.get(key) + delta);
}

/**
 * O(N) - N is number of nodes in the tree
 * travel to each node just once doing O(1) work each time
 * Space complexity O(N) (minimal impact adds O(logN) because of recursion)
 */