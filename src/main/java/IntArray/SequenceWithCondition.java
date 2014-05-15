package IntArray;

/**
 * Created by IntelliJ IDEA.
 * User: lmohan
 * Date: 10/28/13
 * Time: 11:44 AM
 */

public class SequenceWithCondition {
    private static int findSequenceCount1(int[] seq) {
        int maxSequenceCount=0;
        int sequenceCount=0;
        int i=1;
        while(i<seq.length){
            if(seq[i-1] <= seq[i]){
                sequenceCount++;
            }
            if(seq[i-1] > seq[i] || i==seq.length-1){
                if(maxSequenceCount<sequenceCount)
                    maxSequenceCount=sequenceCount+1;
                sequenceCount=0;
            }
            i++;
        }
        return maxSequenceCount;
    }

    private static int printSequence(int[] seq) {
        int maxSequenceCount=0;
        int sequenceCount=0;
        int i=1;
        int[] tempArray = new int[seq.length];
        int[] seqArray = new int[seq.length];
        while(i<seq.length){
            if(seq[i-1] <= seq[i]){
                tempArray[sequenceCount++]=seq[i-1];
            }
            if(seq[i-1] > seq[i] || i==seq.length-1){
                if(sequenceCount>0){
                    tempArray[sequenceCount++]=seq[i-1];    // add the last item of sequence
                }
                if(maxSequenceCount<sequenceCount){
                    seqArray = tempArray;
                    maxSequenceCount=sequenceCount;
                }
                sequenceCount=0;
                tempArray  = new int[seq.length];
            }
            i++;
        }
        for(int k=0;k<maxSequenceCount;k++){
            System.out.print(seqArray[k]+" ");
        }
        System.out.println("Count:"+maxSequenceCount);
        return maxSequenceCount;
    }

    public static void main (String[] args){
        int[] seq1 = {9, 7, 8, 2, 5, 5, 8, 7,9};//4
        System.out.println(findSequenceCount1(seq1));

        int[] seq2 = {1,2,3,4,5,6,7,8,9,0,0};//9
        System.out.println(findSequenceCount1(seq2));

        int[] seq3 = {1,1,1,1,1,2,2,2,2,2,3,4,3}; //12
        System.out.println(findSequenceCount1(seq3));

        int[] seq4 = {1,-1,1,-1,1,-1,1,-1,1,-1,1,-1}; //2
        System.out.println(findSequenceCount1(seq4));

        int[] seq5 = {0,0,0,0}; //4
        System.out.println(findSequenceCount1(seq5));

        int[] seq6 = {9,8,7,6,5,4,3,2,1}; //0
        System.out.println(findSequenceCount1(seq6));

        // print sequence
        printSequence(seq1);
        printSequence(seq2);
        printSequence(seq3);
        printSequence(seq4);
        printSequence(seq5);
        printSequence(seq6);
    }
}

