package level4.escapepods;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

class Helper {
    static public int getMaximumFlow(Graph graph) {
        int s = graph.getNumberOfNodes() - 2;
        int t = graph.getNumberOfNodes() - 1;

        int maximumFlow = 0;

        int delta;
        int[] dist = new int[graph.getNumberOfNodes()];

        while (dinicBfs(s, t, dist, graph)) {
            do {
                delta = dinicDfs(s, t, dist, Integer.MAX_VALUE, graph);
                maximumFlow += delta;
            } while (delta > 0);
        }

        return maximumFlow;
    }

    static public boolean dinicBfs(int u, int v, int[] dist, Graph graph) {
        Arrays.fill(dist, -1);
        dist[u] = 0;

        Deque<Integer> deque = new ArrayDeque<>(graph.getNumberOfNodes());
        deque.offer(u);

        while (!deque.isEmpty()) {
            int node = deque.poll();
            for (Edge edge : graph.getAdjuncts(node)) {
                if (dist[edge.getDestination()] < 0 && edge.getCapacity() > edge.getFlow()) {
                    deque.offer(edge.getDestination());
                    dist[edge.getDestination()] = dist[node] + 1;
                }
            }
        }

        return dist[v] >= 0;
    }

    static int dinicDfs(int u, int v, int[] dist, int flow, Graph graph) {
        if (u == v) return flow;
        int delta;

        for(Edge edge: graph.getAdjuncts(u)){

            if (dist[edge.getDestination()] == dist[u] + 1 && edge.getFlow() < edge.getCapacity()) {
                delta = dinicDfs(edge.getDestination(), v, dist, Math.min(flow, edge.getCapacity() - edge.getFlow()), graph);

                if (delta > 0) {
                    edge.setFlow(edge.getFlow() + delta);
                    Edge reverse = graph.getAdjuncts(edge.getDestination()).get(edge.getReverse());
                    reverse.setFlow(reverse.getFlow() - delta);
                    return delta;
                }
            }
        }
        return 0;
    }
}

class Edge {
    private int destination;
    private int flow;
    private int capacity;
    private int reverse;

    public Edge(int destination, int flow, int capacity, int reverse) {
        this.destination = destination;
        this.flow = flow;
        this.capacity = capacity;
        this.reverse = reverse;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public int getFlow() {
        return flow;
    }

    public void setFlow(int flow) {
        this.flow = flow;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getReverse() {
        return reverse;
    }

    public void setReverse(int reverse) {
        this.reverse = reverse;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "destination=" + destination +
                ", flow=" + flow +
                ", capacity=" + capacity +
                ", reverse=" + reverse +
                '}';
    }
}

class Graph {
    private int numberOfNodes;

    private ArrayList<Edge>[] adjuncts;

    public Graph(int[] supersources, int[] supersinks, int[][] paths) {
        this.numberOfNodes = paths.length + 2;

        adjuncts = new ArrayList[this.numberOfNodes];
        for (int i = 0; i < this.numberOfNodes; i++)
            adjuncts[i] = new ArrayList<>();

        for (int i = 0; i < this.numberOfNodes - 2; i++) {
            for (int j = 0; j < this.numberOfNodes - 2; j++) {
                if (paths[i][j] > 0) addNode(i, j, paths[i][j]);
            }
        }

        for (int i = 0; i < supersources.length; i++)
            addNode(this.numberOfNodes - 2, supersources[i], Integer.MAX_VALUE);

        for (int i = 0; i < supersinks.length; i++)
            addNode(supersinks[i], this.numberOfNodes - 1, Integer.MAX_VALUE);

    }

    public ArrayList<Edge> getAdjuncts(int node) {
        return adjuncts[node];
    }

    public int getNumberOfNodes() {
        return numberOfNodes;
    }

    public void addNode(int origin, int destination, int capacity) {
        adjuncts[origin].add(new Edge(destination, 0, capacity, adjuncts[destination].size()));
        adjuncts[destination].add(new Edge(origin, 0, 0, adjuncts[origin].size() - 1));
    }

    @Override
    public String toString() {
        String str = "";
        for (ArrayList<Edge> edges : adjuncts) {
            str += "\n" + Arrays.toString(edges.toArray());
        }
        return str;
    }

}

public class Solution {
    public static int solution(int[] entrances, int[] exits, int[][] paths) {
        Graph flowNetwork = new Graph(entrances, exits, paths);
        return Helper.getMaximumFlow(flowNetwork);
    }
}