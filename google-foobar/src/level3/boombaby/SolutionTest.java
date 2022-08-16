package level3.boombaby;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testCase1() {
        String mach = "2";
        String facula = "1";
        String output = "1";
        assertEquals(Solution.solution(mach,facula), output);
    }

    @Test
    void testCase2() {
        String mach = "4";
        String facula = "7";
        String output = "4";
        assertEquals(Solution.solution(mach,facula), output);
    }

    @Test
    void testCase3() {
        String mach = "2";
        String facula = "4";
        String output = "impossible";
        assertEquals(Solution.solution(mach,facula), output);
    }

    @Test
    void testCase4() {
        String mach = "1";
        String facula = "1";
        String output = "0";
        assertEquals(Solution.solution(mach,facula), output);
    }

    @Test
    void testCase5() {
        String mach = String.valueOf(new BigInteger("10").pow(50));
        String facula = "3";
        String output = "33333333333333333333333333333333333333333333333335";
        assertEquals(Solution.solution(mach,facula), output);
    }
}