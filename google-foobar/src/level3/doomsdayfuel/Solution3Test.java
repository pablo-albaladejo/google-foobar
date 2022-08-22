package level3.doomsdayfuel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Solution3Test {
    @Test
    public void testCase1(){
        int input[][] = {{0, 2, 1, 0, 0}, {0, 0, 0, 3, 4}, {0, 0, 0, 0, 0}, {0, 0, 0, 0,0}, {0, 0, 0, 0, 0}};
        int output[] = {7, 6, 8, 21};
        assertArrayEquals (output, Solution3.solution(input));
    };
    @Test
    public void testCase2(){
        int input[][] = {{0, 1, 0, 0, 0, 1}, {4, 0, 0, 3, 2, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}};
        int output[] = {0, 3, 2, 9, 14};
        assertArrayEquals (output, Solution3.solution(input));
    };

    @Test
    public void testCase3(){
        int input[][] = {{1,1,1},{0,1,0},{0,0,1}};
        int output[] = {1};
        assertArrayEquals (output, Solution3.solution(input));
    };

    @Test
    public void testCase4(){
        int input[][] = {{0,1,1},{0,1,0},{0,0,1}};
        int output[] = {1};
        assertArrayEquals (Solution3.solution(input), output);
    };
    @Test
    public void testCase5(){
        int input[][] ={{1, 2, 3, 0, 0, 0}, {4, 5, 6, 0, 0, 0}, {7, 8, 9, 1, 0, 0}, {0, 0, 0, 0, 1, 2}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}};
        int output[] = {1,2,3};
        assertArrayEquals (Solution3.solution(input), output);
    };
}