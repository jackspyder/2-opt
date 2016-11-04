package sample;

import java.util.ArrayList;
import java.util.HashMap;

public class Node {

    private HashMap<String, Object> attributes;
    private ArrayList<Edge> connections;

    public Node() {
        attributes = new HashMap<String, Object>();
        connections = new ArrayList<Edge>();
    }

    public void setAttributes(String key, Object value) {
        attributes.put(key, value);
    }

    public Object getAttributes(String key) {
        return attributes.get(key);
    }

    public void connect(Edge anEdge) {
        connections.add(anEdge);
    }

    public ArrayList<Edge> getConnections() {
        return connections;
    }

    public String tostring() {
        String buffer = "";

        for (String k : attributes.keySet()) {
            Object v = attributes.get(k);
            buffer = k + " = " + v.toString();
        }
        return buffer;
    }
}
