package Mahdi.Davoodi;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/*
 * My Graph - created with Hash Map.
 * Thanks to Michael T. Goodrich!
 * You can find my past classes in These links{
 *      Position, PositionalList, LinkedPositionalList:
 *                           --->   https://github.com/MahdiDavoodi/Java/tree/master/Exercises/2021/February/Positional%20List
 *      Entry, Map, AbstractMap, AbstractHashMap, ProbeHashMap:
 *                           --->   https://github.com/MahdiDavoodi/Java/tree/master/Exercises/2021/March/Map
 * }
 * Note That my PositionalList doesn't have any iterator, so i put Michael T. Goodrich's PositionalList in this directory.
 * */
public class AdjacencyMapGraph<V, E> implements Graph<V, E> {

    private boolean isDirected;
    private PositionalList<Vertex<V>> vertices = new LinkedPositionalList<>();
    private PositionalList<Edge<E>> edges = new LinkedPositionalList<>();

    public AdjacencyMapGraph(boolean isDirected) {
        this.isDirected = isDirected;
    }

    @Override
    public int numberOfVertices() {
        return vertices.size();
    }

    @Override
    public int numberOfEdges() {
        return edges.size();
    }

    @Override
    public Iterable<Vertex<V>> vertices() {
        return vertices;
    }

    @Override
    public Iterable<Edge<E>> edges() {
        return edges;
    }

    @Override
    public int outDegree(Vertex<V> vertex) throws IllegalArgumentException {
        InnerVertex<V> v = validate(vertex);
        return v.getOutgoing().size();
    }

    @Override
    public int inDegree(Vertex<V> vertex) throws IllegalArgumentException {
        InnerVertex<V> v = validate(vertex);
        return v.getIncoming().size();
    }

    @Override
    public Iterable<Edge<E>> outgoingEdges(Vertex<V> vertex) throws IllegalArgumentException {
        InnerVertex<V> v = validate(vertex);
        return v.getOutgoing().values();
    }

    @Override
    public Iterable<Edge<E>> incomingEdges(Vertex<V> vertex) throws IllegalArgumentException {
        InnerVertex<V> v = validate(vertex);
        return v.getIncoming().values();
    }

    @Override
    public Edge<E> getEdge(Vertex<V> first, Vertex<V> second) throws IllegalArgumentException {
        InnerVertex<V> origin = validate(first);
        return origin.getOutgoing().get(second);
    }

    @Override
    public Vertex<V>[] endVertices(Edge<E> edge) throws IllegalArgumentException {
        InnerEdge<E> e = validate(edge);
        return e.getEndpoints();
    }

    @Override
    public Vertex<V> opposite(Vertex<V> vertex, Edge<E> edge) throws IllegalArgumentException {
        InnerEdge<E> e = validate(edge);
        Vertex<V>[] endpoints = e.getEndpoints();
        if (endpoints[0] == vertex)
            return endpoints[1];
        else if (endpoints[1] == vertex)
            return endpoints[0];
        else
            throw new IllegalArgumentException("Vertex is not belong to this edge!");
    }

    @Override
    public Vertex<V> insertVertex(V element) {
        InnerVertex<V> vertex = new InnerVertex<>(element, isDirected);
        vertex.setPosition(vertices.addLast(vertex));
        return vertex;
    }

    @Override
    public Edge<E> insertEdge(Vertex<V> first, Vertex<V> second, E element) throws IllegalArgumentException {
        if (getEdge(first, second) == null) {
            InnerEdge<E> edge = new InnerEdge<>(first, second, element);
            edge.setPosition(edges.addLast(edge));
            InnerVertex<V> origin = validate(first);
            InnerVertex<V> dest = validate(second);
            origin.getOutgoing().put(second, edge);
            dest.getIncoming().put(first, edge);
            return edge;
        } else
            throw new IllegalArgumentException("Edge from first to second already exists!");
    }

    @Override
    public void removeVertex(Vertex<V> vertex) throws IllegalArgumentException {
        InnerVertex<V> v = validate(vertex);
        for (Edge<E> edge : v.getOutgoing().values())
            removeEdge(edge);
        for (Edge<E> edge : v.getIncoming().values())
            removeEdge(edge);
        vertices.remove(v.getPosition());
        v.setPosition(null);
    }

    @Override
    public void removeEdge(Edge<E> edge) throws IllegalArgumentException {
        InnerEdge<E> e = validate(edge);
        InnerVertex<V>[] vertices = (InnerVertex<V>[]) e.getEndpoints();
        vertices[0].getOutgoing().remove(vertices[1]);
        vertices[1].getIncoming().remove(vertices[0]);
        edges.remove(e.getPosition());
        e.setPosition(null);
    }


    private class InnerVertex<V> implements Vertex<V> {
        private V element;
        private Position<Vertex<V>> position;
        private Map<Vertex<V>, Edge<E>> outgoing, incoming;

        public InnerVertex(V element, boolean graphIsDirected) {
            this.element = element;
            outgoing = new ProbeHashMap<>();
            if (graphIsDirected)
                incoming = new ProbeHashMap<>();
            else
                incoming = outgoing;
        }

        public Position<Vertex<V>> getPosition() {
            return position;
        }

        public void setPosition(Position<Vertex<V>> position) {
            this.position = position;
        }

