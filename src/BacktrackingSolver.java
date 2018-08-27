import java.util.*;

public class BacktrackingSolver {

	public static Collection<List<Integer>> backtrackingSolve (Graph g, int source) {
		if (source > g.getNbVertices() || source < 0) throw new IllegalArgumentException (source + " not a valid source node");
		boolean[] visiting = new boolean[g.getNbVertices()];
		for (int i = 0; i < g.getNbVertices(); i++) {
			visiting[i] = false;
		}
		visiting[source] = true;
		Set<List<Integer>> hamiltonianPaths = new HashSet<> ();
		List<Integer> hamiltonianPath = new ArrayList<> ();
		hamiltonianPath.add (source);
		for (int children : g.getAdjacencyList ().get (source)) {
		    proceed (children, source, source, visiting, hamiltonianPath, hamiltonianPaths, g);
        }
		return hamiltonianPaths;
	}

    private static void proceed(int current, int father, int source, boolean[] visiting, List<Integer> hamiltonianPath, Set<List<Integer>> hamiltonianPaths, Graph g) {
	    if (visiting[current]) {
	        if (current == source && hamiltonianPath.size () == g.getNbVertices())
                hamiltonianPaths.add(new ArrayList<>(hamiltonianPath));
            return;
        }
        visiting[current] = true;
	    hamiltonianPath.add (current);
	    for (int child : g.getAdjacencyList ().get (current)) {
	        proceed (child, current, source, visiting, hamiltonianPath, hamiltonianPaths, g);
        }
	    hamiltonianPath.remove (hamiltonianPath.size () - 1);
	    visiting[current ] = false;
    }
}
