package level5.disorderlyescape;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void testCase111() {
        assertEquals("1", Solution.solution(1, 1, 1));
    }

    @Test
    public void testCase112() {
        assertEquals("2", Solution.solution(1, 1, 2));
    }

    @Test
    public void testCase221() {
        assertEquals("1", Solution.solution(2, 2, 1));
    }

    @Test
    public void testCase234() {
        assertEquals("430", Solution.solution(2, 3, 4));
    }

    @Test
    public void testCase222() {
        assertEquals("7", Solution.solution(2, 2, 2));
    }

    @Test
    public void testCase332() {
        assertEquals("36", Solution.solution(3, 3, 2));
    }

    @Test
    public void testCase323() {
        assertEquals("92", Solution.solution(3, 2, 3));
    }


    @Test
    public void testCase333() {
        assertEquals("738", Solution.solution(3,3,3));
    }

    @Test
    public void testCase334() {
        assertEquals("8240", Solution.solution(3,3,4));
    }

    @Test
    public void testCase335() {
        assertEquals("57675", Solution.solution(3,3,5));
    }

    @Test
    public void testCase444() {
        assertEquals("7880456", Solution.solution(4,4,4));
    }

    @Test
    public void testCase445() {
        assertEquals("270656150", Solution.solution(4,4,5));
    }

    @Test
    public void testCase555() {
        assertEquals("20834113243925", Solution.solution(5,5,5));
    }

    @Test
    public void testCase4420() {
        assertEquals("1137863754106723400", Solution.solution(4,4,20));
    }

    @Test
    public void testCase5520() {
        assertEquals("23301834615661488487765745000", Solution.solution(5,5,20));
    }

    @Test
    public void testCase6620() {
        assertEquals("132560781153101038829213988789736592649360", Solution.solution(6,6,20));
    }

    @Test
    public void testCase7720() {
        assertEquals("221619886894198821201872678876163305792210161226545392840", Solution.solution(7,7,20));
    }

    @Test
    public void testCase8820() {
        assertEquals("113469378614817897312718329989374518983724697432844009920312263602471667640", Solution.solution(8,8,20));
    }

    @Test
    public void testCase121220() {
        //22300745198531341817894657615847583802746155678399565967993124561615436149415899871380763938002071429362749343044868906014253019900488985895312634973607213920301808604240055624427110400000
        //229442532802560000
        assertEquals("97195340925396730736950973830781340249131679073592360856141700148734207997877978005419735822878768821088343977969209139721682171487959967012286474628978470487193051591840", Solution.solution(12,12,20));
    }

}
