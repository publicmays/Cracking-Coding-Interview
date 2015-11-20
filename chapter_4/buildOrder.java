/**
 * 4.7 Build Order - solution 1
 * You are given a list of projects and a list of dependencies 
 * (which is a list of pairs of projects, where the 1st project is
 * dependent on the 2nd project. All of a project's dependencies
 * must be built before the project is. Find a build order that will allow
 * the projects to be built.
 * If there is no valid build order, return an error
 * Example :
 * 		INPUT
 *			projects : a, b, c, d, e, f
 * 			dependencies : (d,a), (b,f), (d,b), (a,f), (c,d)
 *		OUTPUT : f, e, a b, d, c
 */
Project[] findBuildOrder(String[] projects, String[][] dependencies) {
	Graph graph = buildGraph(projects, dependencies);
	return orderProjects(graph.getNodes());
}

Graph buildGraph(String[] projects, String[][] dependencies) {
	Graph graph = new Graph();
	for (String project : projects)
		graph.createNode(project);
	for (String[] dependency : dependencies) 
		graph.addEdge(dependency[0], dependency[1]);
	return graph;
}

Project[] orderProjects(ArrayList<Project> projects) {
	Project[] order = new Project[projects.size()];
	int endOfList = addNonDependent(order, projects, 0);
	int toBeProcessed = 0;
	while(toBeProcessed < order.length) {
		Project current = order[toBeProcessed];

		if (current == null)	return null;		// circular dependency, no remaining projects w/ 0 dependencies

		ArrayList<Project> children = current.getChildren();		// remove myself as dependency
		for (Project child : children)
			child.decrementDependencies();

		endOfList = addNonDependent(order, children, endOfList);	// add children that have no one depending on them
		++toBeProcessed;
	}
	return order;
}

/* insert projects w/ 0 dependencies into the order array */
int addNonDependent(Project[] order, ArrayList<Project> projects, int offset) {
	for(Project project : projects)
		if (project.getNumberDependencies() == 0)
			order[offset] = project; ++offset;
	return offset;
}

public class Graph {
	private ArrayList<Project> nodes = new ArrayList<Project>();
	private HashMap<String, Project> map = new HashMap<String, Project>();

	public Project getOrCreateNode(String name) {
		if(!map.containsKey(name)) {
			Project node = new Project(node);
			nodes.add(node);
			map.put(name, node);
		}
		return map.get(name);
	}

	public void addEdge(String startName, String endName) {
		Project start = getOrCreateNode(startName);
		Project end = getOrCreateNode(endName);
		start.addNeighbor(end);
	}

	public ArrayList<Project> getNodes() {	return nodes;	}
}

public class Project {
	private ArrayList<Project> children = new ArrayList<Project>();
	private HashMap<String, Project> map = new HashMap<String, Project>();
	private String name;
	private int dependencies = 0;

	public Project(String n) {	name = n;	}
	public void addNeighbor(Project node) {
		if(!map.containsKey(node.getName())) {
			children.add(node);
			node.incrementDependencies();
		}
	}

	public void incrementDependencies() {	++dependencies;	 }
	public void decrementDependencies() {	--dependencies;	 }
	public String getName() {	return name;	}
	public ArrayList<Project> getChildren() {	return children;	}
	public int getNumberDependencies() {	return dependencies;	}

}
/**
 * O(P+D) time (P - projects, D - dependencies)
 * Nodes with no incoming edges can be built immediately
 *
 *    f
 *  / | \		d
 * c  |  b 	    |
 *  \ | /|		g	
 *    a  |
 *    |  /
 *    | /
 *    e
 *
 * 1. Add the nodes with no incoming edges. 
 *	  If the set of projects can b ebuilt, there must be some "first" project,
 *	  and that project can't have any dependencies. If a project has no dependencies
 * 	  (incoming edges), then we can't break anything by building it first
 *
 * 2. We removed all outgoing edges from these roots. Once those root projects were built
 *	  it doesn't matter if another project depends on them.
 *
 * 3. We found nodes that now have no incoming edges. Using the same logic from steps 1 and 2
 *	  It's okay to build these, find nodes with no dependencies, add them to build order
 * 	  remove their outgoing edges, and repeat
 *
 * 4. What if there are nodes remaining, but all have dependencies (incoming edges)? 
 *	  This means there's no way to build the system. We should return an error
 * 
 *  
 * 1. Build a graph where each project is a node and its outgoing edges 
 * represent the projects that depend on it. That is, if A has an edge to B
 * (A->B), it means B has a dependency on A and therefore A must be built before B.
 * Each node also tracks the # of incoming edges
 * 
 * 2. Initialize a buildOrder array. Once we determine a project's build order, we add it to the array.
 * We also continue to iterate through the array, using a toBeProcessed pointer to 
 * point to the next node to be fully processed.
 * 
 * 3. Find all the nodes with 0 incoming edges and add them to a buildOrder array. 
 * Set a toBeProcessed pointer to the beginning of the array.
 * 
 * Repeat until toBeProcessed is at the end of the buildOrder
 * 
 * 1. Read node toBeProcessed.
 *  >> If node == null, then all remaining nodes have a dependency and we have detected a cycle
 * 2. For each child of node:
 *  >> decrement child.dependencies (# of incoming edges)
 *  >> if child.dependencies is 0, add child to end of buildOrder
 *
 */


