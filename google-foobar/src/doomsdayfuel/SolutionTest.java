package doomsdayfuel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    public void testCase1(){
        int input[][] = {{0, 2, 1, 0, 0}, {0, 0, 0, 3, 4}, {0, 0, 0, 0, 0}, {0, 0, 0, 0,0}, {0, 0, 0, 0, 0}};
        int output[] = {7, 6, 8, 21};
        assertArrayEquals (Solution.solution(input), output);
    };
    @Test
    public void testCase2(){
        int input[][] = {{0, 1, 0, 0, 0, 1}, {4, 0, 0, 3, 2, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}};
        int output[] = {0, 3, 2, 9, 14};
        assertArrayEquals (Solution.solution(input), output);
    };
}