package level4.runningwithbunnies;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class Edge {
    int origin;
    int destination;
    int weight;

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
}

class Graph{
    int[] vertices;
    ArrayList<Edge> edges;

    public Graph(int[][] input){
        this.vertices = getVertices(input);
        this.edges = getEdges(input);
    }

    public int[] bellmanFord(){
        return new int[]{};
    }

    public static int[] getVertices(int[][] input) {
        return IntStream.rangeClosed(0, input[0].length - 1).toArray();
    }

    public static ArrayList<Edge> getEdges(int[][] input) {
        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0; i < input[0].length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                if (i != j && input[i][j] != Integer.MAX_VALUE) edges.add(new Edge(i, j, input[i][j]));
            }
        }
        return edges;
    }
}

public class Solution {
    public static int[] solution(int[][] times, int times_limit) {
        Graph graph = new Graph(times);
        return new int[]{0, 1};
    }
}