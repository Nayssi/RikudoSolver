import java.util.ArrayList;
import java.util.HashSet;

public class Graph {
	private int nbVertices;
	private ArrayList<ArrayList<Integer>> adjacencyList;
	
	public static Graph completeGraph (int n) {
		Graph g = new Graph ();
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<> ();
		for (int i = 0; i < n; i++) {
			adjList.add (new ArrayList<> ());
			for (int j = 0; j < n; j++) {
				if (j != i) adjList.get (i).add (j);
			}
		}
		g.nbVertices = n;
		g.adjacencyList = adjList;
		return g;
	}
	
	public static Graph cycleGraph (int n) {
		Graph g = new Graph ();
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<> ();
		for (int i = 0; i < n; i++) {
			adjList.add (new ArrayList<> ());
			adjList.get (i).add((i+1) % n);
		}
		g.nbVertices = n;
		g.adjacencyList = adjList;
		return g;
	}
	
	public boolean isHamiltonianPath (int[] path) {
		if (path.length != nbVertices) return false;
		HashSet<Integer> auxSet = new HashSet<> ();
		for (int i : path) auxSet.add(i);
		if (auxSet.size () < nbVertices) return false;
		for (int i = 0; i < nbVertices; i++) {
			if (!adjacencyList.get (path[i]).contains (path[(i+1) % nbVertices])) return false;
		}
		return true;
	}
	
	public int getNbVertices() {
		return nbVertices;
	}

	public void setNbVertices(int nbVertices) {
		this.nbVertices = nbVertices;
	}

	public ArrayList<ArrayList<Integer>> getAdjacencyList() {
		return adjacencyList;
	}

	public void setAdjacencyList(ArrayList<ArrayList<Integer>> adjacencyList) {
		this.adjacencyList = adjacencyList;
	}
}
