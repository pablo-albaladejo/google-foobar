package level3.doomsdayfuel;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTestA {
    @Test
    public void gcd1(){
        assertEquals(Fraction.gcd(BigInteger.valueOf(54), BigInteger.valueOf(24)),BigInteger.valueOf(6));
    }
    @Test
    public void gcd2(){
        assertEquals(Fraction.gcd(BigInteger.valueOf(-1), BigInteger.valueOf(2)),BigInteger.valueOf(1));
    }
    @Test
    public void lcm1(){
        assertEquals(BigInteger.valueOf(42),Fraction.lcm(BigInteger.valueOf(21), BigInteger.valueOf(6)));
    }
    @Test
    public void lcm2(){
        assertEquals(BigInteger.valueOf(2), Fraction.lcm(BigInteger.valueOf(1), BigInteger.valueOf(2)));
    }
    @Test
    public void fractionSub1(){
        Fraction a = new Fraction(BigInteger.valueOf(3),BigInteger.valueOf(21));
        Fraction b = new Fraction(BigInteger.valueOf(4),BigInteger.valueOf(6));
        Fraction sub = a.sub(b);
        assertEquals(BigInteger.valueOf(-11), sub.num);
        assertEquals(BigInteger.valueOf(21), sub.den);
    }
    @Test
    public void fractionSub2(){
        Fraction a = new Fraction(BigInteger.valueOf(0),BigInteger.valueOf(1));
        Fraction b = new Fraction(BigInteger.valueOf(1),BigInteger.valueOf(2));
        Fraction sub = a.sub(b);
        assertEquals(BigInteger.valueOf(-1),sub.num);
        assertEquals(BigInteger.valueOf(2), sub.den);
    }
    @Test
    public void fractionSub3(){
        Fraction a = new Fraction(BigInteger.valueOf(11),BigInteger.valueOf(10));
        Fraction b = new Fraction(BigInteger.valueOf(4),BigInteger.valueOf(20));
        Fraction sub = a.sub(b);
        assertEquals(BigInteger.valueOf(9),sub.num);
        assertEquals(BigInteger.valueOf(10), sub.den);
    }
    @Test
    public void fractionMult1(){
        Fraction a = new Fraction(BigInteger.valueOf(1),BigInteger.valueOf(1));
        Fraction b = new Fraction(BigInteger.valueOf(2),BigInteger.valueOf(1));
        Fraction sub = a.mult(b);
        assertEquals(BigInteger.valueOf(2), sub.num);
        assertEquals(BigInteger.valueOf(1), sub.den);
    }
    @Test
    public void fractionMult2(){
        Fraction a = new Fraction(BigInteger.valueOf(-1),BigInteger.valueOf(2));
        Fraction b = new Fraction(BigInteger.valueOf(20),BigInteger.valueOf(2));
        Fraction sub = a.mult(b);
        assertEquals(BigInteger.valueOf(-5), sub.num);
        assertEquals(BigInteger.valueOf(1), sub.den);
    }
    @Test
    public void fractionDiv1(){
        Fraction a = new Fraction(BigInteger.valueOf(20),BigInteger.valueOf(1));
        Fraction b = new Fraction(BigInteger.valueOf(2),BigInteger.valueOf(1));
        Fraction sub = a.div(b);
        assertEquals(BigInteger.valueOf(10), sub.num);
        assertEquals(BigInteger.valueOf(1), sub.den);
    }
    @Test
    public void fractionDiv2(){
        Fraction a = new Fraction(BigInteger.valueOf(1),BigInteger.valueOf(1));
        Fraction b = new Fraction(BigInteger.valueOf(2),BigInteger.valueOf(1));
        Fraction sub = a.div(b);
        assertEquals(BigInteger.valueOf(1), sub.num);
        assertEquals(BigInteger.valueOf(2), sub.den);
    }
    @Test
    public void matrixMult1(){
       Matrix a = new Matrix(new int[][]{{1,0,1},{2,1,1}, {0,1,1},{1,1,2}});
       Matrix b = new Matrix(new int[][]{{1,2,1},{2,3,1},{4,2,2}});
       Matrix c = new Matrix(new int[][]{{5,4,3},{8,9,5},{6,5,3},{11,9,6}});
       assertArrayEquals(c.getArray(), a.mult(b).getArray());
    }
    /*@Test
    public void matrixMult2(){
        Matrix A = new Matrix(new Fraction[2][2]);
        A.set(0,0, new Fraction(9,7));
        A.set(0,1, new Fraction(9,14));
        A.set(1,0, new Fraction(4,7));
        A.set(1,1, new Fraction(9,7));

        Matrix B = new Matrix(new Fraction[2][4]);
        B.set(0,0, new Fraction(0,1));
        B.set(0,1, new Fraction(0,1));
        B.set(0,2, new Fraction(0,1));
        B.set(0,3, new Fraction(1,2));
        B.set(1,0, new Fraction(0,1));
        B.set(1,1, new Fraction(3,9));
        B.set(1,2, new Fraction(2,9));
        B.set(1,3, new Fraction(0,1));

        Matrix C = new Matrix(new Fraction[2][4]);
        C.set(0,0, new Fraction(0,1));
        C.set(0,1, new Fraction(3,14));
        C.set(0,2, new Fraction(1,7));
        C.set(0,3, new Fraction(9,14));
        C.set(1,0, new Fraction(0,1));
        C.set(1,1, new Fraction(3,7));
        C.set(1,2, new Fraction(2,7));
        C.set(1,3, new Fraction(2,7));

        assertArrayEquals(C.getArray(), A.mult(B).getArray());
    }
    @Test
    public void matrixMult3(){
        Matrix A = new Matrix(new Fraction[2][2]);
        A.set(0,0, new Fraction(4,1));
        A.set(0,1, new Fraction(7,1));
        A.set(1,0, new Fraction(2,1));
        A.set(1,1, new Fraction(6,1));

        Matrix B = new Matrix(new Fraction[2][2]);
        B.set(0,0, new Fraction(3,5));
        B.set(0,1, new Fraction(-7,10));
        B.set(1,0, new Fraction(-1,5));
        B.set(1,1, new Fraction(2,5));

        Matrix C = new MatrixIdentity(2);

        assertArrayEquals(C.getArray(), A.mult(B).getArray());
    }*/
    @Test
    public void matrixInverse1(){
        int input[][] = {{4,7},{2,6}};
        Matrix A = new Matrix(input);

        Matrix AI = A.inverse();
        MatrixIdentity I = new MatrixIdentity(input.length);
        assertArrayEquals(I.getArray(), A.mult(AI).getArray());
    }
    @Test
    public void matrixInverse2(){
        int input[][] = {{5,7,9},{4,3,8},{7,5,6}};
        Matrix A = new Matrix(input);
        Matrix AI = A.inverse();
        MatrixIdentity I = new MatrixIdentity(input.length);

        assertArrayEquals(I.getArray(), A.mult(AI).getArray());
    }
    @Test
    public void getResult1(){
        Matrix FR = new Matrix(new Fraction[1][3]);
        FR.set(0,0, new Fraction(BigInteger.valueOf(7),BigInteger.valueOf(21)));
        FR.set(0,1, new Fraction(BigInteger.valueOf(3),BigInteger.valueOf(21)));
        FR.set(0,2, new Fraction(BigInteger.valueOf(8),BigInteger.valueOf(21)));

        int[] result = new int[]{7, 3, 8, 21};

        assertArrayEquals(result, Solution.getResult(FR));
    }
    @Test
    public void getResult2(){
        Matrix FR = new Matrix(new Fraction[2][4]);
        FR.set(0,0, new Fraction(BigInteger.valueOf(0),BigInteger.valueOf(1)));
        FR.set(0,1, new Fraction(BigInteger.valueOf(3),BigInteger.valueOf(14)));
        FR.set(0,2, new Fraction(BigInteger.valueOf(1),BigInteger.valueOf(7)));
        FR.set(0,3, new Fraction(BigInteger.valueOf(9),BigInteger.valueOf(14)));

        int[] result = new int[]{0,3,2,9,14};

        assertArrayEquals(result, Solution.getResult(FR));
    }
    @Test
    public void getResult3(){
        Matrix FR = new Matrix(new Fraction[2][4]);
        FR.set(0,0, new Fraction(BigInteger.valueOf(0),BigInteger.valueOf(1)));
        FR.set(0,1, new Fraction(BigInteger.valueOf(6),BigInteger.valueOf(28)));
        FR.set(0,2, new Fraction(BigInteger.valueOf(2),BigInteger.valueOf(14)));
        FR.set(0,3, new Fraction(BigInteger.valueOf(18),BigInteger.valueOf(28)));

        int[] result = new int[]{0,3,2,9,14};

        assertArrayEquals(result, Solution.getResult(FR));
    }
}