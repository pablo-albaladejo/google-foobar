package level4.runningwithbunnies;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class SolutionTestHelpers {
    @Test
    public void getVertices() {
        int[][] matrix = {{0, 1, 1, 1, 1}, {1, 0, 1, 1, 1}, {1, 1, 0, 1, 1}, {1, 1, 1, 0, 1}, {1, 1, 1, 1, 0}};
        int[] vertices = Graph.getVertices(matrix);
        assertArrayEquals(new int[]{0, 1, 2, 3, 4}, vertices);
    }

    @Test
    public void getEdges() {
        int[][] matrix = {{0, 1, 1}, {2, 0, 2}, {3, 3, 0}};
        ArrayList<Edge> edges = Graph.getEdges(matrix);

        ArrayList<Edge> expected = new ArrayList<>();
        expected.add(new Edge(0, 1, 1));
        expected.add(new Edge(0, 2, 1));
        expected.add(new Edge(1, 0, 2));
        expected.add(new Edge(1, 2, 2));
        expected.add(new Edge(2, 0, 3));
        expected.add(new Edge(2, 1, 3));

        assertIterableEquals(expected, edges);
    }
    @Test
    public void getEdgesInf() {
        int[][] matrix = {
                {0, -1, 4, Integer.MAX_VALUE, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, 0, 3, 2, 2},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, 0, Integer.MAX_VALUE, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, 1, 5, 0, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -3, 0}
        };
        ArrayList<Edge> edges = Graph.getEdges(matrix);

        ArrayList<Edge> expected = new ArrayList<>();
        expected.add(new Edge(0, 1, -1));
        expected.add(new Edge(0, 2, 4));
        expected.add(new Edge(1, 2, 3));
        expected.add(new Edge(1, 3, 2));
        expected.add(new Edge(1, 4, 2));
        expected.add(new Edge(3, 1, 1));
        expected.add(new Edge(3, 2, 5));
        expected.add(new Edge(4, 3, -3));

        assertIterableEquals(expected, edges);
    }

    @Test
    public void bellmanFord() {
        int[][] matrix = {
                {0, -1, 4, Integer.MAX_VALUE, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, 0, 3, 2, 2},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, 0, Integer.MAX_VALUE, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, 1, 5, 0, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -3, 0}
        };
        Graph graph = new Graph(matrix);
        int[] distances = graph.bellmanFord();
        assertArrayEquals(new int[]{0, -1, 2, -2, 1}, distances);
    }


}
