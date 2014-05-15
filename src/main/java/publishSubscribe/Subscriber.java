package publishSubscribe;

/**
 * Created on 4/30/14.
 */
public interface Subscriber<E> {
    void getSubscription(E message);
}
