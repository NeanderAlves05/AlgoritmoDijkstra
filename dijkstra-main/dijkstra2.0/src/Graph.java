import java.util.PriorityQueue;
import java.util.TreeMap;

public class Graph {
    private TreeMap<String, Node> vertices;

    public Graph() {
        vertices = new TreeMap<>((a, b) -> a.compareTo(b));
    }
    public void addVertex(Node node){
        vertices.put(node.getNodeName(), node);
    }
    //metodo per aggiungere un nuovo nodo
    public void addVertex(String label){
        vertices.put(label, new Node(label));
    }
    public void removeVertex(Node node){
        vertices.remove(node.getNodeName());
    }
    public void removeVertex(String label){
        vertices.remove(label);
    }
    public Node getVertex(String label){
        return vertices.get(label);
    }

    public TreeMap<String, Node> getVertices() {
        return vertices;
    }

    public void setVertices(TreeMap<String, Node> vertices) {
        this.vertices = vertices;
    }

    public void dijkstraShortestPath(String source, String destination) {
        Node node = null;
        Node destinationNode;
        destinationNode = vertices.get(destination);
        PriorityQueue<Node> unvisitedNodes = new PriorityQueue<>((a, b) -> a.getWeight() - b.getWeight());

        vertices.values().forEach(n -> n.setWeight(Integer.MAX_VALUE));
        vertices.get(source).setWeight(0);
        unvisitedNodes.addAll(vertices.values());

        while(!unvisitedNodes.isEmpty() && destinationNode != node){ //finché ci sono nodi da visitare
            node = unvisitedNodes.remove();
            for(Node nextNode: node.getLinks().keySet()){ //keySet-> restituisce un insieme di tutte le key presenti nella mappa (Map) su cui è stato chiamato il metodo
                if(nextNode.getWeight() > node.weightTo(nextNode)) { //controllo che sia più efficace
                    nextNode.setWeight(node.weightTo(nextNode));
                    nextNode.setPrev(node);
                }
            }
        }
    }
}