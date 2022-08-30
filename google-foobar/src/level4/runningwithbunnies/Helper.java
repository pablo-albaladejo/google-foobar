package level4.runningwithbunnies;

import java.util.ArrayList;
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
}