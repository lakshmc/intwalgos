package ListStuff;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: lmohan
 * Date: 10/16/13
 * Time: 5:22 PM
 */

public class LevelSumming {

    /**
     * Test case 1 : {{1,1},2,{1,1}}, level sum = 10 (four 1's at depth 2, one 2 at depth 1)
     * Test case 2 : {1,{4,{6}}} level sum = 27 (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3)
     */

    public static void main(String[] args) {
        printStuff(depthSum(getTestCase1()),10);
        printStuff(depthSum(getTestCase2()),27);
    }


    private static int depthSum(List levelList) {
        //implement this
        return 0;
    }

    private static List getTestCase1() {
        List level2List = new ArrayList();
        level2List.add(1);
        level2List.add(1);
        List level1List = new ArrayList();
        level1List.add(level2List);
        level1List.add(2);
        level1List.add(level2List);
        return level1List;
    }

    private static List getTestCase2() {
        List level3List = new ArrayList();
        level3List.add(6);
        List level2List = new ArrayList();
        level2List.add(4);
        level2List.add(level3List);
        List level1List = new ArrayList();
        level1List.add(1);
        level1List.add(level2List);
        return level1List;
    }

    private static void printStuff(int sum, int expected){
        if(sum == expected){
            System.out.println("failed. got:"+sum+" expected:"+expected);
        }
    }
}
