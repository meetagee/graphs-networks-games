package ca.ubc.ece.cpen221.mp2.graph;

import ca.ubc.ece.cpen221.mp2.core.Graph;
import ca.ubc.ece.cpen221.mp2.core.Vertex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;

/******************************************************************************
 *  Dependencies: Graph.java Vertex.java
 *
 *  A data type that represents a Graph using Adjacency Matrices.
 *
 ******************************************************************************/

public class AdjacencyMatrixGraph implements Graph {
    // This class should implement the Graph interface

    // Rep invariant:
    //     adjacencyMatrix is not null.
    //     Vertex in must not be null; should not exist duplicate vertices.
    //     A vertex is not a neighbor of itself.

    // Abstraction function:
    //     Represents an unweighted, undirected graph.
    //     through a representation of a adjacency matrix.

    private HashMap<ArrayList<Vertex>, Integer> adjacencyMatrix = new HashMap<>();

    /**
     * Adds a vertex to the graph
     *
     * Precondition: Vertex v is not already a vertex in the graph
     */
    @Override
    public void addVertex(Vertex v) {
        List<Vertex> verticesList = getVertices();

        for(int j = 0; j < verticesList.size(); j++) { //populating data for the matrix
            adjacencyMatrix.put(new ArrayList<>(Arrays.asList(v,verticesList.get(j))),0); //matrix always has 2 opposite pair of value
            adjacencyMatrix.put(new ArrayList<>(Arrays.asList(verticesList.get(j),v)),0);
        }
        adjacencyMatrix.put(new ArrayList<>(Arrays.asList(v,v)),0); //matrix always has a pair of value which is (v,v)
    }

    /**
     * Adds an edge between v1 and v2.
     *
     * Precondition: v1 and v2 are vertices in the graph
     * Precondition: there hasn't been an existing edge between v1 and v2
     */
    @Override
    public void addEdge(Vertex v1, Vertex v2) {
        for(ArrayList<Vertex> key : adjacencyMatrix.keySet()) {
            if(key.contains(v1) && key.contains(v2)) { //find if a key of adjacencyMatrix (which is a list) contains both v1 and v2
                adjacencyMatrix.put(key,1); //then set its value to 1 (which means that there's an edge)
            }
        }
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
        for(ArrayList<Vertex> key : adjacencyMatrix.keySet()) { //iterate the matrix
            if(key.contains(v1) && key.contains(v2)) { //find the pair which contains both v1 and v2
                if (adjacencyMatrix.get(key) == 1) { return true; } //checking if value of the pair is 1 or not
            }
        }
        return false;
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

        for(ArrayList<Vertex> key : adjacencyMatrix.keySet()) { //iterate the matrix
            if(key.contains(v) && adjacencyMatrix.get(key) == 1) { //checking if there's a pair in which contains v and has the value of 1
                for(int i = 0; i < key.size(); i++) {
                    if(!(key.get(i).equals(v)) && !(neighborsList.contains(key.get(i)))) { neighborsList.add(key.get(i)); } //getting the other vertex and add to the list
                }
            }
        }
        Collections.sort(neighborsList, Comparator.comparing(Vertex::getLabel));
        return neighborsList;
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
        ArrayList<Vertex> verticesList = new ArrayList<>();

        for(ArrayList<Vertex> key : adjacencyMatrix.keySet()) { //populating data for the verticesList
            for(int i = 0; i < key.size(); i++) {
                if(!(verticesList.contains(key.get(i)))) {
                    verticesList.add(key.get(i));
                }
            }
        }
        Collections.sort(verticesList, Comparator.comparing(Vertex::getLabel));
        return verticesList;
    }

}