package Mahdi.Davoodi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdjacencyMapGraphTest {
    AdjacencyMapGraph<String, Integer> graph;

    private void addToGraph() {
        Vertex<String> istanbul = graph.insertVertex("Istanbul");
        Vertex<String> newYork = graph.insertVertex("New York");
        Vertex<String> tehran = graph.insertVertex("Tehran");
        Vertex<String> berlin = graph.insertVertex("Berlin");
        Vertex<String> tokyo = graph.insertVertex("Tokyo");
        graph.insertEdge(istanbul, tehran, 20);
        graph.insertEdge(istanbul, newYork, 150);
        graph.insertEdge(istanbul, berlin, 30);
        graph.insertEdge(newYork, tehran, 200);
        graph.insertEdge(berlin, tehran, 40);
        graph.insertEdge(tehran, tokyo, 130);
    }

    @BeforeEach
    void setUp() {
        graph = new AdjacencyMapGraph<>(false);
    }

    @Test
    void add() {
        assertEquals(0, graph.numberOfVertices());
        assertEquals(0, graph.numberOfEdges());
        addToGraph();
        assertEquals(5, graph.numberOfVertices());
        assertEquals(6, graph.numberOfEdges());
    }

    @Test
    void across() {
        Vertex<String> istanbul = graph.insertVertex("Istanbul");
        Vertex<String> newYork = graph.insertVertex("New York");
        Edge<Integer> istanbul_newYork = graph.insertEdge(istanbul, newYork, 150);
        assertEquals(newYork, graph.opposite(istanbul, istanbul_newYork));
    }

    @Test
    void remove() {
        Vertex<String> istanbul = graph.insertVertex("Istanbul");
        Vertex<String> newYork = graph.insertVertex("New York");
        Vertex<String> tehran = graph.insertVertex("Tehran");
        Vertex<String> berlin = graph.insertVertex("Berlin");
        graph.insertEdge(istanbul, tehran, 20);
        Edge<Integer> istanbul_newYork = graph.insertEdge(istanbul, newYork, 150);
        graph.insertEdge(istanbul, berlin, 30);
        graph.insertEdge(newYork, tehran, 200);

        assertEquals(4, graph.numberOfEdges());
        assertEquals(4, graph.numberOfVertices());
        graph.removeEdge(istanbul_newYork);
        graph.removeVertex(berlin);
        assertEquals(2, graph.numberOfEdges());
        assertEquals(3, graph.numberOfVertices());
    }

    @Test
    void find() {
        addToGraph();
        assertTrue(graph.contains("Istanbul"));
        assertFalse(graph.contains("Hello"));
    }

    @Test
    void NumberOfTrees() {
        Vertex<String> istanbul = graph.insertVertex("Istanbul");
        Vertex<String> newYork = graph.insertVertex("New York");
        Vertex<String> tehran = graph.insertVertex("Tehran");
        Vertex<String> berlin = graph.insertVertex("Berlin");
        Vertex<String> tokyo = graph.insertVertex("Tokyo");
        graph.insertEdge(istanbul, newYork, 150);
        graph.insertEdge(berlin, tehran, 40);

        assertEquals(3, graph.numberOfSpanningTrees(graph));
    }

    @Test
    void isThereACycle() {
        addToGraph();
        assertTrue(graph.isThereACycle(graph));
    }
}