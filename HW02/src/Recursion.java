/**
 * Your implementation of the isPalindrome and gcd methods
 *
 * @author Yue Gu
 * @userid ygu65
 * @GTID 903055355
 * @version 1.0
 */
public class Recursion {

    /**
     * Returns a boolean value representing whether the passed in character
     * sequence is a valid palindrome. A palindrome is defined as such:
     * A word, phrase, or sequence that reads the same backward as forward.
     *
     * Palindromes are recursively defined as such:
     * Case 1: An empty string or single character is considered a palindrome
     * Case 2: A string is a palindrome if and only if the first and last
     * characters are the same and the remaining string is also a palindrome
     *
     * For the purposes of this method, two characters are considered
     * 'the same' if they have the same primitive value. You do not need
     * to do any case conversion. Do NOT ignore spaces.
     *
     * This method must be computed recursively! Failure to do so will result
     * in zero credit for this method.
     *
     * @param text The sequence that will be tested
     * @return Whether the passed in word is a palindrome
     * @throws IllegalArgumentException if text is null
     */
    public static boolean isPalindrome(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Text is null");
        }
        int front = 0;
        int back = text.length() - 1;
        return recurseString(text, front, back);
    }

    private static boolean recurseString(String text, int front, int back)  {
        if (front >= back) {
            return true;
        } else  {
            if (text.charAt(front) == text.charAt(back))   {
                front++;
                back--;
                return recurseString(text, front, back);
            } else  {
                return false;
            }
        }
    }

    /**
     * Returns the greatest common divisor of integers x and y. The greatest
     * common divisor can be determined by the recursive function as follows:
     *
     * Case 1: gcd(x, y) = gcd(x-y, y) where x > y
     * Case 2: gcd(x, y) = gcd(x, y-x) where x < y
     * Case 3: gcd(x, y) = x = y where x == y
     * Case 4 (Edge case): gcd(x, y) = {x if y == 0 or y if x == 0}
     *
     * This method must be computed recursively! Failure to do so will result
     * in zero credit for this method.
     *
     * For the purposes of this assignment, do not worry about
     * handling negative numbers. Throw an IllegalArgumentException
     * if either x or y is negative.
     *
     * @param x The first integer
     * @param y The second integer
     * @throws IllegalArgumentException if either x or y is negative
     * @return The greatest common divisor of x and y
     */
    public static int gcd(int x, int y) {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("x and y must be non-negative");
        }
        if (x == 0) {
            return y;
        }
        if (y == 0 || x == y) {
            return x;
        }
        if (x < y)  {
            return gcd(x, y - x);
        } else {
            return gcd(x - y, y);
        }
    }
}
