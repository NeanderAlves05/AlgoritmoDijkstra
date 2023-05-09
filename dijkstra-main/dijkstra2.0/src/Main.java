public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addVertex("Home");
        graph.addVertex("School");
        graph.addVertex("PoliceStation");
        graph.addVertex("Shop");
        graph.addVertex("Hospital");
        graph.getVertex("Home").link(graph.getVertex("PoliceStation"), 1);
        graph.getVertex("PoliceStation").link(graph.getVertex("Shop"), 2);
    }
}
