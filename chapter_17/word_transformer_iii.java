/**
 * 17.22 Word Transformer - Most Optimal
 * Input : DAMP, LIKE
 * Output : DAMP -> LAMP -> LIMP -> LIME -> LIKE
 */

LinkedList<String> transform (String startWord, String stopWord, String[] words) {
	HashMapList<String, String> wildcardToWordList = getWilcardToWordList(words);

	BFSData sourceData = new BFSData(startWord);
	BFSData destData = new BFSData(stopWord);

	while (!sourceData.isFinished() && !destData.isFinished()) {
		// search out from source
		String collision = searchLevel(wildcardToWordList, sourceData, destData);
		if (collision)
			return mergePaths(sourceData, destData, collision);
		// search out from destination
		collision = searchLevel(wildcardToWordList, destData, sourceData);
		if (collision)
			return mergePaths(sourceData, destData, collision);
	}
	return null;
}
// search 1 level and return collision if any
String searchLevel(HashMapList<String, String> wildcardToWordList, BFSData primary, BFSData secondary) {
	// we only want to search 1 level at a time, count how many nodes are currently in the primary's level
	// and only do that many nodes. We'll continue to add nodes to the end
	int count = primary.toVisit.size();
	for (int i = 0; i < count; ++i) {
		// pull out first node
		PathNode pathNode = primary.toVisit.pull();
		String word = pathNode.getWord();

		if (secondary.visited.containsKey(word))
			return pathNode.getWord();

		// add friends to the queue
		ArrayList<String> words = getValidLinkedWords(word, wildcardToWordList);
		for (String w : words) {
			if (!primary.visited.containsKey(w)) {
				PathNode next = new PathNode(w, pathNode);
				primary.visited.put(w, next);
				primary.toVisit.add(next);
			}
		}
	}
	return null;
}

LinkedList<String> mergePaths(BFSData bfs1, BFSData bfs2, String connection) {
	PathNode end1 = bfs1.visited.get(connection);	// end1 -> source
	PathNode end2 = bfs2.visited.get(connection);	// end2 -> dest
	LinkedList<String> pathOne = end1.collapse(false);	// forward
	LinkedList<String> pathTwo = end2.collapse(true);	// reverse
	pathTwo.removeFirst();		// remove connection
	pathOne.addAll(pathTwo);	// add second path
	return pathOne;
}

public class BFSData {
	public Queue<PathNode> toVisit = new LinkedList<PathNode>();
	public HashMap<String, PathNode> visited = new HashMap<String, PathNode>();

	public BFSData(String root) {
		PathNode sourcePath = new PathNode(root, null);
		toVisit.add(sourcePath);
		visited.put(root, sourcePath);
	}
	public boolean isFinished() {
		return toVisit.isEmpty();
	}
}

public class PathNode {
	private String word = null;
	private PathNode previousNode = null;
	public PathNode(String word, PathNode previous) {
		this.word = word;
		this.previousNode = previous;
	}
	public String getWord() {
		return word;
	}
}

// traverse path and return linked list of nodes
public LinkedList<String> collapse (boolean startsWithRoot) {
	LinkedList path = new LinkedList<String>();
	PathNode node = this;
	while (node) {
		if (startsWithRoot)
			path.addLast(node.word);
		else 
			path.addFirst(node.word);
		node = node.previousNode;
	}
	return path;
}

/**
 * O(E^ (D/2) ) - D - source and destination, E words 
 */