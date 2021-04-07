package Mahdi.Davoodi;

public class Test {
    public static void main(String[] args) {
        AdjacencyMapGraph<String, Integer> graph = new AdjacencyMapGraph<>(false);


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

        graph.nonRecursiveDFSPrint(graph);
        System.out.println();
        graph.minimumSpanningTree(graph);
        System.out.println();
        Map<Vertex<String>, Integer> map = graph.shortestPathLengths(graph, istanbul);
        for (Vertex<String> vertex :
                map.keySet()) {
            System.out.print("---> To " + vertex.getElement() + " in " + map.get(vertex) + ". ");
        }
    }
}