package publishSubscribe;

/**
 * Created on 4/30/14.
 */
public interface Publisher<T> {
//    void register(Subscriber<T> subscriber);
    void register(T key, Subscriber<T> subscriber);

    void unSubsribe(T key, Subscriber<T> subscriber);

    void publish(T key, T message);
}
