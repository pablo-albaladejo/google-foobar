package level3.doomsdayfuel;
import java.util.ArrayList;
import java.util.stream.IntStream;
class Fraction {
    int num;
    int den;
    public Fraction(int num, int den) {
        this.num = num;
        this.den = den;
    }
    public Fraction sub(Fraction b) {
        int lcmAB = lcm(this.den, b.den);
        int lcmA = lcmAB / this.den;
        int lcmB = lcmAB / b.den;
        int numA = this.num * lcmA;
        int numB = b.num * lcmB;
        return new Fraction(numA - numB, lcmAB).reduce();
    }
    public Fraction add(Fraction b) {
        int lcmAB = lcm(this.den, b.den);
        int lcmA = lcmAB / this.den;
        int lcmB = lcmAB / b.den;
        int numA = this.num * lcmA;
        int numB = b.num * lcmB;
        return new Fraction(numA + numB, lcmAB).reduce();
    }
    public Fraction mult(Fraction b) {
        return new Fraction(this.num * b.num, this.den * b.den).reduce();
    }
    public Fraction div(Fraction b) {
        return new Fraction(this.num * b.den, this.den * b.num).reduce();
    }
    public Fraction abs() {
        return new Fraction(Math.abs(this.num), Math.abs(this.den));
    }
    public Fraction reduce() {
        if (this.num == 0) return new Fraction(0, 1);
        if (this.num == this.den) return new Fraction(1, 1);
        int gcdAB = gcd(this.num, this.den);
        if (gcdAB == 1) return this;
        int a = Math.floorDiv(this.num, gcdAB);
        int b = Math.floorDiv(this.den, gcdAB);
        return new Fraction(a, b);
    }
    static int gcd(int x, int y) {
        int a = Math.abs(x);
        int b = Math.abs(y);
        while (b > 1) {
            int c = a % b;
            a = b;
            b = c;
        }
        return b == 1 ? 1 : a;
    }
    static int lcm(int a, int b) {
        int result = Math.abs(a * b) / gcd(a, b);
        return result == 1 ? a * b : result;
    }
    @Override
    public boolean equals(Object obj) {
        return obj.toString().equals(this.toString());
    }
    @Override
    public String toString() {
        return this.num + "\\" + this.den;
    }
}
class Matrix {
    Fraction[][] m;
    public Matrix() {
    }
    public Matrix(Fraction[][] m) {
        this.m = m;
    }
    public Matrix(int[][] m) {
        this.m = new Fraction[m.length][m[0].length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                this.m[i][j] = new Fraction(m[i][j], 1);
            }
        }
    }
    public Fraction[][] getArray() {
        return this.m;
    }
    public int getN() {
        return this.m.length;
    }
    public int getM() {
        return this.m[0].length;
    }
    public Fraction get(int x, int y) {
        return this.m[x][y];
    }
    public void set(int x, int y, Fraction value) {
        this.m[x][y] = value;
    }
    public Matrix sub(Matrix b) {
        Fraction[][] result = new Fraction[m.length][m[0].length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                result[i][j] = this.get(i, j).sub(b.get(i, j));
            }
        }
        return new Matrix(result);
    }
    public void gaussian(Fraction a[][], int index[]) {
        int n = index.length;
        Fraction c[] = new Fraction[n];

        // Initialize the index
        for (int i = 0; i < n; ++i)
            index[i] = i;

        // Find the rescaling factors, one from each row
        for (int i = 0; i < n; ++i) {
            Fraction c1 = new Fraction(0, 1);
            for (int j = 0; j < n; ++j) {
                Fraction c0 = a[i][j].abs();
                if (c0.sub(c1).num > 0) c1 = c0;
            }
            c[i] = c1;
        }

        // Search the pivoting element from each column
        int k = 0;
        for (int j = 0; j < n - 1; ++j) {
            Fraction pi1 = new Fraction(0, 1);
            for (int i = j; i < n; ++i) {
                Fraction pi0 = a[index[i]][j].abs();
                pi0 = pi0.div(c[index[i]]);
                if (pi0.sub(pi1).num > 0) {
                    pi1 = pi0;
                    k = i;
                }
            }

            // Interchange rows according to the pivoting order
            int itmp = index[j];
            index[j] = index[k];
            index[k] = itmp;
            for (int i = j + 1; i < n; ++i) {
                Fraction pj = a[index[i]][j].div(a[index[j]][j]);

                // Record pivoting ratios below the diagonal
                a[index[i]][j] = pj;

                // Modify other elements accordingly
                for (int l = j + 1; l < n; ++l)
                    a[index[i]][l] = a[index[i]][l].sub(pj.mult(a[index[j]][l]));
            }
        }
    }
    public Matrix inverse() {
        int n = this.m.length;
        Fraction[][]a = new Fraction[n][n];
        Fraction x[][] = new Fraction[n][n];
        Fraction b[][] = new Fraction[n][n];
        for (int i = 0; i < n; i ++){
            for (int j = 0; j < n; j ++){
                a[i][j] = this.m[i][j];
                x[i][j] = new Fraction(0,1);
                b[i][j] = new Fraction(0,1);
            }
        }
        int index[] = new int[n];
        for (int i = 0; i < n; ++i)
            b[i][i] = new Fraction(1,1);

        gaussian(a, index);

        for (int i = 0; i < n - 1; ++i)
            for (int j = i + 1; j < n; ++j)
                for (int k = 0; k < n; ++k)
                    b[index[j]][k] = b[index[j]][k].sub(a[index[j]][i].mult(b[index[i]][k]));

        for (int i = 0; i < n; ++i) {
            x[n - 1][i] = b[index[n - 1]][i].div(a[index[n - 1]][n - 1]);
            for (int j = n - 2; j >= 0; --j) {
                x[j][i] = b[index[j]][i];
                for (int k = j + 1; k < n; ++k) {
                    x[j][i] = x[j][i].sub(a[index[j]][k].mult(x[k][i]));
                }
                x[j][i] = x[j][i].div(a[index[j]][j]);
            }
        }
        return new Matrix(x);
    }
    private Fraction product(Matrix a, Matrix b, int i, int j) {
        Fraction acc = new Fraction(0, 1);
        for (int k = 0; k < a.getM(); k++) {
            acc = acc.add(a.get(i, k).mult(b.get(k, j)));
        }
        return acc;
    }
    public Matrix mult(Matrix b) {
        Matrix result = new Matrix(new int[this.getN()][b.getM()]);
        for (int i = 0; i < result.getN(); i++) {
            for (int j = 0; j < result.getM(); j++) {
                result.set(i, j, product(this, b, i, j));
            }
        }
        return result;
    }
    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                str += m[i][j] + "\t";
            }
            str += "\n";
        }
        return str;
    }
}
class MatrixIdentity extends Matrix {
    public MatrixIdentity(int size) {
        super();
        this.m = new Fraction[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.m[i][j] = i == j ? new Fraction(1, 1) : new Fraction(0, 1);
            }
        }
    }
}
public class Solution {
    static Integer[][] defineStates(int[][] m) {
        ArrayList<Integer> terminal = new ArrayList<>();
        ArrayList<Integer> nonTerminal = new ArrayList<>();
        for (int i = 0; i < m.length; i++) {
            int sum = IntStream.of(m[i]).sum();
            if (sum == 0) terminal.add(i);
            else nonTerminal.add(i);
        }
        return new Integer[][]{
                terminal.toArray(new Integer[]{}),
                nonTerminal.toArray(new Integer[]{})
        };
    }
    static int posAtArray(int n, Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (n == arr[i]) return i;
        }
        return -1;
    }
    static Matrix[] getRQMatrix(int[][] m, Integer[] terminalStates, Integer[] nonTerminalStates) {
        Fraction[][] R = new Fraction[nonTerminalStates.length][terminalStates.length];
        Fraction[][] Q = new Fraction[nonTerminalStates.length][nonTerminalStates.length];
        for (int i = 0; i < nonTerminalStates.length; i++) {
            int sum = IntStream.of(m[i]).sum();

            for (int j = 0; j < m.length; j++) {
                Fraction prob = new Fraction(m[nonTerminalStates[i]][j], sum).reduce();

                int posTerminal = posAtArray(j, terminalStates);
                int posNonTerminal = posAtArray(j, nonTerminalStates);

                if (posTerminal > -1) R[i][posTerminal] = prob;
                if (posNonTerminal > -1) Q[i][posNonTerminal] = prob;
            }
        }
        return new Matrix[]{new Matrix(R), new Matrix(Q)};
    }
    public static int[] getResult(Matrix m) {
        int[] result = new int[m.getM() + 1];
        result[result.length - 1] = 1;
        for (int i = 0; i < m.getM(); i++) {
            result[result.length - 1] = Fraction.lcm(m.get(0, i).reduce().den, result[result.length - 1]);
        }
        for (int i = 0; i < m.getM(); i++) {
            Fraction f = m.get(0, i).reduce();
            result[i] = Math.floorDiv(result[result.length - 1], f.den) * f.num;
        }
        return result;
    }
    public static int[] solution(int[][] m) {
        Integer[][] states = defineStates(m);
        Integer[] terminalStates = states[0];
        Integer[] nonTerminalStates = states[1];
        Matrix[] RQMatrix = getRQMatrix(m, terminalStates, nonTerminalStates);

        Matrix R = RQMatrix[0];
        Matrix Q = RQMatrix[1];
        Matrix I = new MatrixIdentity(nonTerminalStates.length);
        Matrix F = I.sub(Q).inverse();
        Matrix FR = F.mult(R);

        return getResult(FR);
    }
}
