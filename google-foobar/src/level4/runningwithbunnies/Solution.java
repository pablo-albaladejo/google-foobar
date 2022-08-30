package level4.runningwithbunnies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

class Helper {
    public static int[] getVertices(int[][] input) {
        return IntStream.rangeClosed(0, input[0].length - 1).toArray();
    }

    public static ArrayList<Edge> getEdges(int[][] input) {
        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0; i < input[0].length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                if (i != j && input[i][j] != Integer.MAX_VALUE) edges.add(new Edge(i, j, input[i][j]));
            }
        }
        return edges;
    }

    public static ArrayList<Object> copyArrayList(ArrayList<Object> oldArrayList) {
        ArrayList<Object> newArrayList = new ArrayList<>();
        for (Object item : oldArrayList) newArrayList.add(item);
        return newArrayList;
    }

    public static void permutationsRecursive(int k, ArrayList<Object> input, ArrayList<Object> current, ArrayList<ArrayList<Object>> acc) {
        if (current.size() == k) {
            acc.add(current);
        } else {
            for (int j = 0; j < input.size(); j++) {
                ArrayList<Object> nextCurrent = copyArrayList(current);
                nextCurrent.add(input.get(j));

                ArrayList<Object> nextInput = copyArrayList(input);
                nextInput.remove(j);
                permutationsRecursive(k, nextInput, nextCurrent, acc);
            }
        }
    }

    public static ArrayList<ArrayList<Object>> permutations(int k, ArrayList<Object> input) {
        ArrayList<ArrayList<Object>> result = new ArrayList<>();
        ArrayList<Object> current = new ArrayList<>();
        permutationsRecursive(k, input, current, result);
        return result;
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