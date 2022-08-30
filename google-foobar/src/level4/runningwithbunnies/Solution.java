package level4.runningwithbunnies;

import java.util.ArrayList;
import java.util.Arrays;

class Edge {
    private int origin;
    private int destination;
    private int weight;

    public Edge(int origin, int destination, int weight) {
        this.origin = origin;
        this.destination = destination;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object obj) {
        return obj.toString().equals(this.toString());
    }

    @Override
    public String toString() {
        return "Edge(" + this.origin + ", " + this.destination + ", " + this.weight + ")";
    }

    public int getOrigin() {
        return origin;
    }

    public void setOrigin(int origin) {
        this.origin = origin;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}

class Graph {
    int nVertices;
    ArrayList<Edge> edges;

    public Graph(int[][] input) {
        this.nVertices = input[0].length;
        this.edges = Helper.getEdges(input);
    }

    public int[] bellmanFord(int source) {
        int[] distance = new int[this.nVertices];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        for (int i = 0; i < this.nVertices - 1; i++) {
            for (int j = 0; j < this.edges.size(); j++) {
                Edge edge = this.edges.get(j);
                int u = edge.getOrigin();
                int v = edge.getDestination();
                int w = edge.getWeight();

                if (distance[u] + w < distance[v])
                    distance[v] = distance[u] + w;
            }
        }
        return distance;
    }
}

public class Solution {
    public static int[] solution(int[][] times, int times_limit) {
        Graph graph = new Graph(times);
        int[] distance = graph.bellmanFord(0);
        return new int[]{0, 1};
    }
}