package level5.disorderlyescape;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void testCase1() {
        assertEquals("430", Solution.solution(2, 3, 4));
    }

    @Test
    public void testCase2() {
        assertEquals("7", Solution.solution(2,2,2));
    }
}
