package Generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: lmohan
 * Date: 10/17/13
 * Time: 2:00 PM
  */

public class UnboundedStuff {

    List<?> wildcardList = new ArrayList<Object>();
    List<Object> objectTypeList = new ArrayList<Object>();
    
    public static void main(String[] args){
        UnboundedStuff u = new UnboundedStuff();
        //u.wildcardList.add(new Integer(1)); illegal
        u.objectTypeList.add("s");
    }
    

}
