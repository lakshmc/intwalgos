package intOperations;


public class SwapNumbers {

    public static void swapUsingTempVarilable(int a, int b) {
        printPair(a,b,true);
        int temp = a;
        a = b;
        b = temp;
        printPair(a,b,false);
    }

    public static void swapWithoutUsingTempVarilable(int a, int b) {
        printPair(a,b,true);
        b = a + b;
        a = b - a;
        b = b - a;
        printPair(a,b,false);
    }

    public static void swapUsingXOR(int a, int b) {
        printPair(a,b,true);
        a = a^b;
        b = a^b;
        a = a^b;
        printPair(a,b,false);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        swapUsingTempVarilable(10, 20);
        System.out.println("***************");
        swapWithoutUsingTempVarilable(30, 40);
        System.out.println("***************");
        swapUsingXOR(30, 40);

    }

    private static void printPair(int a, int b, boolean input){
        if(input)
            System.out.println("input: a="+a+" b="+b);
        else
            System.out.println("output: a="+a+" b="+b);
    }
}
