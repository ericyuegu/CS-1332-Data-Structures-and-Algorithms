import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;

/**
 * This is a basic set of unit tests for Recursion. Passing these does
 * NOT guarantee any grade on this assignment. This is only a sanity check to
 * help you get started on the homework and writing JUnits in general.
 *
 * @author Will Crawford
 * @version 1.0
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RecursionWillTests {
    public static final int TIMEOUT = 200;

    //Will's Tests

    //Palindrome
    //Length 1 Test
    @Test(timeout = TIMEOUT)
    public void testPalindromeLengthOne() {
        assertTrue(Recursion.isPalindrome("a"));
    }

    //Length 2 Test
    @Test(timeout = TIMEOUT)
    public void testPalindromeLengthTwo() {
        assertTrue(Recursion.isPalindrome("aa"));
    }

    //Length 2 Negative Test
    @Test(timeout = TIMEOUT)
    public void testPalindromeLengthTwoNegative() {
        assertFalse(Recursion.isPalindrome("ab"));
    }

    //Odd Length Test
    @Test(timeout = TIMEOUT)
    public void testPalindromeOddLength() {
        assertTrue(Recursion.isPalindrome("abcdcba"));
    }

    //Even Length Test
    @Test(timeout = TIMEOUT)
    public void testPalindromeEvenLength() {
        assertTrue(Recursion.isPalindrome("abcddcba"));
    }

    //Odd Length Negative Test
    @Test(timeout = TIMEOUT)
    public void testPalindromeOddNegative() {
        assertFalse(Recursion.isPalindrome("stars"));
    }

    //Even Length Negative Test
    @Test(timeout = TIMEOUT)
    public void testPalindromeEvenNegative() {
        assertFalse(Recursion.isPalindrome("racecars"));
    }

    //GCD
    //x > y
    @Test(timeout = TIMEOUT)
    public void testGCDXGreater() {
        assertEquals(12, Recursion.gcd(48, 36));
    }

    @Test(timeout = TIMEOUT)
    public void testGCDYGreater() {
        assertEquals(12, Recursion.gcd(36, 48));
    }

    //X is 0
    @Test(timeout = TIMEOUT)
    public void testGCDXZero() {
        assertEquals(42, Recursion.gcd(0, 42));
    }

    //Y is 0
    @Test(timeout = TIMEOUT)
    public void testGCDYZero() {
        assertEquals(42, Recursion.gcd(42, 0));
    }

    //Illegal argument
    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testGCDNegativeInput() {
        Recursion.gcd(-7, 42);
    }

    //Large input test
    // (Note: An efficient implementation will not stack overflow,
    //  and will finish in only a few milliseconds.)
    
    //Test removed due to implementation instructions
    /*
    @Test(timeout = TIMEOUT)
    public void testGCDLarge() {
        assertEquals(2, Recursion.gcd(1234567890, 2));
    }
    */


}
