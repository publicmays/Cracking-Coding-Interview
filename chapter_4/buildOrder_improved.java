/**
 * 4.7 Build Order - solution DFS - topological sort
 * lienarly ordering the vertices in a graph such that for every edge (a,b)
 * a appears before b in the linear order
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
Stack<Project> findBuildOrder(String[] projets, String[][] dependencies) {
	Graph graph = buildGraph(projects, dependencies);
	return orderProjects(graph.getNodes());
}

Stack<Project> orderProjects(ArrayList<Project> projects) {
	Stack<Project> stack = new Stack<Project>();
	for (Project project : projects)
		if (project.getState() == Project.State.BLANK)
			if (!doDFS(project, stack))
				return null;
	return stack;
}

boolean doDFS(Project project, Stack<Project> stack) {
	if (project.getState() == Project.State.PARTIAL)	return false;	// cycle

	if (project.getState() == Project.State.BLANK) {
		project.setState(Project.State.PARTIAL);
		ArrayList<Project> children = project.getChildren();
		for (Project child : children)
			if (!doDFS(child, stack))
				return false;

		project.setState(Project.State.COMPLETE);
		stack.push(project);
	}
}

// same
Graph buildGraph(String[] projects, String[][] dependencies) {...}
public class Graph{}

public class Project {
	public enum State {COMPLETE, PARTIAL, BLANK};
	private State state = State.BLANK;
	public State getState() {	return state;	}
	public void setState(State st) {	state = st;		}
	// duplicate code removed for brevity
}

/**
 *
 * O(P + D) time
 *    f
 *  / | \		d
 * c  |  b 	    |
 *  \ | /|\		g	
 *    a  | h
 *    |  /
 *    | /
 *    e
 * Pick arbitrary node
 * 
 * DFS(b)
 * 	DFS(h)
 *		build order = ..., h
 *	DFS(a)
 *		DFS(e)
 *			build order = ..., e, h
 *		build order = ..., a, e, h
 *	DFS(e) -> return
 *	build order = ..., b, a, e, h
 *
 * DFS(b)
 *	DFS(g)
 * 		build order = ..., g, b, a, e, h
 * 	build order = ..., d, g, b, a, e, h
 * DFS(f)
 * 	DFS(c)
 *		build order = ..., c, d, g, b, a, e, h
 *	build order = f, c, d, g, b, a, e, h
 *
 */

