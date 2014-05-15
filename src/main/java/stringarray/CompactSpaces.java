package stringarray;

/**
 * Created by IntelliJ IDEA.
 * User: lmohan
 * Date: 11/6/13
 * Time: 9:56 AM
 */

public class CompactSpaces {

    public static void main(String[] args){
        compacter("My    name    is  Billa         !");
        compacter("                    Batman     ");
        compacter("                         ");
    } 
    
    public static void compacter(String str){
        char[] s = str.toCharArray();
        char[] result= new char[s.length];
        int k=0;
        boolean hasSpace=false;
        for(int i=0;i<s.length;i++){
            if(s[i]==' '){
                hasSpace=true;
            } else {
                if(hasSpace){
                    hasSpace=false;
                    if(k>0 && result[k-1]!=' '){
                        result[k++]=' ';
                    }
                }
                result[k++]=s[i];
            }
        }
        String st = new String(result).trim();
        System.out.println(st+"("+st.length()+")");
    }
    
    
}
