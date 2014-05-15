package stringarray;

/**
 * Created by IntelliJ IDEA.
 * User: lmohan
 * Date: 10/30/13
 * Time: 11:41 AM
 */
public class InsertString {
    public static void main(String[] args){
        System.out.println(InsertString.insert("irass", "a gl", 2));
        System.out.println(InsertString.insert("lass", "ira g", -1));
        System.out.println(InsertString.insert("lass", "ira g", 0));
        System.out.println(InsertString.insert("ira gla", "ss", 7));
        System.out.println(InsertString.insert("ira ", "glass", 4));
    }

    private static String insert(String srcStr, String str, int pos){
        int srcLength = srcStr.length();
        if(pos<0){
            return srcStr;
        } else if(pos==0){
            return str+srcStr;
        } else if(pos==srcLength){
            return srcStr+str;
        } else{
            int i=0;
            char[] result= new char[srcLength+str.length()];
            int srcIndex=0;
            while (srcIndex<srcLength){
                result[i++]=srcStr.charAt(srcIndex++);
                if(i==pos){
                    for(int j=0;j<str.length();j++){
                        result[i++]=str.charAt(j);
                    }
                }
            }
            return (new String(result));
        }
    }
}
