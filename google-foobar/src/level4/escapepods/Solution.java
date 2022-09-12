package level4.escapepods;

import java.util.ArrayList;

class Helper {
    public static ArrayList<Edge> getEdges(int[] supersources, int[] supersinks, int[][] paths) {
        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0; i < paths.length; i++) {
            for (int j = 0; j < paths.length; j++) {
                if (paths[i][j] > 0)
                    edges.add(new Edge(i, j, paths[i][j]));
            }
        }

        for (int i = 0; i < supersources.length; i++)
            edges.add(new Edge(paths.length, supersources[i], Integer.MAX_VALUE));

        for (int i = 0; i < supersinks.length; i++)
            edges.add(new Edge(supersinks[i], paths.length + 1, Integer.MAX_VALUE));

        return edges;
    }
}

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

    public Graph(int[] supersources, int[] supersinks, int[][] paths) {
        this.nVertices = paths[0].length;
        this.edges = Helper.getEdges(supersources, supersinks, paths);
    }

}

public class Solution {
    //https://en.wikipedia.org/wiki/Dinic%27s_algorithm
    //https://en.wikipedia.org/wiki/Maximum_flow_problem

    public static int solution(int[] entrances, int[] exits, int[][] paths) {
        Graph grap = new Graph(entrances, exits, paths);
        return 0;
    }
}