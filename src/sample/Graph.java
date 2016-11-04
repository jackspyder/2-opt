package sample;

import java.util.ArrayList;

public class Graph {
    private ArrayList<Node> nodes = new ArrayList<Node>();

    public void addNode(Node newNode) {
        nodes.add(newNode);
    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public void connect(Node n1, Node n2, int weight) {
        Edge newEdge = new Edge(n1, n2, weight);
        n1.connect(newEdge);
        n2.connect(newEdge);
    }

    public String toString() {
        String buffer = "";

        for (Node n : nodes)
            buffer = buffer + n + "\n";
        return buffer;
    }
}
