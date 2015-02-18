package intOperations;

/**
 * Given an integer number and base number, find the base value of the number. Eg: 5 base 2 would be 101
 *
 * soln: keep a String for conversion digits, repeatedly do modulus operation on the integer with the base value, and
 * identify the corresponding digit from the digits string. Keep repeating the process until the original number
 * becomes goes less than zero.
 */
public class BaseConverter {
    public static void main(String[] args) {
        baseConvert(15, 2);
        baseConvert(15, 8);
        baseConvert(15, 16);
    }

    private static void baseConvert(int number, int base) {
        StringBuilder str=new StringBuilder();
        int orig = number;
        String digits="0123456789ABCDEF";
        if(number == 0){
            str.append("0");
        } else {
            while(number>0){
                int rem = number % base;
                str.append(digits.charAt(rem));
                number = number/base;
            }
        }
        System.out.println("Base "+base+" of "+orig+" is "+str.reverse().toString());
    }

}
