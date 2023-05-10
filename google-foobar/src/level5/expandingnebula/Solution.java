package level5.expandingnebula;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    public static int generate(int c1, int c2, int bitlen) {
        int a = c1 & ~(1 << bitlen);
        int b = c2 & ~(1 << bitlen);
        int c = c1 >> 1;
        int d = c2 >> 1;
        return (a & ~b & ~c & ~d) | (~a & b & ~c & ~d) | (~a & ~b & c & ~d) | (~a & ~b & ~c & d);
    }

    public static Map<List<Integer>, Set<Integer>> buildMap(int n, List<Integer> nums) {
        Map<List<Integer>, Set<Integer>> mapping = new HashMap<>();
        Set<Integer> numSet = new HashSet<>(nums);
        for (int i = 0; i < (1 << (n + 1)); i++) {
            for (int j = 0; j < (1 << (n + 1)); j++) {
                int generation = generate(i, j, n);
                if (numSet.contains(generation)) {
                    List<Integer> key = new ArrayList<>();
                    key.add(generation);
                    key.add(i);
                    mapping.computeIfAbsent(key, k -> new HashSet<>()).add(j);
                }
            }
        }
        return mapping;
    }

    public static boolean[][] transpose(boolean[][] matrix) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        boolean[][] transposedMatrix = new boolean[numCols][numRows];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }
        return transposedMatrix;
    }

    public static int solution(boolean[][] g) {
        boolean[][] matrix = transpose(g);
        int nrows = matrix.length;
        int ncols = matrix[0].length;

        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < nrows; i++) {
            int num = 0;
            for (int j = 0; j < ncols; j++) {
                num += (matrix[i][j] ? (1 << j) : 0);
            }
            nums.add(num);
        }

        Map<List<Integer>, Set<Integer>> mapping = buildMap(ncols, nums);

        Map<Integer, Integer> preimage = new HashMap<>();
        for (int i = 0; i < (1<<(ncols+1)); i++) {
            preimage.put(i, 1);
        }

        for (int row : nums) {
            Map<Integer, Integer> nextRow = new HashMap<>();
            for (int c1 : preimage.keySet()) {
                for (int c2 : mapping.getOrDefault(Arrays.asList(row, c1), new HashSet<>())) {
                    int count = nextRow.getOrDefault(c2, 0);
                    nextRow.put(c2, count + preimage.get(c1));
                }
            }
            preimage = nextRow;
        }

        int sum = 0;
        for (int count : preimage.values()) {
            sum += count;
        }
        return  sum;
    }
}


