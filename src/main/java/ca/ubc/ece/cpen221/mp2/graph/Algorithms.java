package ca.ubc.ece.cpen221.mp2.graph;

import ca.ubc.ece.cpen221.mp2.core.Graph;
import ca.ubc.ece.cpen221.mp2.core.Vertex;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Stack;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Comparator;


public class Algorithms {

	// Rep invariant
	//    List of vertices must not be modified

	// Abstraction Function
	//    Represents the methods that is implemented for the graph interface

	private static final int zero = 0;

	/** Finding the shortest distance between vertex a and vertex b
	 * @param graph: the graph implemented is unweighted
	 * @param a: the graph contains vertex a
	 * @param b: the graph contains vertex b
	 * @return the shortest distance traversed from a to b
	 */

	public static int shortestDistance(Graph graph, Vertex a, Vertex b) {
		ArrayList<Vertex> visitedVertices = new ArrayList<>();
		ArrayList<Vertex> neighbor;
		ArrayList<Vertex> verticesToCheck = new ArrayList<>();
		visitedVertices.add(a);
		verticesToCheck.add(a);
		int status = zero;
		int count = zero;
		if (b.equals(a)) {
			status = 1;
		}
		while(status == zero && verticesToCheck.size()!= zero) {
			neighbor = getNextNeighbor(verticesToCheck, visitedVertices, graph);
			for (int i = zero; i < neighbor.size(); i++) {
				if(!visitedVertices.contains(neighbor.get(i))) {
					visitedVertices.add(neighbor.get(i));
				}
				if(b.equals(neighbor.get(i))){
					status = 1;
					break;
				}
			}
			verticesToCheck = new ArrayList<>();
			for (int j = zero; j < neighbor.size(); j++){
				verticesToCheck.add(neighbor.get(j));
			}
			count++;

		}
		if(status == 1) {
			return count;
		}
		else{
			return Integer.MAX_VALUE;
		}
	}

	private static ArrayList<Vertex> getNextNeighbor(ArrayList<Vertex> toCheck,
													  ArrayList<Vertex> visitedVertices, Graph graph) {
		ArrayList<Vertex> neighbor = new ArrayList<>();
		for (int i = zero; i < toCheck.size(); i++) {
			List<Vertex> list = graph.getNeighbors(toCheck.get(i));
			for (int j = zero; j < list.size(); j++) {
				if (!visitedVertices.contains(list.get(j)))
					neighbor.add(list.get(j));
			}
		}
		return neighbor;
	}

	/**
	 * Perform a complete depth first search of the given
	 * graph. Start with the search at each vertex of the
	 * graph and create a list of the vertices visited.
	 * Return a set where each element of the set is a list
	 * of elements seen by starting a DFS at a specific
	 * vertex of the graph (the number of elements in the
	 * returned set should correspond to the number of graph
	 * vertices).
	 */

	/**Traversing all the vertices of the graph through depth first search
	 * @param graph: the graph implemented is unweighted
	 * @return a set of lists in which vertices were visited through depth first search.
	 * Each list in the set contains the connected vertices in which they were traversed
	 * through depth first search.
	 */

	public static Set<List<Vertex>> depthFirstSearch(Graph graph) {
		// TODO: Implement this method
		ArrayList<Vertex> isVisted = new ArrayList<>(); //ArrayList checking visted elements
		List<Vertex> vertices = graph.getVertices();
		Set<List<Vertex>> outSet = new HashSet<List<Vertex>>();

		for(int i = zero; i < vertices.size(); i++) {
			Stack<Vertex> tempStack = new Stack<>();
			ArrayList<Vertex> tempList = new ArrayList<>();
			tempStack.add(vertices.get(i)); //add origin of traversal
			isVisted.add(vertices.get(i)); //visited check
			while(!tempStack.isEmpty()) {
				Vertex element = tempStack.pop(); //remove current element from stack (LIFO)
				tempList.add(element); //add current element to the set containing current list
				List<Vertex> neighbors = graph.getNeighbors(element); //get neighbors of current element
				Collections.sort(neighbors, Comparator.comparing(Vertex::getLabel).reversed()); //sorting in reversed order as LIFO
				for(int j = zero; j < neighbors.size(); j++) { //get neighbors of current element
					Vertex n = neighbors.get(j);
					if(!isVisted.contains(n)) {
						tempStack.add(n);
						isVisted.add(n);
					}
				}
			}
			isVisted.clear();
			outSet.add(tempList);
		}
		return outSet;
	}

	/**
	 * Perform a complete breadth first search of the given
	 * graph. Start with the search at each vertex of the
	 * graph and create a list of the vertices visited.
	 * Return a set where each element of the set is a list
	 * of elements seen by starting a BFS at a specific
	 * vertex of the graph (the number of elements in the
	 * returned set should correspond to the number of graph
	 * vertices).
	 */


