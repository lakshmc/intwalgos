/**
 * Created by IntelliJ IDEA.
 * User: lmohan
 * Date: 11/17/13
 * Time: 1:52 PM
 * To change this template use File | Settings | File Templates.
 */
 class A {

    int a=7;

    StringBuilder sb = new StringBuilder("super");

    public void setVarA(){
        a=-1;
    }
    public String getString(){
        return sb.toString();
    }
    public void setSb(){
        sb.append("parent updated");
    }
}

class Test2 extends A{
    StringBuilder sb = new StringBuilder("child");

   int a=5;

   public void setVarA(){
       System.out.println("setting a to 10");
       a=10;
   }
    public String getString(){
        return sb.toString();
    }
    public void setSb(){
        sb.append("child updated");
    }

}

public class TestTest {
    public static void  main(String[] args){

        A a = new Test2();

        System.out.println(a.a+" "+a.sb);
        a.setVarA();
        a.setSb();
        System.out.println(a.a+" "+a.sb);
        
        Test2 t = (Test2) a;
        System.out.println(t.a);
    }
}
