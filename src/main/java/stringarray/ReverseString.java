package stringarray;

//import com.algo.StopWatch;


public class ReverseString {

    public static String reverse_using_recursion_BigO_O_n(String str) {
        System.out.println("Incoming String:"+str);
        if ((null == str) || (str.length()  <= 1)) {
            return str;
        }
        return reverse_using_recursion_BigO_O_n(str.substring(1)) + str.charAt(0);
    }

    public static String reverse_BigO_O_n(String str) {
        char []array = str.toCharArray();
        char []reverse = new char[array.length];
        int start = 0;

        for(int i = array.length-1; i >=0 ; i--) {
            reverse[start++] = array[i];
        }

        return new String(reverse);
    }

    public static String reverse_BigO_On_05(String str) {
        assertNull(str);

        char []array = str.toCharArray();
        int start = 0;
        int end = array.length -1;

        while(start < end) {
            char temp = array[end];
            array[end--] = array[start];
            array[start++] = temp;
            //start++;
            //end--;
        }
        return new String(array);
    }

    private static void assertNull(String str) {
        if(str == null || str.equals(""))
            throw new IllegalArgumentException("String must be not-null");
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        String str = "superman";
        //StopWatch stopWatch = new StopWatch();
        //System.out.println("Reverse (Big-O = O(n) factor .5):"+reverse_BigO_On_05(str));
        //System.out.println("Interval :"+stopWatch.getInterval());
        //System.out.println("Reverse (Big-O = O(n) ):"+reverse_BigO_O_n(str));
        //System.out.println("Interval :"+stopWatch.getInterval());
        System.out.println("Reverse using recursion (Big-O = O(n) ):"+reverse_using_recursion_BigO_O_n(str));
        //System.out.println("Interval :"+stopWatch.getInterval());
    }

}
