package IOStuff;

import java.util.ArrayList;
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
        String str = s.nextLine();
        while(str.length()>0){
            numbers.add(Integer.parseInt(str));
            System.out.println("Enter number:");
            str = s.nextLine();
        }

        System.out.println("Index is:"+num);
        System.out.println("Array is:"+numbers);
    }

}