	/**Traversing all the vertices of the graph through breadth first search
	 * @param graph: the graph implemented is unweighted
	 * @return a set of lists in which vertices were visited through breadth first search.
	 * Each list in the set contains the connected vertices in which they were traversed
	 * through breadth first search.
	 */

	public static Set<List<Vertex>> breadthFirstSearch(Graph graph) {
		// TODO: Implement this method
		ArrayList<Vertex> isVisted = new ArrayList<>(); //ArrayList checking visted elements
		List<Vertex> vertices = graph.getVertices();
		Set<List<Vertex>> outSet = new HashSet<List<Vertex>>();

		for(int i = zero; i < vertices.size(); i++) { //iterating through all vertices to get all origins
			Queue<Vertex> tempQueue = new LinkedList<Vertex>();
			ArrayList<Vertex> tempList = new ArrayList<>();
			tempQueue.add(vertices.get(i)); //add origin of traversal
			isVisted.add(vertices.get(i)); //visited check
			while(!tempQueue.isEmpty()) {
				Vertex element = tempQueue.remove(); //remove current element from queue (FIFO)
				tempList.add(element); //add current element to the set containing current list
				List<Vertex> neighbors = graph.getNeighbors(element); //get neighbors of current element
				for(int j = zero; j < neighbors.size(); j++) {
					Vertex n = neighbors.get(j); //get all neighbors
					if(!isVisted.contains(n)) {
						tempQueue.add(n); //add to queue if not visited
						isVisted.add(n); //visited check
					}
				}
			}
			isVisted.clear(); //clearing visited checklist for next traversal
			outSet.add(tempList); //add the traversed list to output
		}
		return outSet;
	}

	/** Finding the center of the graph
	 * @param graph: the graph implemented is unweighted
	 * @return a vertex that has the lowest eccentricity (minimum distance
	 * needed to travers to its furthest connected vertex at the largest
	 * connected component of the graph
	 */

	 public static Vertex center(Graph graph) {

		 Vertex center = null;
		 List<Vertex> vertices = largestConnected(graph);
		 int maxLength = -1;
		 int tempMaxLength;
		 int minLength = Integer.MAX_VALUE;

		 for (Vertex x : vertices) {
		 	List<Vertex> copy = new ArrayList<>(largestConnected(graph));
		 	copy.remove(x);
		 	for (Vertex y : copy) {
		 		tempMaxLength = shortestDistance(graph, x, y);
		 		if (tempMaxLength != Integer.MAX_VALUE) {
		 			if (tempMaxLength > maxLength) {
		 				maxLength = tempMaxLength;
					}
				}
			}
			if (maxLength == -1) {
				continue;
			} else if (minLength > maxLength) {
				minLength = maxLength;
				center = x;
			}
			maxLength = -1;
		 }
		 return center;
	 }

	/**Finding the diameter of the graph
	 * @param graph: the graph implemented is unweighted
	 * @return the maximum length of the shortest distance to
	 * be traversed between each pair of vertices in the
	 * graph.
	 */

	public static int diameter(Graph graph) {
		List <Vertex> vertices = graph.getVertices();
		int maxLength = zero;
		int tempLength;
		if (vertices.size() == 1) {
			maxLength = zero;
		} else {

			for (int i = vertices.size() - 1; i >= zero; i--) {
				for (int j = i - 1; j >= zero; j--) {
					tempLength = shortestDistance(graph, vertices.get(i), vertices.get(j));
					if (tempLength == Integer.MAX_VALUE) {
						continue;
					} else {
						maxLength = Math.max(maxLength, tempLength);
					}
				}
			}
		}
		return maxLength;
	}

	private static List<Vertex> largestConnected (Graph graph) {
		List<Vertex> largestConnected = new ArrayList<>(zero);
		 ArrayList<Vertex> visitedVertices = new ArrayList<>();
		 List<Vertex> vertices = graph.getVertices();

		 for(int i = zero; i < vertices.size(); i++) {
			Queue<Vertex> queue = new LinkedList<>();
			ArrayList<Vertex> tempList = new ArrayList<>();
			queue.add(vertices.get(i));
			visitedVertices.add(vertices.get(i));
			while(!queue.isEmpty()) {
				Vertex element = queue.remove();
				tempList.add(element);
				List<Vertex> neighbors = graph.getNeighbors(element);
				for(int j = zero; j < neighbors.size(); j++) {
					Vertex n = neighbors.get(j);
					if(!visitedVertices.contains(n)) {
						queue.add(n);
						visitedVertices.add(n);
					}
				}
			}
			visitedVertices.clear();
			 if (tempList.size() > largestConnected.size()) {
				largestConnected = tempList;
			 }
		 }
		return largestConnected;
	}

}