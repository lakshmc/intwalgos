package IOStuff;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * when the user runs the class
 *  - provide an int value
 *  - then provides a series of numbers
 *  - when an empty input is given, print the initial integer and all the numbers entered in sequence
 *  - exit
 */
public class UserInputArray {

    public static void main(String[] args) {
        int num = Integer.parseInt(args[0]);
        List<Integer> numbers = new ArrayList<Integer>();
        Scanner s = new Scanner(System.in);

        System.out.println("Enter number:");
       /* int i=0;
        while(i>=0){
            if(!s.hasNextInt()){
                System.out.println("Only numbers allowed");
                s.next(); // discard
            } else {
                System.out.println("Enter number:");
                i = s.nextInt();
                numbers.add(i);
            }
        }*/


        try{
            int i = s.nextInt();
            while(i>-1){
                numbers.add(i);
                System.out.println("Enter number:");
                i = s.nextInt();
            }
            System.out.println("Index is:"+num);
            System.out.println("Array is:" + numbers);
        } catch (InputMismatchException e){
            System.out.println("Only numbers are allowed:"+e.toString());
        }


    }

}
