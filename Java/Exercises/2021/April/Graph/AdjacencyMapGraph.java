package Mahdi.Davoodi;

import java.util.*;

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

    public InnerVertex<V> validate(Vertex<V> vertex) {
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

    public <V, E> void nonRecursiveDFSPrint(Graph<V, E> graph) {

        Stack<Vertex<V>> stack = new Stack<>();
        Set<Vertex<V>> discoveredVertices = new HashSet<>();

        stack.push((Vertex<V>) vertices.first().getElement());

        while (!stack.empty()) {

            Vertex<V> vertex = stack.pop();
            if (discoveredVertices.contains(vertex)) continue;


            discoveredVertices.add(vertex);
            System.out.print(vertex.getElement() + " ");

            for (Edge<E> edge :
                    graph.outgoingEdges(vertex)) {
                Vertex<V> across = graph.opposite(vertex, edge);
                if (!discoveredVertices.contains(across)) {
                    stack.push(across);
                }
            }
        }
    }

    private int numberOfWays(Graph<V, E> graph,
                             InnerVertex<V> start,
                             InnerVertex<V> end,
                             int counter) {

        if (start == end) counter++;
        else {
            for (Edge<E> edge : graph.outgoingEdges(start)) {
                InnerVertex<V> across = (InnerVertex<V>) graph.opposite(start, edge);
                counter = numberOfWays(graph, across, end, counter);
            }
        }
        return counter;
    }


    public int numberOfWays(Graph<V, E> graph, InnerVertex<V> start, InnerVertex<V> end) {
        int numberOfWays = 0;
        numberOfWays = numberOfWays(graph, start, end, numberOfWays);
        return numberOfWays;
    }

    public boolean isThereACycle(Graph<V, E> graph) {
        Set<Vertex<V>> discoveredVertices = new HashSet<>();

        for (Vertex<V> vertex :
                vertices) {
            if (!discoveredVertices.contains(vertex))
                if (isThereACycle(graph, vertex, discoveredVertices, vertex))
                    return true;
        }

        return false;

    }

    private boolean isThereACycle(Graph<V, E> graph,
                                  Vertex<V> vertex,
                                  Set<Vertex<V>> discoveredVertices,
                                  Vertex<V> before) {

        discoveredVertices.add(vertex);

        for (Edge<E> edge : graph.outgoingEdges(vertex)) {
            Vertex<V> across = graph.opposite(vertex, edge);
            if (!discoveredVertices.contains(across))
                return isThereACycle(graph, across, discoveredVertices, vertex);
            else if (across != before)
                return true;
        }
        return false;
    }

    public  <V> Map<Vertex<V>, Integer>
    shortestPathLengths(Graph<V, Integer> graph, Vertex<V> src) {
        Map<Vertex<V>, Integer> d = new ProbeHashMap<>();
        Map<Vertex<V>, Integer> cloud = new ProbeHashMap<>();

        AdaptablePriorityQueue<Integer, Vertex<V>> pq = new HeapAdaptablePriorityQueue<>();

        Map<Vertex<V>, Entry<Integer, Vertex<V>>> pqTokens = new ProbeHashMap<>();

        for (Vertex<V> v : graph.vertices()) {
            if (v == src)
                d.put(v, 0);
            else
                d.put(v, Integer.MAX_VALUE);
            pqTokens.put(v, pq.insert(d.get(v), v));
        }

        while (!pq.isEmpty()) {
            Entry<Integer, Vertex<V>> entry = pq.removeMin();
            int key = entry.getKey();
            Vertex<V> u = entry.getValue();
            cloud.put(u, key);
            pqTokens.remove(u);
            for (Edge<Integer> e : graph.outgoingEdges(u)) {
                Vertex<V> v = graph.opposite(u, e);
                if (cloud.get(v) == null) {

                    int wgt = e.getElement();
                    if (d.get(u) + wgt < d.get(v)) {
                        d.put(v, d.get(u) + wgt);
                        pq.replaceKey(pqTokens.get(v), d.get(v));
                    }
                }
            }
        }
        return cloud;
    }


    public void minimumSpanningTree(Graph<V, Integer> graph) {

        if (this.numberOfSpanningTrees(this) == 1) {

            List<Edge<Integer>> tree = new LinkedList<>();

            List<Edge<Integer>> notUsedEdges = new ArrayList<>();
            for (Edge<Integer> edge :
                    graph.edges()) {
                notUsedEdges.add(edge);
            }
            notUsedEdges.sort(new Comparator<Edge<Integer>>() {
                @Override
                public int compare(Edge<Integer> o1, Edge<Integer> o2) {
                    if (o1.getElement() == o2.getElement()) return 0;
                    else if (o1.getElement() < o2.getElement()) return -1;
                    else return 1;
                    //   return o1.getElement().compareTo(o2.getElement());
                }
            });
            Set<Vertex<V>> v_tree = new HashSet<>();
            Set<Edge<Integer>> e_tree = new HashSet<>();
            //java.util.Map<Vertex<V>, Vertex<V>> connectedVertices = new HashMap<>();
            //ArrayList<Vertex<V>> connected1 = new ArrayList<>(),
            //        connected2 = new ArrayList<>();


            for (Edge<Integer> edge : notUsedEdges) {
                Vertex<V>[] endPoints = graph.endVertices(edge);
                if (v_tree.contains(endPoints[0]) && v_tree.contains(endPoints[1])) continue;
                v_tree.add(endPoints[0]);
                v_tree.add(endPoints[1]);
                e_tree.add(edge);
            }
            for (Edge<Integer> e :
                    e_tree) {
                System.out.print(e.getElement() + ", ");
            }
        }


    }

}
