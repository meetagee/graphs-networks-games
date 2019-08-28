package ca.ubc.ece.cpen221.mp2.graph;

import ca.ubc.ece.cpen221.mp2.core.Graph;
import ca.ubc.ece.cpen221.mp2.core.Vertex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;
import java.util.LinkedList;

/******************************************************************************
 *  Dependencies: Graph.java Vertex.java
 *
 *  A data type that represents a Graph using Adjacency Lists.
 *
 ******************************************************************************/

public class AdjacencyListGraph implements Graph {
    // This class should implement the Graph interface

    // Rep invariant:
    //     adjacencyList is not null.
    //     Vertex in must not be null; should not exist duplicate vertices.
    //     A vertex is not a neighbor of itself.

    // Abstraction function:
    //     Represents an unweighted, undirected graph.
    //     through a representation of a adjacency list.

    private HashMap<Vertex, ArrayList<Vertex>> adjacencyList  = new HashMap<>();
    // Using a HashMap which contains a key as the Vertex, LinkedList of all the adjacent vertices

    /**
     * Adds a vertex to the graph
     *
     * Precondition: Vertex v is not already a vertex in the graph
     */
    @Override
    public void addVertex(Vertex v) {
        adjacencyList.put(v, new ArrayList<>()); //putting v into key, a new LinkedList into value for later use
    }

    /**
     * Adds an edge between v1 and v2.
     *
     * Precondition: v1 and v2 are vertices in the graph
     * Precondition: there hasn't been an existing edge between v1 and v2
     */
    @Override
    public void addEdge(Vertex v1, Vertex v2) {
        adjacencyList.get(v1).add(v2); //put v2 into the LinkedList of key v1.
        adjacencyList.get(v2).add(v1); //put v1 into the LinkedList of key v2.
    }

    /**
     * Check if there is an edge from v1 to v2.
     *
     * Precondition: v1 and v2 are vertices in the graph
     *
     * Postcondition: return true iff there is an existing edge between v1 and v2
     */
    @Override
    public boolean edgeExists(Vertex v1, Vertex v2) {
        return adjacencyList.get(v1).contains(v2); //checking if the list of adjacent vertices contains v2
    }

    /**
     * Get an array list containing all vertices adjacent to v.
     *
     * Precondition: v is a vertex in the graph
     *
     * Postcondition: returns a list containing each vertex w such that there is
     * an edge from v to w. The size of the list must be as small as possible
     * (No trailing null elements).
     * Returns a list of vertices adjacent to v, or size zero iff v has no
     * downstream neighbors.
     */
    @Override
    public List<Vertex> getNeighbors(Vertex v) {
        ArrayList<Vertex> neighborsList = new ArrayList<>();
        neighborsList =  adjacencyList.get(v);
        Collections.sort(neighborsList, Comparator.comparing(Vertex::getLabel));
        return neighborsList; //getting the list of all adjacent vertices of vertex v
    }

    /**
     * Get all vertices in the graph.
     *
     * Postcondition: returns a list containing all vertices in the graph,
     * sorted by label in non-descending order.
     * Returns a list of size 0 iff the graph has no vertices.
     */
    @Override
    public List<Vertex> getVertices() {
        List<Vertex> verticesList = new LinkedList<>(adjacencyList.keySet()); //getting the key set of adjacencyList i.e, a list of all vertices
        Collections.sort(verticesList, Comparator.comparing(Vertex::getLabel));
        return verticesList;
    }
}