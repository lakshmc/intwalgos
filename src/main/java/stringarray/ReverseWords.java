package stringarray;

/**
 * Created by IntelliJ IDEA.
 * User: lmohan
 * Date: 10/13/13
 * Time: 10:26 AM
 */
public class ReverseWords {
    public static void main(String[] args){
        ReverseWords.reverseSentence("Behind you is a symbol of oppression");
        ReverseWords.reverseSentence(null);
        ReverseWords.reverseSentence("");
        ReverseWords.reverseSentence("Behindyouisasymbolofoppression");
    
        ReverseWords.reverseSentenceInPlace("Behind you is a symbol of oppression");
        ReverseWords.reverseSentenceInPlace("Behindyouisasymbolofoppression");

        ReverseWords.reverseSentenceWithoutSplit("Behind you is a symbol of oppression");
        ReverseWords.reverseSentenceWithoutSplit("Behindyouisasymbolofoppression");

        ReverseWords.reverseSentenceWithArrays("Behind you is a symbol of oppression");
        ReverseWords.reverseSentenceWithArrays("Behindyouisasymbolofoppression");

        ReverseWords.reverseSentenceWithoutSplitArrays("Behind you is a symbol of oppression");
        ReverseWords.reverseSentenceWithoutSplitArrays("Behindyouisasymbolofoppression");


    }

    /**
     * Using split(). creates new String
     */
    public static void reverseSentence(String str){
        if(str==null || str.length()==0){
            System.out.println("");
        } else {
            String[] revStrArry = str.split("\\s");
            StringBuilder strBuff = new StringBuilder();
            for(int i=revStrArry.length-1;i>=0;i--){
                strBuff.append(revStrArry[i]);
                if(str.length()!=strBuff.length()){
                    strBuff.append(" ");
                }   
            }
            System.out.println("Reversed String:"+strBuff+" of length "+strBuff.length());
        }
    }
    /**
     * Using split(), updates the array in-place
     */
    public static void reverseSentenceInPlace(String str){
        String[] revStrArry = str.split("\\s");
        int startIndex=0;
        int endIndex=revStrArry.length-1;
        while(startIndex<endIndex){
            String temp = revStrArry[startIndex];
            revStrArry[startIndex]=revStrArry[endIndex];
            revStrArry[endIndex]=temp;
            startIndex++;
            endIndex--;
            
        }
        StringBuilder strBuff = new StringBuilder();
        for(String words:revStrArry){
            strBuff.append(words);
            if(str.length()!=strBuff.length()){
                strBuff.append(" ");
            }
        }
        System.out.println("Reversed String:"+strBuff+" of length "+strBuff.length());
    }

    /**
     * using subString - For loop
     */
    public static void reverseSentenceWithoutSplit(String str){
        StringBuilder sb = new StringBuilder();
        char [] charArray = str.toCharArray();
        int endindex = charArray.length-1;
        // loop in reverse, char by char
        for(int i=charArray.length-1; i>=0; i--){
            char c = charArray[i];
            if(c==' '){
                sb.append(str.substring(i + 1, endindex+1)); // substring- start index inclusive, end index exclusive
                endindex=i-1;// move to first letter
                sb.append(c); // include the space
            }
            if(i==0){ //grab the last word
                sb.append(str.substring(i, endindex+1));
            }
        }
        if(sb.length()==0){ // handle case where string has no space
            sb.append(str);
        }
        System.out.println("Reversed String:"+sb+":length "+sb.length());
    }

    /**
     * without using any String functions - For loop
     */
    public static void reverseSentenceWithArrays(String str) {
        char[] chArr = str.toCharArray();
        char[] revArr = new char[chArr.length];
        int i;
        int j = chArr.length - 1;
        int l = 0;
        for (i = chArr.length - 1; i >= 0; i--) {
            if (chArr[i] == ' ') {
                int k = i + 1;
                while (k <= j) {
                    revArr[l++] = chArr[k++];
                }
                revArr[l++] = ' ';
                j = i - 1;
            }
        }
        //int k = i + 1;
        int k=0;
        while (k <= j) {
            revArr[l++] = chArr[k++];
        }
        String strRev = new String(revArr);
        System.out.println("Reversed String:"+strRev+":length "+strRev.length());
    }

    /**
     * using subString - while loop
     */
    public static void reverseSentenceWithoutSplitArrays(String str) {
        System.out.println("Original String:"+str+" of length "+str.length());
        StringBuilder buffer = new StringBuilder();
        int length = str.length();
        while(length >0) {
            int wordstart = length -1;
            while(wordstart >0 && str.charAt(wordstart) != ' '){
                wordstart--;
            }
            buffer.append(str.substring(wordstart==0?wordstart:wordstart+1, length));
            if(wordstart>0){
                buffer.append(" ");
            }
            length = wordstart;
        }
        System.out.println("Reversed String:"+buffer+":length "+buffer.length());
    }
}
