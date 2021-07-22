package Mahdi.Davoodi;

public interface Graph<V, E> {
    int numberOfVertices();

    int numberOfEdges();

    Iterable<Vertex<V>> vertices();

    Iterable<Edge<E>> edges();

    int outDegree(Vertex<V> vertex) throws IllegalArgumentException;

    int inDegree(Vertex<V> vertex) throws IllegalArgumentException;

    Iterable<Edge<E>> outgoingEdges(Vertex<V> vertex) throws IllegalArgumentException;

    Iterable<Edge<E>> incomingEdges(Vertex<V> vertex) throws IllegalArgumentException;

    Edge<E> getEdge(Vertex<V> first, Vertex<V> second) throws IllegalArgumentException;

    Vertex<V>[] endVertices(Edge<E> edge) throws IllegalArgumentException;

    Vertex<V> opposite(Vertex<V> vertex, Edge<E> edge) throws IllegalArgumentException;

    Vertex<V> insertVertex(V element);

    Edge<E> insertEdge(Vertex<V> first, Vertex<V> second, E element) throws IllegalArgumentException;

    void removeVertex(Vertex<V> vertex) throws IllegalArgumentException;

    void removeEdge(Edge<E> edge) throws IllegalArgumentException;
}
