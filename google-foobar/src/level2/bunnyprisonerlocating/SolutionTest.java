package level2.bunnyprisonerlocating;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testCase1(){
        long x = 3;
        long y = 2;
        String output = "9";
        assertEquals(Solution.solution(x,y),output);
    }

    @Test
    void testCase2(){
        long x = 5;
        long y = 10;
        String output = "96";
        assertEquals(Solution.solution(x,y),output);
    }

    @Test
    void testCase3(){
        long x = 100000;
        long y = 100000;
        String output = "19999800001";
        assertEquals(Solution.solution(x,y),output);
    }
}