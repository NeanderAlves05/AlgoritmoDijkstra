public class Dijkstra{
    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1, 5);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 3, 6);
        graph.addEdge(1, 4, 8);
        graph.addEdge(2, 4, 4);
        graph.addEdge(3, 5, 4);
        graph.addEdge(4, 5, 2);

        graph.dijkstra(0, 5);
    }
}


