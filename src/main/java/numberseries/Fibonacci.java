package numberseries;

/**
 * Created by IntelliJ IDEA.
 * User: lmohan
 * Date: 11/7/13
 * Time: 12:02 PM
 */

public class Fibonacci {
    public static void main(String[] args){
        // two numbers
        printFibonacciSeries2(6);
        System.out.println(fibonacciRecursive(6));
        printFibonacciSeries2(0);
        printFibonacciSeries2(1);

        // three numbers
        printFibonacciSeries3(7);
        printFibonacciSeries3(0);
        printFibonacciSeries3(1);

    }

    private static void printFibonacciSeries2(int n) {
        int f0=0, f1=1, sum=0;
        if(n==f0){
            System.out.print(f0);
        } else if(n>f0){
            System.out.print(f0 +" "+f1);
            for(int i=2;i<n;i++){
                sum=f0+f1;
                System.out.print(" " + sum);
                f0=f1;
                f1=sum;
            }
        }
        System.out.println();
    }

    private static void printFibonacciSeries3(int n) {
        int f0=0, f1=1, f2=1, sum=0;
        if(n==f0){
            System.out.print(f0);
        } else if(n==f1){
            System.out.print(f0 +" "+f1);
        } else if(n>f1){
            System.out.print(f0 +" "+f1+" "+f2);
            for(int i=2;i<n;i++){
                sum=f0+f1+f2;
                System.out.print(" " + sum);
                f0=f1;
                f1=f2;
                f2=sum;
            }
        }
        System.out.println();
    }

    /**
     * Note: doesnt print series, only the final number.
     *
     *
     */
    public static int fibonacciRecursive(int n)  {
        if(n == 0)
            return 0;
        else if(n == 1)
            return 1;
        else
            return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

}
