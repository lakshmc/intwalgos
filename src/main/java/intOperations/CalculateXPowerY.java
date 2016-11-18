package intOperations;

/**
 * Q: Given two int a, b, print a^b
 *
 * S:
 * 1. Brute force: multiple inside a loop. O(B) time
 * 2. Square and half: for each step,
 *      a. if b is even: square the base and half the power
 *      b. if b is odd: multiple a with square of a, and half the power
 *    - takes O(log(b))
 */
public class CalculateXPowerY {
    public static void main(String[] args) {
        System.out.println(power(3,5));
    }

    private static int power(int a, int b) {
        if(b==0) return 1;

        if(b==1) return a;

        if(b%2==0){
            return power(a*a, b/2); // square the base and half the power
        } else {
            return a * power(a*a, b/2); // same as above, but multiply base once
        }
    }
}
