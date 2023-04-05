import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
public class Graph {
    int vertices;
    LinkedList<Node>[] adjacencylist;

    Graph(int vertices) {
        this.vertices = vertices;
        adjacencylist = new LinkedList[vertices];
        //inizializza la lista di adiacenza per ogni vertice
        for (int i = 0; i < vertices; i++) {
            adjacencylist[i] = new LinkedList<>();
        }
    }

    //aggiungi un arco dal vertice u al vertice v con peso w
    void addEdge(int u, int v, int weight) {
        adjacencylist[u].add(new Node(v, weight));
        adjacencylist[v].add(new Node(u, weight));
    }

    // Calcola il percorso più breve tra i nodi sorgente e destinazione
    void dijkstra(int source, int destination) {
        int[] distance = new int[vertices];
        int[] previous = new int[vertices];
        PriorityQueue<Node> queue = new PriorityQueue<>(vertices, Comparator.comparingInt(node -> node.weight));

        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(previous, -1);

        distance[source] = 0;
        queue.add(new Node(source, 0));

        while (!queue.isEmpty()) {
            int u = queue.poll().vertex;

            for (Node neighbor : adjacencylist[u]) {
                int v = neighbor.vertex;
                int weight = neighbor.weight;

                int newDistance = distance[u] + weight;
                if (newDistance < distance[v]) {
                    queue.remove(new Node(v, distance[v]));
                    distance[v] = newDistance;
                    previous[v] = u;
                    queue.add(new Node(v, distance[v]));
                }
            }
        }

        // Stampa il percorso più breve
        LinkedList<Integer> path = new LinkedList<>();
        int current = destination;
        while (current != -1) {
            path.addFirst(current);
            current = previous[current];
        }
        System.out.println("Percorso più breve da " + source + " a " + destination + ": " + path);
    }
}
