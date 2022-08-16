package thegrandeststaircaseofthemall;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void testCase1(){
        int input = 3;
        int output = 1;
        assertEquals (Solution.solution(input), output);
    };

    @Test
    public void testCase2(){
        int input = 200;
        int output = 487067745;
        assertEquals (Solution.solution(input), output);
    };

    @Test
    public void testCase3(){
        int input = 4;
        int output = 1;
        assertEquals (Solution.solution(input), output);
    };

    @Test
    public void testCase4(){
        int input = 5;
        int output = 2;
        assertEquals (Solution.solution(input), output);
    };
}
