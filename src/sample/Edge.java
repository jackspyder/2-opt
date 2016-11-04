package sample;

public class Edge {
    private Node end1;
    private Node end2;
    private int weight;

    public Edge(Node e1, Node e2, int w) {
        end1 = e1;
        end2 = e2;
        weight = w;
    }

    public Node navigate(Node thisEnd) {
        if (thisEnd == end1)
            return end2;
        else
            return end1;

    }

    public void setWeight(int val) {
        weight = val;
    }

    public int getWeight() {
        return weight;
    }
}
