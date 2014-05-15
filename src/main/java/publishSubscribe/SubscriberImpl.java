package publishSubscribe;

/**
 * Created on 4/30/14.
 */
public class SubscriberImpl<E> implements Subscriber<E> {
    private String name;

    SubscriberImpl(String name){
        this.name=name;
    }

    @Override
    public void getSubscription(E message) {
        System.out.println("Recieved "+ message+" by "+name);
    }
}
