package stringarray;

import java.util.*;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by lchan39 on 3/16/15.
 */
public class FourDigitCodeCombinations {

    public static void main(String[] args) {
        new FourDigitCodeCombinations().build();
    }

    public void build(){
        StringBuilder sb = new StringBuilder("0000");
        Set<String> codeSet = new HashSet<String>();
        BlockingDeque<Integer> codeQueue = new LinkedBlockingDeque<Integer>(4);

        codeSet.add("0000");
        codeQueue.add(0);codeQueue.add(0);codeQueue.add(0);codeQueue.add(0);

        for(int i=0;i<=9;i++){
            addDigitToQueue(codeQueue,i);
            String code = getCode(codeQueue);
            if(!codeSet.contains(code)){
                codeSet.add(code);
                addToCode(sb, i);
            }
        }
        System.out.println(sb.toString());
        System.out.println("Remaining codes "+ (10003 - codeSet.size()));
    }

    private void addToCode(StringBuilder sb, int i) {
        sb.append(i);
    }

    private void addDigitToQueue(BlockingDeque<Integer> codeQueue, int i) {
        codeQueue.remove();// remove top
        codeQueue.add(i); // add new number
    }

    private String getCode(BlockingDeque<Integer> codeQueue){
        Iterator<Integer> it = codeQueue.iterator();
        return ""+it.next()+it.next()+it.next()+it.next();
    }

}
