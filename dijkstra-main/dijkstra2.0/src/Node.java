import java.util.TreeMap;

public class Node {
    private String name;
    private int weight = Integer.MAX_VALUE;
    private TreeMap<Node, Integer> links;
    private Node prev;
    public Node(String label){
        this.name = label;
        links = new TreeMap<>((a, b) -> a.name.compareTo(b.name));
        prev=null;

    }
    public void link(Node node2, Integer weight){
        links.put(node2, weight);
        node2.links.put(this, weight);
    }
    public int weightTo(Node node){
        return weight + links.get(node);
    }

    //getter and setter
    public String getNodeName() {
        return name;
    }
    public void setNodeName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }


    public TreeMap<Node, Integer> getLinks() {
        return links;
    }
    public void setLinks(TreeMap<Node, Integer> links) {
        this.links = links;
    }

    public Node getPrev() {
        return prev;
    }
    public void setPrev(Node prev) {
        this.prev = prev;
    }
}
