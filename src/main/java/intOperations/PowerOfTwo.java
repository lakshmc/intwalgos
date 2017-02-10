package intOperations;

/**
 * Created by lchan39
 */
public class PowerOfTwo {

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(16));
        System.out.println(isPowerOfTwo(1));
        System.out.println(isPowerOfTwo(5));
        System.out.println(isPowerOfTwo(32));
    }

    private static boolean isPowerOfTwo(int n) {
        if(n==0){
            return false;
        } else if(n==1){
            return true;
        } else if(n%2!=0){
            return false;
        } else {
            return isPowerOfTwo(n/2);
        }
    }
}
