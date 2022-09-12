package level4.escapepods;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class SolutionTestHelpers {

    @Test
    public void getEdges() {
        int[] supersources = {0, 1};
        int[] supersinks = {4, 5};
        int[][] paths = {{0, 0, 4, 6, 0, 0}, {0, 0, 5, 2, 0, 0}, {0, 0, 0, 0, 4, 4}, {0, 0, 0, 0, 6, 6}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}};
        ArrayList<Edge> edges = Helper.getEdges(supersources, supersinks, paths);

        ArrayList<Edge> expected = new ArrayList<>();
        expected.add(new Edge(0, 2, 4));
        expected.add(new Edge(0, 3, 6));
        expected.add(new Edge(1, 2, 5));
        expected.add(new Edge(1, 3, 2));
        expected.add(new Edge(2, 4, 4));
        expected.add(new Edge(2, 5, 4));
        expected.add(new Edge(3, 4, 6));
        expected.add(new Edge(3, 5, 6));

        expected.add(new Edge(6, 0, Integer.MAX_VALUE));
        expected.add(new Edge(6, 1, Integer.MAX_VALUE));

        expected.add(new Edge(4, 7, Integer.MAX_VALUE));
        expected.add(new Edge(5, 7, Integer.MAX_VALUE));

        assertIterableEquals(expected, edges);
    }


}
