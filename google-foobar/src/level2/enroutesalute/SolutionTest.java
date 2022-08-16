package level2.enroutesalute;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testCase1(){
        String s = ">——<";
        String output = "2";
        assertEquals(Solution.answer(s),output);
    }

    @Test
    void testCase2(){
        String s = "<<>><";
        String output = "4";
        assertEquals(Solution.answer(s),output);
    }

    @Test
    void testCase3(){
        String s = "--->-><-><-->-";
        String output = "10";
        assertEquals(Solution.answer(s),output);
    }
}