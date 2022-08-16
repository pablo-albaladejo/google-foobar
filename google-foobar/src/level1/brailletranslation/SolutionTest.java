package level1.brailletranslation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testCase1(){
        String plaintext = "code";
        String output = "100100101010100110100010";
        assertEquals(Solution.answer(plaintext),output);
    }

    @Test
    void testCase2(){
        String plaintext = "Braille";
        String output = "000001110000111010100000010100111000111000100010";
        assertEquals(Solution.answer(plaintext),output);
    }

    @Test
    void testCase3(){
        String plaintext = "The quick brown fox jumped over the lazy dog";
        String output = "000001011110110010100010000000111110101001010100100100101000000000110000111010101010010111101110000000110100101010101101000000010110101001101100111100100010100110000000101010111001100010111010000000011110110010100010000000111000100000101011101111000000100110101010110110";
        assertEquals(Solution.answer(plaintext),output);
    }
}