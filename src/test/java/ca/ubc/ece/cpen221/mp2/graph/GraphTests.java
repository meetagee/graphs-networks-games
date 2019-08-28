package ca.ubc.ece.cpen221.mp2.graph;

import ca.ubc.ece.cpen221.mp2.core.Graph;
import ca.ubc.ece.cpen221.mp2.core.Vertex;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class GraphTests {

    /**Tests that implements the graph ADT
     *Each tests contains different shape and size
     * of the graph.
     * Tests one to eight implements the adjacency
     * matrix graph. Tests nine to 14 implements the
     * adjacency list graph.
     */

    @Test
    public void testAdjacencyMatrix1() {
        Graph g = new AdjacencyMatrixGraph();
        Vertex v1 = new Vertex("1", "a");
        Vertex v2 = new Vertex("2", "b");
        Vertex v3 = new Vertex ("3", "c");
        Vertex v9 = new Vertex ("9", "d");

        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v9);

        g.addEdge(v1, v2);
        g.addEdge(v2, v9);
        int shortestDistance = Algorithms.shortestDistance(g, v1, v9);
        assertEquals(shortestDistance, 2);
        assertEquals(Algorithms.diameter(g), 2);
        assertEquals(Algorithms.center(g), v2);
        assertEquals(g.edgeExists(v1, v2), true);
        System.out.println("Test 1");
        System.out.println("Vertices: "+ g.getVertices());
        System.out.println("Shortest Distance: " + shortestDistance);
        System.out.println("Diameter: " + Algorithms.diameter(g));
        System.out.println("Center: " + Algorithms.center(g));
        System.out.println("BFS: " + Algorithms.breadthFirstSearch(g));
        System.out.println("DFS: " + Algorithms.depthFirstSearch(g));
    }

    @Test
    public void testAdjacencyMatrix2() {
        Graph g = new AdjacencyMatrixGraph();
        Vertex v1 = new Vertex("1", "a");
        Vertex v2 = new Vertex("2", "b");
        Vertex v3 = new Vertex ("3", "c");
        Vertex v4 = new Vertex ("4", "d");
        Vertex v5 = new Vertex ("5", "e");
        Vertex v6 = new Vertex ("6", "f");
        Vertex v7 = new Vertex ("7", "g");
        Vertex v8 = new Vertex ("8", "h");
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);
        g.addVertex(v5);
        g.addVertex(v6);
        g.addVertex(v7);
        g.addVertex(v8);
        g.addEdge(v1, v2);
        g.addEdge(v2, v3);
        g.addEdge(v3, v4);
        g.addEdge(v2, v5);
        g.addEdge(v5, v6);
        g.addEdge(v6, v4);

        assertEquals(Algorithms.shortestDistance(g, v1, v4), 3);
        assertEquals(Algorithms.diameter(g), 3);
        assertEquals(Algorithms.center(g), v2);
        System.out.println("Test 2");
        System.out.println("Vertices: "+ g.getVertices());
        System.out.println("Shortest Distance: " + Algorithms.shortestDistance(g, v1, v4));
        System.out.println("Diameter: " + Algorithms.diameter(g));
        System.out.println("Center: " + Algorithms.center(g));
        System.out.println("BFS: " + Algorithms.breadthFirstSearch(g));
        System.out.println("DFS: " + Algorithms.depthFirstSearch(g));
    }

    @Test
    public void testAdjacencyMatrix3() {
        Graph g = new AdjacencyMatrixGraph();
        Vertex v1 = new Vertex("1", "a");
        Vertex v2 = new Vertex("2", "b");
        Vertex v3 = new Vertex ("3", "c");
        Vertex v4 = new Vertex ("4", "d");
        Vertex v5 = new Vertex ("5", "e");
        Vertex v6 = new Vertex ("6", "f");
        Vertex v7 = new Vertex ("7", "g");
        Vertex v8 = new Vertex ("8", "h");
        Vertex v9 = new Vertex ("9", "i");
        Vertex v10 = new Vertex ("10", "j");
        Vertex v11 = new Vertex ("11", "k");
        g.addVertex(v1); g.addVertex(v2); g.addVertex(v3); g.addVertex(v4); g.addVertex(v5); g.addVertex(v6);
        g.addVertex(v7); g.addVertex(v8); g.addVertex(v9); g.addVertex(v10); g.addVertex(v11);
        g.addEdge(v1, v2); g.addEdge(v2, v3); g.addEdge(v3, v4); g.addEdge(v4, v5); g.addEdge(v5, v1);
        g.addEdge(v1, v2); g.addEdge(v1, v6); g.addEdge(v1, v7); g.addEdge(v2, v7); g.addEdge(v2, v8);
        g.addEdge(v3, v8); g.addEdge(v3, v9); g.addEdge(v4, v9); g.addEdge(v4, v10); g.addEdge(v5, v10);
        g.addEdge(v5, v6); g.addEdge(v6, v7); g.addEdge(v7, v8); g.addEdge(v8, v9); g.addEdge(v9, v10);
        g.addEdge(v10, v6); g.addEdge(v1, v2); g.addEdge(v11, v6); g.addEdge(v11, v7); g.addEdge(v11, v8);
        g.addEdge(v11, v9); g.addEdge(v11, v10);

        assertEquals(Algorithms.shortestDistance(g, v1, v9), 3);
        assertEquals(Algorithms.diameter(g), 3);
        assertEquals(Algorithms.center(g), v11);
        System.out.println("Test 3");
        System.out.println("Vertices: "+ g.getVertices());
        System.out.println("Shortest Distance: " + Algorithms.shortestDistance(g, v1, v9));
        System.out.println("Diameter: " + Algorithms.diameter(g));
        System.out.println("Center: " + Algorithms.center(g));
        System.out.println("BFS: " + Algorithms.breadthFirstSearch(g));
        System.out.println("DFS: " + Algorithms.depthFirstSearch(g));
    }

    @Test
    public void testAdjacencyMatrix4() {
        Graph g = new AdjacencyMatrixGraph();
        Vertex v1 = new Vertex("1", "a");
        Vertex v2 = new Vertex("2", "b");
        Vertex v3 = new Vertex ("3", "c");
        Vertex v4 = new Vertex ("4", "d");
        Vertex v5 = new Vertex ("5", "e");
        Vertex v6 = new Vertex ("6", "f");
        Vertex v7 = new Vertex ("7", "g");
        Vertex v8 = new Vertex ("8", "h");
        Vertex v9 = new Vertex ("9", "i");
        Vertex v10 = new Vertex ("10", "j");
        Vertex v11 = new Vertex ("11", "k");
        g.addVertex(v1); g.addVertex(v2); g.addVertex(v3); g.addVertex(v4); g.addVertex(v5);
        g.addVertex(v6); g.addVertex(v7); g.addVertex(v8); g.addVertex(v9); g.addVertex(v10);
        g.addVertex(v11);

        assertEquals(Algorithms.shortestDistance(g, v1, v6), Integer.MAX_VALUE);
        assertEquals(Algorithms.diameter(g), 0);
        assertEquals(Algorithms.center(g), null);
        System.out.println("Test 4");
        System.out.println("Vertices: "+ g.getVertices());
        System.out.println("Shortest Distance: " + Algorithms.shortestDistance(g, v1, v6));
        System.out.println("Diameter: " + Algorithms.diameter(g));
        System.out.println("Center: " + Algorithms.center(g));
        System.out.println("BFS: " + Algorithms.breadthFirstSearch(g));
        System.out.println("DFS: " + Algorithms.depthFirstSearch(g));
    }

    @Test
    public void testAdjacencyMatrix5() {
        Graph g = new AdjacencyMatrixGraph();
        Vertex v1 = new Vertex("1", "a");
        g.addVertex(v1);

        assertEquals(Algorithms.shortestDistance(g, v1, v1), 0);
        assertEquals(Algorithms.diameter(g), 0);
        assertEquals(Algorithms.center(g), null);
        System.out.println("Test 5");
        System.out.println("Vertices: "+ g.getVertices());
        System.out.println("Shortest Distance: " + Algorithms.shortestDistance(g, v1, v1));
        System.out.println("Diameter: " + Algorithms.diameter(g));
        System.out.println("Center: " + Algorithms.center(g));
        System.out.println("BFS: " + Algorithms.breadthFirstSearch(g));
        System.out.println("DFS: " + Algorithms.depthFirstSearch(g));
    }

    @Test
    public void testAdjacencyMatrix6() {
        Graph g = new AdjacencyMatrixGraph();
        Vertex v1 = new Vertex("1", "a");
        Vertex v2 = new Vertex("2", "b");
        Vertex v3 = new Vertex ("3", "c");
        Vertex v4 = new Vertex ("4", "d");
        Vertex v5 = new Vertex ("5", "e");
        Vertex v6 = new Vertex ("6", "f");
        Vertex v7 = new Vertex ("7", "g");
        Vertex v8 = new Vertex ("8", "h");
        Vertex v9 = new Vertex ("9", "i");
        Vertex v10 = new Vertex ("10", "j");
        Vertex v11 = new Vertex ("11", "k");
        Vertex v12 = new Vertex ("12", "l");
        g.addVertex(v1); g.addVertex(v2); g.addVertex(v3); g.addVertex(v4); g.addVertex(v5); g.addVertex(v6);
        g.addVertex(v7); g.addVertex(v8); g.addVertex(v9); g.addVertex(v10); g.addVertex(v11); g.addVertex(v12);
        g.addEdge(v1, v2); g.addEdge(v2, v3); g.addEdge(v2, v4); g.addEdge(v2, v5); g.addEdge(v3, v6);
        g.addEdge(v5, v7); g.addEdge(v3, v7); g.addEdge(v3, v8); g.addEdge(v8, v9); g.addEdge(v10, v11);
        g.addEdge(v11, v12); g.addEdge(v12, v10);

        assertEquals(Algorithms.shortestDistance(g, v1, v9), 4);
        assertEquals(Algorithms.diameter(g), 4);
        assertEquals(Algorithms.center(g), v3);
        System.out.println("Test 6");
        System.out.println("Vertices: "+ g.getVertices());
        System.out.println("Shortest Distance: " + Algorithms.shortestDistance(g, v1, v9));
        System.out.println("Diameter: " + Algorithms.diameter(g));
        System.out.println("Center: " + Algorithms.center(g));
        System.out.println("BFS: " + Algorithms.breadthFirstSearch(g));
        System.out.println("DFS: " + Algorithms.depthFirstSearch(g));
    }

    @Test
    public void testAdjacencyMatrix7() {
        Graph g = new AdjacencyMatrixGraph();
        Vertex v1 = new Vertex("1", "a");
        Vertex v2 = new Vertex("2", "b");
        Vertex v3 = new Vertex ("3", "c");
        Vertex v4 = new Vertex ("4", "d");
        Vertex v5 = new Vertex ("5", "e");
        Vertex v6 = new Vertex ("6", "f");
        Vertex v7 = new Vertex ("7", "g");
        Vertex v8 = new Vertex ("8", "h");

        g.addVertex(v1); g.addVertex(v2); g.addVertex(v3); g.addVertex(v4); g.addVertex(v5); g.addVertex(v6);
        g.addVertex(v7); g.addVertex(v8);
        g.addEdge(v1, v2); g.addEdge(v2, v3); g.addEdge(v3, v4); g.addEdge(v4, v1); g.addEdge(v5, v6);
        g.addEdge(v6, v7); g.addEdge(v7, v8); g.addEdge(v8, v5);

        assertEquals(Algorithms.shortestDistance(g, v1, v5), Integer.MAX_VALUE);
        assertEquals(Algorithms.diameter(g), 2);
        assertEquals(Algorithms.center(g), v1);
        System.out.println("Test 7");
        System.out.println("Vertices: "+ g.getVertices());
        System.out.println("Shortest Distance: " + Algorithms.shortestDistance(g, v1, v5));
        System.out.println("Diameter: " + Algorithms.diameter(g));
        System.out.println("Center: " + Algorithms.center(g));
        System.out.println("BFS: " + Algorithms.breadthFirstSearch(g));
        System.out.println("DFS: " + Algorithms.depthFirstSearch(g));
    }

    @Test
    public void testAdjacencyMatrix8() {
        Graph g = new AdjacencyMatrixGraph();
        Vertex v1 = new Vertex("1", "a");
        Vertex v2 = new Vertex("2", "b");
        Vertex v3 = new Vertex ("3", "c");
        Vertex v4 = new Vertex ("4", "d");
        Vertex v5 = new Vertex ("5", "e");
        Vertex v6 = new Vertex ("6", "f");
        Vertex v7 = new Vertex ("7", "g");


        g.addVertex(v1); g.addVertex(v2); g.addVertex(v3); g.addVertex(v4); g.addVertex(v5); g.addVertex(v6);
        g.addVertex(v7); g.addEdge(v1, v2); g.addEdge(v2, v3); g.addEdge(v3, v4); g.addEdge(v5, v6); g.addEdge(v6, v7);

        assertEquals(Algorithms.shortestDistance(g, v4, v7), Integer.MAX_VALUE);
        assertEquals(Algorithms.diameter(g), 3);
        assertEquals(Algorithms.center(g), v2);
        System.out.println("Test 8");
        System.out.println("Vertices: "+ g.getVertices());
        System.out.println("Shortest Distance: " + Algorithms.shortestDistance(g, v4, v7));
        System.out.println("Diameter: " + Algorithms.diameter(g));
        System.out.println("Center: " + Algorithms.center(g));
        System.out.println("BFS: " + Algorithms.breadthFirstSearch(g));
        System.out.println("DFS: " + Algorithms.depthFirstSearch(g));
    }

    @Test
    public void testAdjacencyList1() {
        Graph g = new AdjacencyListGraph();
        Vertex v1 = new Vertex("1", "a");
        Vertex v2 = new Vertex("2", "b");
        Vertex v3 = new Vertex ("3", "c");
        Vertex v9 = new Vertex ("9", "d");

        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v9);

        g.addEdge(v1, v2);
        g.addEdge(v2, v3);
        int shortestDistance = Algorithms.shortestDistance(g, v1, v3);
        assertEquals(shortestDistance, 2);
        assertEquals(Algorithms.diameter(g), 2);
        assertEquals(Algorithms.center(g), v2);
        assertEquals(g.edgeExists(v1, v3), false);
        System.out.println("Test 1");
        System.out.println("Vertices: "+ g.getVertices());
        System.out.println("Shortest Distance: " + shortestDistance);
        System.out.println("Diameter: " + Algorithms.diameter(g));
        System.out.println("Center: " + Algorithms.center(g));
        System.out.println("BFS: " + Algorithms.breadthFirstSearch(g));
        System.out.println("DFS: " + Algorithms.depthFirstSearch(g));
        System.out.println("Neighbors of v1: " + g.getNeighbors(v1));
    }

    @Test
    public void testAdjacencyList2() {
        Graph g = new AdjacencyListGraph();
        Vertex v1 = new Vertex("1", "a");
        Vertex v2 = new Vertex("2", "b");
        Vertex v3 = new Vertex ("3", "c");
        Vertex v4 = new Vertex ("4", "d");
        Vertex v5 = new Vertex ("5", "e");
        Vertex v6 = new Vertex ("6", "f");
        Vertex v7 = new Vertex ("7", "g");

        g.addVertex(v1); g.addVertex(v2); g.addVertex(v3); g.addVertex(v4); g.addVertex(v5); g.addVertex(v6);
        g.addVertex(v7); g.addEdge(v1, v2); g.addEdge(v2, v3); g.addEdge(v3, v4); g.addEdge(v5, v6); g.addEdge(v6, v7);

        assertEquals(Algorithms.shortestDistance(g, v4, v1), 3);
        assertEquals(Algorithms.diameter(g), 3);
        assertEquals(Algorithms.center(g), v2);
        System.out.println("Test 2");
        System.out.println("Vertices: "+ g.getVertices());
        System.out.println("Shortest Distance: " + Algorithms.shortestDistance(g, v4, v7));
        System.out.println("Diameter: " + Algorithms.diameter(g));
        System.out.println("Center: " + Algorithms.center(g));
        System.out.println("BFS: " + Algorithms.breadthFirstSearch(g));
        System.out.println("DFS: " + Algorithms.depthFirstSearch(g));
    }

    @Test
    public void testAdjacencyList3() {
        Graph g = new AdjacencyListGraph();
        Vertex v1 = new Vertex("1", "a");
        Vertex v2 = new Vertex("2", "b");
        Vertex v3 = new Vertex ("3", "c");
        Vertex v4 = new Vertex ("4", "d");
        Vertex v5 = new Vertex ("5", "e");
        Vertex v6 = new Vertex ("6", "f");
        Vertex v7 = new Vertex ("7", "g");
        Vertex v8 = new Vertex ("8", "h");

        g.addVertex(v1); g.addVertex(v2); g.addVertex(v3); g.addVertex(v4); g.addVertex(v5); g.addVertex(v6);
        g.addVertex(v7); g.addVertex(v8);
        g.addEdge(v1, v2); g.addEdge(v2, v3); g.addEdge(v3, v4); g.addEdge(v4, v1); g.addEdge(v5, v6);
        g.addEdge(v6, v7); g.addEdge(v7, v8); g.addEdge(v8, v5);

        assertEquals(Algorithms.shortestDistance(g, v1, v7), Integer.MAX_VALUE);
        assertEquals(Algorithms.diameter(g), 2);
        assertEquals(Algorithms.center(g), v1);
        System.out.println("Test 3");
        System.out.println("Vertices: "+ g.getVertices());
        System.out.println("Shortest Distance: " + Algorithms.shortestDistance(g, v1, v5));
        System.out.println("Diameter: " + Algorithms.diameter(g));
        System.out.println("Center: " + Algorithms.center(g));
        System.out.println("BFS: " + Algorithms.breadthFirstSearch(g));
        System.out.println("DFS: " + Algorithms.depthFirstSearch(g));
    }

    @Test
    public void testAdjacencyList4() {
        Graph g = new AdjacencyListGraph();
        Vertex v1 = new Vertex("1", "a");
        Vertex v2 = new Vertex("2", "b");
        Vertex v3 = new Vertex ("3", "c");
        Vertex v4 = new Vertex ("4", "d");
        Vertex v5 = new Vertex ("5", "e");
        Vertex v6 = new Vertex ("6", "f");
        Vertex v7 = new Vertex ("7", "g");
        Vertex v8 = new Vertex ("8", "h");
        Vertex v9 = new Vertex ("9", "i");
        Vertex v10 = new Vertex ("10", "j");
        Vertex v11 = new Vertex ("11", "k");
        Vertex v12 = new Vertex ("12", "l");
        g.addVertex(v1); g.addVertex(v2); g.addVertex(v3); g.addVertex(v4); g.addVertex(v5); g.addVertex(v6);
        g.addVertex(v7); g.addVertex(v8); g.addVertex(v9); g.addVertex(v10); g.addVertex(v11); g.addVertex(v12);
        g.addEdge(v1, v2); g.addEdge(v2, v3); g.addEdge(v2, v4); g.addEdge(v2, v5); g.addEdge(v3, v6);
        g.addEdge(v5, v7); g.addEdge(v3, v7); g.addEdge(v3, v8); g.addEdge(v8, v9); g.addEdge(v10, v11);
        g.addEdge(v11, v12); g.addEdge(v12, v10);

        assertEquals(Algorithms.shortestDistance(g, v6, v1), 3);
        assertEquals(Algorithms.diameter(g), 4);
        assertEquals(Algorithms.center(g), v3);
        System.out.println("Test 4");
        System.out.println("Vertices: "+ g.getVertices());
        System.out.println("Shortest Distance: " + Algorithms.shortestDistance(g, v6, v1));
        System.out.println("Diameter: " + Algorithms.diameter(g));
        System.out.println("Center: " + Algorithms.center(g));
        System.out.println("BFS: " + Algorithms.breadthFirstSearch(g));
        System.out.println("DFS: " + Algorithms.depthFirstSearch(g));
    }

    @Test
    public void testAdjacencyList5() {
        Graph g = new AdjacencyListGraph();
        Vertex v1 = new Vertex("1", "a");
        Vertex v2 = new Vertex("2", "b");
        Vertex v3 = new Vertex ("3", "c");
        Vertex v4 = new Vertex ("4", "d");
        Vertex v5 = new Vertex ("5", "e");
        Vertex v6 = new Vertex ("6", "f");
        Vertex v7 = new Vertex ("7", "g");
        Vertex v8 = new Vertex ("8", "h");
        Vertex v9 = new Vertex ("9", "i");
        Vertex v10 = new Vertex ("10", "j");
        Vertex v11 = new Vertex ("11", "k");
        g.addVertex(v1); g.addVertex(v2); g.addVertex(v3); g.addVertex(v4); g.addVertex(v5); g.addVertex(v6);
        g.addVertex(v7); g.addVertex(v8); g.addVertex(v9); g.addVertex(v10); g.addVertex(v11);
        g.addEdge(v1, v2); g.addEdge(v2, v3); g.addEdge(v3, v4); g.addEdge(v4, v5); g.addEdge(v5, v1);
        g.addEdge(v1, v2); g.addEdge(v1, v6); g.addEdge(v1, v7); g.addEdge(v2, v7); g.addEdge(v2, v8);
        g.addEdge(v3, v8); g.addEdge(v3, v9); g.addEdge(v4, v9); g.addEdge(v4, v10); g.addEdge(v5, v10);
        g.addEdge(v5, v6); g.addEdge(v6, v7); g.addEdge(v7, v8); g.addEdge(v8, v9); g.addEdge(v9, v10);
        g.addEdge(v10, v6); g.addEdge(v1, v2); g.addEdge(v11, v6); g.addEdge(v11, v7); g.addEdge(v11, v8);
        g.addEdge(v11, v9); g.addEdge(v11, v10);

        assertEquals(Algorithms.shortestDistance(g, v1, v9), 3);
        assertEquals(Algorithms.diameter(g), 3);
        assertEquals(Algorithms.center(g), v11);
        System.out.println("Test 5");
        System.out.println("Vertices: "+ g.getVertices());
        System.out.println("Shortest Distance: " + Algorithms.shortestDistance(g, v1, v9));
        System.out.println("Diameter: " + Algorithms.diameter(g));
        System.out.println("Center: " + Algorithms.center(g));
        System.out.println("BFS: " + Algorithms.breadthFirstSearch(g));
        System.out.println("DFS: " + Algorithms.depthFirstSearch(g));
    }

    @Test
    public void testAdjacencyList6() {
        Graph g = new AdjacencyMatrixGraph();
        Vertex v1 = new Vertex("1", "a");
        Vertex v2 = new Vertex("2", "b");
        Vertex v3 = new Vertex ("3", "c");
        Vertex v4 = new Vertex ("4", "d");
        Vertex v5 = new Vertex ("5", "e");
        Vertex v6 = new Vertex ("6", "f");
        Vertex v7 = new Vertex ("7", "g");
        Vertex v8 = new Vertex ("8", "h");
        Vertex v9 = new Vertex ("9", "i");
        Vertex v10 = new Vertex ("10", "j");
        Vertex v11 = new Vertex ("11", "k");
        g.addVertex(v1); g.addVertex(v2); g.addVertex(v3); g.addVertex(v4); g.addVertex(v5);
        g.addVertex(v6); g.addVertex(v7); g.addVertex(v8); g.addVertex(v9); g.addVertex(v10);
        g.addVertex(v11);

        assertEquals(Algorithms.shortestDistance(g, v1, v6), Integer.MAX_VALUE);
        assertEquals(Algorithms.diameter(g), 0);
        assertEquals(Algorithms.center(g), null);
        assertEquals(g.edgeExists(v1, v7), false);
        System.out.println("Test 6");
        System.out.println("Vertices: "+ g.getVertices());
        System.out.println("Shortest Distance: " + Algorithms.shortestDistance(g, v1, v6));
        System.out.println("Diameter: " + Algorithms.diameter(g));
        System.out.println("Center: " + Algorithms.center(g));
        System.out.println("BFS: " + Algorithms.breadthFirstSearch(g));
        System.out.println("DFS: " + Algorithms.depthFirstSearch(g));
    }

}

