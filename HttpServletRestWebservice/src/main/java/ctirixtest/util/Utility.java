package ctirixtest.util;

import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Utility {

    private static final String CHARSET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static Random rnd = new Random(new Date().getTime());

    public static String randomString( int len )
    {
        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i < len; i++ )
            sb.append( CHARSET.charAt( rnd.nextInt(CHARSET.length()) ) );
        return sb.toString();
    }

    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();

        for(int i=0;i<100000000;i++){
            String s =randomString(20);
            boolean b = set.add(s);
            if(!b){
                System.out.println("Duplicate: "+s);
                break;
            }
        }

    }
}
