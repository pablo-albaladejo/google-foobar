package level3.doomsdayfuel;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {

    @Test
    public void test0(){
        Fraction a = new Fraction(BigInteger.valueOf(6397),BigInteger.valueOf(7500));
        Fraction b = new Fraction(BigInteger.valueOf(4448119),BigInteger.valueOf(42952500));
        assertEquals(0.7493743088295209, a.sub(b).toDouble());
    }
    @Test
    public void testCase1(){
        int input[][] = {{0, 2, 1, 0, 0}, {0, 0, 0, 3, 4}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};
        int output[] = {7, 6, 8, 21};
        assertArrayEquals (Solution.solution(input), output);
    };
    @Test
    public void testCase2(){
        int input[][] = {{0, 2, 1, 0, 0}, {0, 0, 0, 3, 4}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};
        int output[] = {7, 6, 8, 21};
        assertArrayEquals (Solution.solution(input), output);
    };
    @Test
    public void testCase3(){
        int input[][] = {{1, 2, 3, 0, 0, 0}, {4, 5, 6, 0, 0, 0}, {7, 8, 9, 1, 0, 0}, {0, 0, 0, 0, 1, 2}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}};
        int output[] = {1,2,3};
        assertArrayEquals (Solution.solution(input), output);
    };

    @Test
    public void testCase4(){
        int input[][] = {{0}};
        int output[] = {1,1};
        assertArrayEquals (Solution.solution(input), output);
    };

    @Test
    public void testCase5(){ //inverse
        int input[][] = {{0, 0, 12, 0, 15, 0, 0, 0, 1, 8}, {0, 0, 60, 0, 0, 7, 13, 0, 0, 0}, {0, 15, 0, 8, 7, 0, 0, 1, 9, 0}, {23, 0, 0, 0, 0, 1, 0, 0, 0, 0}, {37, 35, 0, 0, 0, 0, 3, 21, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
        int output[] = {1, 2, 3, 4, 5, 15};
        assertArrayEquals (Solution.solution(input), output);
    };

    @Test
    public void testCase6(){
        int input[][] = {{ 0,  7,  0, 17,  0,  1,  0,  5,  0,  2}, { 0,  0, 29,  0, 28,  0,  3,  0, 16,  0}, { 0,  3,  0,  0,  0,  1,  0,  0,  0,  0}, {48,  0,  3,  0,  0,  0, 17,  0,  0,  0}, { 0,  6,  0,  0,  0,  1,  0,  0,  0,  0}, { 0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, { 0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, { 0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, { 0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, { 0,  0,  0,  0,  0,  0,  0,  0,  0,  0}};
        int output[] = {4, 5, 5, 4, 2, 20};
        assertArrayEquals (Solution.solution(input), output);
    };
    @Test
    public void testCase7(){ //inverse
        int input[][] = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
        int output[] = {1, 1, 1, 1, 1, 5};
        assertArrayEquals (Solution.solution(input), output);
    };

    @Test
    public void testCase8(){ //inverse
        int input[][] = {{1, 1, 1, 0, 1, 0, 1, 0, 1, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 0, 1, 1, 1, 0, 1, 0, 1, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 0, 1, 0, 1, 1, 1, 0, 1, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 0, 1, 0, 1, 0, 1, 1, 1, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 0, 1, 0, 1, 0, 1, 0, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
        int output[] = {2, 1, 1, 1, 1, 6};
        assertArrayEquals (Solution.solution(input), output);
    };

    @Test
    public void testCase9(){ //!!
        int input[][] = {{0, 86, 61, 189, 0, 18, 12, 33, 66, 39}, {0, 0, 2, 0, 0, 1, 0, 0, 0, 0}, {15, 187, 0, 0, 18, 23, 0, 0, 0, 0}, {1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
        int output[] = {6, 44, 4, 11, 22, 13, 100};
        assertArrayEquals (Solution.solution(input), output);
    };

    @Test
    public void testCase10(){ //inverse
        int input[][] = {{0, 0, 0, 0, 3, 5, 0, 0, 0, 2}, {0, 0, 4, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 4, 4, 0, 0, 0, 1, 1}, {13, 0, 0, 0, 0, 0, 2, 0, 0, 0}, {0, 1, 8, 7, 0, 0, 0, 1, 3, 0}, {1, 7, 0, 0, 0, 0, 0, 2, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
        int output[] = {1, 1, 1, 2, 5};
        assertArrayEquals (Solution.solution(input), output);
    };
}
