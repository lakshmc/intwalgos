import timeStuff.TimeWatcher;

/**
 * for numbers 1 to 100, print Fizz for multiples of 5, Buzz for multiples of 3,
 * FizzBuzz for multiples of both 5 and 3 and print the number if not multiple of 3 or 5 or 15
 */

public class FizzBuzz {
    public static void main(String args[]){
        TimeWatcher.startTime();
        fizzBuzz(100);
        TimeWatcher.printElapsedTime();

        TimeWatcher.startTime();
        fizzBuzz(1000000);
        TimeWatcher.printElapsedTime();

        TimeWatcher.startTime();
        fizzBuzz_optimized(1000000);
        TimeWatcher.printElapsedTime();
    }

    private static void fizzBuzz(int n) {
        for(int i=1; i<=n; i++){
            if(i%15==0){
                //System.out.println("FizzBuzz");
            } else if(i%5==0){
                //System.out.println("Fizz");
            } else if(i%3==0){
                //System.out.println("Buzz");
            } else {
                //System.out.println(i+" ");
            }
        }
        //System.out.println();
    }

    private static void fizzBuzz_optimized(int n) {
        String[] arr = new String[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = String.valueOf(i);
        }
        for (int i = 0; i <= n; i+=3) {
            arr[i] = "Fizz";
        }
        for (int i = 0; i <= n; i+=5) {
            arr[i] = "Buzz";
        }
        for (int i = 0; i <= n; i+=15) {
            arr[i] = "FizzBuzz";
        }
        for (int i = 1; i <= n; i++) {
            //System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
