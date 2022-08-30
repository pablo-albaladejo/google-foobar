package level4.runningwithbunnies;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class SolutionTestHelpers {
    @Test
    public void getVertices() {
        int[][] matrix = {{0, 1, 1, 1, 1}, {1, 0, 1, 1, 1}, {1, 1, 0, 1, 1}, {1, 1, 1, 0, 1}, {1, 1, 1, 1, 0}};
        int[] vertices = Helper.getVertices(matrix);
        assertArrayEquals(new int[]{0, 1, 2, 3, 4}, vertices);
    }

    @Test
    public void getEdges() {
        int[][] matrix = {{0, 1, 1}, {2, 0, 2}, {3, 3, 0}};
        ArrayList<Edge> edges = Helper.getEdges(matrix);

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
        ArrayList<Edge> edges = Helper.getEdges(matrix);

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
    public void bellmanFord0() {
        int[][] matrix = {
                {0, -1, 4, Integer.MAX_VALUE, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, 0, 3, 2, 2},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, 0, Integer.MAX_VALUE, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, 1, 5, 0, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -3, 0}
        };

        ArrayList<Edge> edges = Helper.getEdges(matrix);
        int nVertices = matrix[0].length;
        int[] distance = Helper.bellmanFord(0, edges, nVertices);
        assertArrayEquals(new int[]{0, -1, 2, -2, 1}, distance);
    }

    @Test
    public void bellmanFord2() {
        int[][] matrix = {{0, 2, 2, 2, -1}, {9, 0, 2, 2, -1}, {9, 3, 0, 2, -1}, {9, 3, 2, 0, -1}, {9, 3, 2, 2, 0}};

        ArrayList<Edge> edges = Helper.getEdges(matrix);
        int nVertices = matrix[0].length;
        int[] distance = Helper.bellmanFord(0, edges, nVertices);
        assertArrayEquals(new int[]{0, 2, 1, 1, -1}, distance);
    }

    @Test
    public void bellmanFord3() {
        int[][] matrix = {{0, 2, 2, 2, -1}, {9, 0, 2, 2, -1}, {9, 3, 0, 2, -1}, {9, 3, 2, 0, -1}, {9, 3, 2, 2, 0}};

        ArrayList<Edge> edges = Helper.getEdges(matrix);
        int nVertices = matrix[0].length;
        int[] distance = Helper.bellmanFord(1, edges, nVertices);
        assertArrayEquals(new int[]{8, 0, 1, 1, -1}, distance);
    }

    @Test
    public void permutations1() {
        ArrayList<Object> input = new ArrayList<>();
        input.add(0);
        input.add(1);
        input.add(2);

        ArrayList<List<Object>> expected = new ArrayList<>();

        ArrayList<Object> p1 = new ArrayList<>();
        p1.add(0);
        expected.add(p1);

        ArrayList<Object> p2 = new ArrayList<>();
        p2.add(1);
        expected.add(p2);

        ArrayList<Object> p3 = new ArrayList<>();
        p3.add(2);
        expected.add(p3);

        ArrayList<ArrayList<Object>> result = Helper.permutations(1, input);
        assertEquals(expected.toString(), result.toString());
    }

    @Test
    public void permutations2() {
        ArrayList<Object> input = new ArrayList<>();
        input.add(0);
        input.add(1);
        input.add(2);

        ArrayList<List<Object>> expected = new ArrayList<>();

        ArrayList<Object> p1 = new ArrayList<>();
        p1.add(0);
        p1.add(1);
        expected.add(p1);

        ArrayList<Object> p2 = new ArrayList<>();
        p2.add(0);
        p2.add(2);
        expected.add(p2);

        ArrayList<Object> p3 = new ArrayList<>();
        p3.add(1);
        p3.add(0);
        expected.add(p3);

        ArrayList<Object> p4 = new ArrayList<>();
        p4.add(1);
        p4.add(2);
        expected.add(p4);

        ArrayList<Object> p5 = new ArrayList<>();
        p5.add(2);
        p5.add(0);
        expected.add(p5);

        ArrayList<Object> p6 = new ArrayList<>();
        p6.add(2);
        p6.add(1);
        expected.add(p6);

        ArrayList<ArrayList<Object>> result = Helper.permutations(2, input);
        assertEquals(expected.toString(), result.toString());
    }

    @Test
    public void getDistances() {
        int[][] matrix = {{0, 2, 2, 2, -1}, {9, 0, 2, 2, -1}, {9, 3, 0, 2, -1}, {9, 3, 2, 0, -1}, {9, 3, 2, 2, 0}};

        Graph graph = new Graph(matrix);
        int[][] distances = graph.getDistances();

        int[][] expected = {{0, 2, 1, 1, -1}, {8, 0, 1, 1, -1}, {8, 2, 0, 1, -1}, {8, 2, 1, 0, -1}, {9, 3, 2, 2, 0}};
        assertArrayEquals(expected, distances);
    }

    @Test
    public void getTime() {
        int[][] matrix = {{0, 2, 2, 2, -1}, {9, 0, 2, 2, -1}, {9, 3, 0, 2, -1}, {9, 3, 2, 0, -1}, {9, 3, 2, 2, 0}};
        Graph graph = new Graph(matrix);

        int[][] distances = graph.getDistances();

        int time = Helper.getPathTime(distances, new int[]{2, 3});
        assertEquals(0, time);
    }
}