        public Map<Vertex<V>, Edge<E>> getOutgoing() {
            return outgoing;
        }

        public Map<Vertex<V>, Edge<E>> getIncoming() {
            return incoming;
        }

        @Override
        public V getElement() {
            return element;
        }
    }

    private class InnerEdge<E> implements Edge<E> {
        private E element;
        private Position<Edge<E>> position;
        private InnerVertex<V>[] endpoints;

        public InnerEdge(Vertex<V> first, Vertex<V> second, E element) {
            InnerVertex<V> v1 = validate(first);
            InnerVertex<V> v2 = validate(second);
            this.element = element;
            endpoints = (InnerVertex<V>[]) new InnerVertex[]{v1, v2};
        }

        public Position<Edge<E>> getPosition() {
            return position;
        }

        public Vertex<V>[] getEndpoints() {
            return endpoints;
        }

        public void setPosition(Position<Edge<E>> position) {
            this.position = position;
        }

        @Override
        public E getElement() {
            return element;
        }
    }

    private InnerVertex<V> validate(Vertex<V> vertex) {
        if (!(vertex instanceof InnerVertex)) throw new IllegalArgumentException("Invalid vertex");
        return (InnerVertex<V>) vertex;
    }

    private InnerEdge<E> validate(Edge<E> edge) {
        if (!(edge instanceof InnerEdge)) throw new IllegalArgumentException("Invalid edge");
        return (InnerEdge<E>) edge;
    }


    // My Graph Algorithms

    public static <V, E> void DFS(Graph<V, E> graph,
                                  Vertex<V> vertex,
                                  Set<Vertex<V>> discoveredVertices,
                                  Map<Vertex<V>, Edge<E>> forest) {
        discoveredVertices.add(vertex);
        for (Edge<E> edge : graph.outgoingEdges(vertex)) {
            Vertex<V> across = graph.opposite(vertex, edge);
            if (!discoveredVertices.contains(across)) {
                forest.put(across, edge);
                DFS(graph, across, discoveredVertices, forest);
            }
        }
    }

    public static <V, E> Map<Vertex<V>, Edge<E>> DFSComplete(Graph<V, E> graph) {
        Set<Vertex<V>> discoveredVertices = new HashSet<>();
        Map<Vertex<V>, Edge<E>> forest = new ProbeHashMap<>();
        for (Vertex<V> vertex : graph.vertices())
            if (!discoveredVertices.contains(vertex))
                DFS(graph, vertex, discoveredVertices, forest);
        return forest;
    }

    public static <V, E> void BFS(Graph<V, E> graph, Vertex<V> start,
                                  Set<Vertex<V>> discoveredVertices,
                                  Map<Vertex<V>, Edge<E>> forest) {
        PositionalList<Vertex<V>> currentLevel = new LinkedPositionalList<>();
        discoveredVertices.add(start);
        currentLevel.addLast(start);
        while (!currentLevel.isEmpty()) {
            PositionalList<Vertex<V>> nextLevel = new LinkedPositionalList<>();
            for (Vertex<V> vertex : currentLevel)
                for (Edge<E> edge : graph.outgoingEdges(vertex)) {
                    Vertex<V> across = graph.opposite(vertex, edge);
                    if (!discoveredVertices.contains(across)) {
                        discoveredVertices.add(across);
                        forest.put(across, edge);
                        nextLevel.addLast(across);
                    }
                }
            currentLevel = nextLevel;
        }
    }

    public void printAllVertices() {
        for (Vertex<V> vertex :
                vertices) {
            System.out.print(vertex.getElement() + " - ");
        }
    }

    public boolean contains(V element) {
        for (Vertex<V> vertex :
                vertices) {
            if (vertex.getElement().equals(element))
                return true;
        }
        return false;
    }

    public int numberOfSpanningTrees(Graph<V, E> graph) {
        int totalSpTree = 1;
        Set<Vertex<V>> discoveredVertices = new HashSet<>();
        Map<Vertex<V>, Edge<E>> forest = new ProbeHashMap<>();
        for (Vertex<V> vertex :
                vertices) {
            if (!discoveredVertices.contains(vertex)) {
                DFS(graph, vertex, discoveredVertices, forest);
                if (discoveredVertices.size() < vertices.size()) totalSpTree++;
            }
        }
        return totalSpTree;
    }

    public static <V, E> PositionalList<Vertex<V>> topologicalSort(Graph<V, E> graph) {
        PositionalList<Vertex<V>> result = new LinkedPositionalList<>();
        Stack<Vertex<V>> ready = new Stack<>();

        Map<Vertex<V>, Integer> inCount = new ProbeHashMap<>();
        for (Vertex<V> vertex : graph.vertices()) {
            inCount.put(vertex, graph.inDegree(vertex));
            if (inCount.get(vertex) == 0)
                ready.push(vertex);
        }
        while (!ready.isEmpty()) {
            Vertex<V> vertex = ready.pop();
            result.addLast(vertex);
            for (Edge<E> edge : graph.outgoingEdges(vertex)) {
                Vertex<V> across = graph.opposite(vertex, edge);
                inCount.put(across, inCount.get(across) - 1);
                if (inCount.get(across) == 0)
                    ready.push(across);
            }
        }
        return result;
    }
}