package level5.disorderlyescape;

import org.junit.jupiter.api.Test;

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

}
