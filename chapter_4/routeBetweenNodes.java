/**
 * 4.1 - Route Between Nodes
 * BFS
 * Given a directed graph, design an algorithm 
 * to find out whether there is a route between two nodes
 */

enum State { Unvisited, Visting, Visited; }

boolean search(Graph g, Node start, Node end) {
	if (start == end)	return true;

	LinkedList<Node> queue = new LinkedList<Node>();

	for (Node u : g.getNodes()) 
		u.state = State.Unvisited;

	start.state = State.Visiting;
	queue.add(start);

	Node u;
	while (!queue.isEmpty()) {
		u = queue.removeFirst();
		for (Node v : u.getAdjacent()) {
			if (v.state == Unvisited) {
				if(v == end)	return true;
				else {
					v.state = State.Visiting;
					queue.add(v);
				}
			}

		}
		u.state = State.Visited;
	}
	return false;
}

/** 
 * create a queue
 * initialize entire graph to unvisited state
 * change startNode state to visiting
 * add startNode to queue
 * while queue isn't empty go through all nodes
 * set uNode to the root and remove root from graph
 * for every adjacent node in uNode
 * 		visit uNodes neighbors
 *		check if it's the end node, if it is a path exists
 *		else mark these neighbors as visiting and add them to queue
 * finished searching all uNodes neighbors, mark uNode as visited
 * move onto next node in queue
*/