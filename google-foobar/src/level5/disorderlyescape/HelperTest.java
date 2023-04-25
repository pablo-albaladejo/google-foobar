package level5.disorderlyescape;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class HelperTest {

    @Test
    public void testFactorial0() {
        assertEquals("1", Helper.factorial(0).toString());
    }

    @Test
    public void testFactorial1() {
        assertEquals("1", Helper.factorial(1).toString());
    }

    @Test
    public void testFactorial5() {
        assertEquals("120", Helper.factorial(5).toString());
    }

    @Test
    public void testFactorial32() {
        assertEquals("263130836933693530167218012160000000", Helper.factorial(32).toString());
    }

    @Test
    public void testFactorial41() {
        assertEquals("33452526613163807108170062053440751665152000000000", Helper.factorial(41).toString());
    }

    @Test
    public void testFactorial45() {
        assertEquals("119622220865480194561963161495657715064383733760000000000", Helper.factorial(45).toString());
    }


    @Test
    public void gcd11() {
        assertEquals(1, Helper.gcd(1, 1));
    }

    @Test
    public void gcd35() {
        assertEquals(1, Helper.gcd(3, 5));
    }

    @Test
    public void gcd812() {
        assertEquals(4, Helper.gcd(8, 12));
    }

    @Test
    public void gcd128() {
        assertEquals(4, Helper.gcd(12, 8));
    }

    @Test
    public void gcd4818() {
        assertEquals(6, Helper.gcd(48, 18));
    }

    @Test
    public void partitions2() {
        List<List<Integer>> actual = Helper.accelAsc(2);
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1, 1),
                Arrays.asList(2)
        );
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void partitions5() {
        List<List<Integer>> actual = Helper.accelAsc(5);
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1, 1, 1, 1, 1),
                Arrays.asList(1, 1, 1, 2),
                Arrays.asList(1, 1, 3),
                Arrays.asList(1, 2, 2),
                Arrays.asList(1, 4),
                Arrays.asList(2, 3),
                Arrays.asList(5)
        );
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void expSummation112() {
        int actual = Helper.expSummation(Arrays.asList(1, 1), Arrays.asList(2));
        assertEquals(2, actual);
    }

    @Test
    public void expSummation1111() {
        int actual = Helper.expSummation(Arrays.asList(1, 1), Arrays.asList(1,1));
        assertEquals(4, actual);
    }

    @Test
    public void expSummation22() {
        int actual = Helper.expSummation(Arrays.asList(2), Arrays.asList(2));
        assertEquals(2, actual);
    }


}
