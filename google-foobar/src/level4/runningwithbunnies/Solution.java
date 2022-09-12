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

    public static int[] bellmanFord(int source, ArrayList<Edge> edges, int nVertices) {
        int[] distance = new int[nVertices];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        for (int i = 0; i < nVertices - 1; i++) {
            for (int j = 0; j < edges.size(); j++) {
                Edge edge = edges.get(j);
                int u = edge.getOrigin();
                int v = edge.getDestination();
                int w = edge.getWeight();

                if (distance[u] != Integer.MAX_VALUE && (distance[u] + w < distance[v]))
                    distance[v] = distance[u] + w;
            }
        }
        return distance;
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

    public static int getPathTime(int[][] distances, int[] nodes) {
        int time = 0;
        int source = 0;
        for (int i = 0; i < nodes.length; i++) {
            int dest = nodes[i] + 1;
            time += distances[source][dest];
            source = dest;
        }
        time += distances[source][distances[0].length - 1];
        return time;
    }

    public static int[] arrayListToIntArray(ArrayList<Object> list) {
        return list.stream().filter(t -> t != null).mapToInt(t -> (int) t).toArray();
    }

    public static boolean hasNegativeCycle(int[][] distances, int[][] times) {
        for (int origin = 0; origin < times[0].length; origin++) {
            for (int u = 0; u < times[0].length; u++) {
                for (int v = 0; v < times[0].length; v++) {
                    if((distances[origin][u] + times[u][v]) < distances[origin][v]) return true;
                }
            }
        }
        return false;
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

    public int[][] getDistances() {
        int[][] distances = new int[this.nVertices][this.nVertices];
        for (int i = 0; i < this.nVertices; i++) {
            distances[i] = Helper.bellmanFord(i, this.edges, this.nVertices);
        }
        return distances;
    }

    public int getNVertices() {
        return nVertices;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }
}

public class Solution {
    //https://en.wikipedia.org/wiki/Bellman%E2%80%93Ford_algorithm
    public static int[] solution(int[][] times, int times_limit) {
        Graph graph = new Graph(times);
        int[][] distances = graph.getDistances();

        if (Helper.hasNegativeCycle(distances, times)) return IntStream.range(0, times[0].length-2).toArray();

        ArrayList<Object> bunnies = new ArrayList<>();
        for (int i = 0; i < times[0].length - 2; i++) bunnies.add(i);

        for (int i = bunnies.size(); i > 0; i--) {
            ArrayList<ArrayList<Object>> perms = Helper.permutations(i, bunnies);
            for (int j = 0; j < perms.size(); j++) {
                int[] intPerm = Helper.arrayListToIntArray(perms.get(j));
                int time = Helper.getPathTime(distances, intPerm);
                if (time <= times_limit) {
                    Arrays.sort(intPerm);
                    return intPerm;
                }
            }
        }
        return new int[]{};
    }
}