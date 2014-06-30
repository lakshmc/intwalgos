package bitoperations;

/**
 * >> is the arithmetic (or signed) right shift operator (same as dividing by powers of 2, but keeps the positive/negative sign).
 * >>> is the logical (or unsigned) right shift operator (same as dividing by powers of 2, but ignores positive/negative sign).
 * << is the left shift operator, and meets the needs of both logical and arithmetic shifts.
 *  (same as multiplying by powers of 2, but ignores positive/negative sign).
 */

public class BitShift {
    public static void main(String[] args) {

        // >> is the arithmetic (or signed) right shift operator (same as dividing by powers of 2, but keeps the positive/negative sign)
        System.out.println(4 >> 1);// divide by 2^1 = 2
        System.out.println(-32 >> 3);// divide by 8 (2^3), keeps the sign = -4

        // >>> is the logical (or unsigned) right shift operator (same as dividing by powers of 2, but ignores positive/negative sign).
        System.out.println(4 >>> 1);// divide by 2 =2
        System.out.println(-32 >>> 3);// divide by 8 (2^3), produces unsigned result = 536870908
        System.out.println(32 >>> 3);// divide by 8 (2^3), produces unsigned result = 4

        // << is the left shift operator, and meets the needs of both logical and arithmetic shifts.
        // (same as multiplying by powers of 2, but ignores positive/negative sign).
        System.out.println(4 << 1);// multiply by 2 = 8
        System.out.println(-32 << 3);// multiply by 8 (2^3), produces unsigned result = -256
    }
}
