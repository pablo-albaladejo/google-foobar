package level5.expandingnebula;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

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
