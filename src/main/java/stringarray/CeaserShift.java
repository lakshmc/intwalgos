package stringarray;

/**
 * Created by IntelliJ IDEA.
 * User: lmohan
 * Date: 10/31/13
 * Time: 5:26 PM
 */


/**
 * Given a string 'abc' shift them by one letter-> 'bde'
 * if its z, loop around to a
 * a = 97, A=65
 * z = 122 Z=90
 */
public class CeaserShift {
    
    public static void main(String[] args){

        int a='A';
        int z='Z';

        System.out.println(caesar_shift("Achas mZz"));
        //System.out.println(z);

    }

    public static String caesar_shift(String s) {
        char[] charArray = s.toCharArray();
        char[] result = new char[charArray.length];
        for(int i=0;i<charArray.length;i++){

            if(charArray[i]==' '){
                result[i]=' ';
            } else{
                int code=charArray[i];
                if(code==122)
                    code=97;
                else if(code==90)
                    code=65;
                else
                    code++;
                result[i]=(char)code;
            }
        }
        return new String(result);
    }

}
