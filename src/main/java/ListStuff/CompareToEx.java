package ListStuff;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: lmohan
 * Date: 10/6/13
 * Time: 7:20 PM
 */

public class CompareToEx {

    public static void main(String[] args){
        Application ap = new Application();
        ap.setId("1");
        Application ap2 = new Application();
        ap2.setId("2");
        List<Application> applicationList = new ArrayList<Application>();
        applicationList.add(ap2);
        applicationList.add(ap);
        System.out.println(applicationList.get(0).getId());
        System.out.println(applicationList.get(1).getId());
        Collections.sort(applicationList);
        System.out.println(applicationList.get(0).getId());
        System.out.println(applicationList.get(1).getId());
    }
}

class Application implements Comparable<Application>{

    private String id;
    private int id2;

    @Override
    public int compareTo(Application application) {
        return Integer.parseInt(this.id) - Integer.parseInt(application.getId());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getId2() {
        return id2;
    }

    public void setId2(int id2) {
        this.id2 = id2;
    }
}
