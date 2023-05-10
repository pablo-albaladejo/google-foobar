package level5.expandingnebula;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void testCaseGenerate055() {
        assertEquals(7, Solution.generate(0, 5, 5));
    }

    @Test
    public void testCaseGenerate0105() {
        assertEquals(15, Solution.generate(0, 10, 5));
    }

    @Test
    public void testCaseGenerate105() {
        assertEquals(1, Solution.generate(1, 0, 5));
    }

    @Test
    public void testCaseGenerate1115() {
        assertEquals(14, Solution.generate(1, 11, 5));
    }

    @Test
    public void testCaseGenerate1165() {
        assertEquals(25, Solution.generate(1, 16, 5));
    }

    @Test
    public void testCaseBuildMap11() {
        List<Integer> nums = Arrays.asList(1);
        Map<List<Integer>, Set<Integer>> result = Solution.buildMap(1, nums);

        Map<List<Integer>, Set<Integer>> expected = Stream.of(new Object[][]{
                {Arrays.asList(1, 0), Stream.of(1, 2).collect(Collectors.toSet())},
                {Arrays.asList(1, 1), Stream.of(0).collect(Collectors.toSet())},
                {Arrays.asList(1, 2), Stream.of(0).collect(Collectors.toSet())},
        }).collect(Collectors.toMap(data -> (List<Integer>) data[0], data -> (Set<Integer>) data[1]));

        assertEquals(expected, result);
    }

    @Test
    public void testCaseBuildMap12() {
        List<Integer> nums = Arrays.asList(2);
        Map<List<Integer>, Set<Integer>> result = Solution.buildMap(1, nums);

        Map<List<Integer>, Set<Integer>> expected = Stream.of(new Object[][]{
        }).collect(Collectors.toMap(data -> (List<Integer>) data[0], data -> (Set<Integer>) data[1]));

        assertEquals(expected, result);
    }

    @Test
    public void testCaseBuildMap21() {
        List<Integer> nums = Arrays.asList(1);
        Map<List<Integer>, Set<Integer>> result = Solution.buildMap(2, nums);

        Map<List<Integer>, Set<Integer>> expected = Stream.of(new Object[][]{
                {Arrays.asList(1, 0), Stream.of(1, 6).collect(Collectors.toSet())},
                {Arrays.asList(1, 1), Stream.of(0).collect(Collectors.toSet())},
                {Arrays.asList(1, 2), Stream.of(4).collect(Collectors.toSet())},
                {Arrays.asList(1, 4), Stream.of(2, 5, 6).collect(Collectors.toSet())},
                {Arrays.asList(1, 5), Stream.of(4).collect(Collectors.toSet())},
                {Arrays.asList(1, 6), Stream.of(0, 4).collect(Collectors.toSet())},
        }).collect(Collectors.toMap(data -> (List<Integer>) data[0], data -> (Set<Integer>) data[1]));

        assertEquals(expected, result);
    }

    @Test
    public void testCase1() {
        boolean[][] g = {{true, false, true}, {false, true, false}, {true, false, true}};
        assertEquals(4, Solution.solution(g));
    }

    @Test
    public void testCase2() {
        boolean[][] g = {{true, true, false, true, false, true, false, true, true, false}, {true, true, false, false, false, false, true, true, true, false}, {true, true, false, false, false, false, false, false, false, true}, {false, true, false, false, false, false, true, true, false, false}};
        assertEquals(11567, Solution.solution(g));
    }

    @Test
    public void testCase3() {
        boolean[][] g = {{true, false, true, false, false, true, true, true}, {true, false, true, false, false, false, true, false}, {true, true, true, false, false, false, true, false}, {true, false, true, false, false, false, true, false}, {true, false, true, false, false, true, true, true}};
        assertEquals(254, Solution.solution(g));
    }


}
