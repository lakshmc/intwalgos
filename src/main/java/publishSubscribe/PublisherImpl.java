package publishSubscribe;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created on 4/30/14.
 */
public class PublisherImpl<T> implements Publisher<T> {
    //Set<Subscriber<T>> subscribers = new HashSet<Subscriber<T>>();

    Map<T,Set<Subscriber<T>>> subscriberMap=new HashMap<T, Set<Subscriber<T>>>();

    /*@Override
    public void register(Subscriber<T> subscriber) {
        subscribers.add(subscriber);
    }*/

    @Override
    public void register(T key, Subscriber<T> subscriber) {
        Set<Subscriber<T>> subscribers = subscriberMap.get(key);
        if(subscribers==null){
            subscribers = new HashSet<Subscriber<T>>();
            subscriberMap.put(key,subscribers);
        }
        subscribers.add(subscriber);
    }

    @Override
    public void publish(T key, T message) {
        Set<Subscriber<T>> subscribers = subscriberMap.get(key);
        if(subscribers!=null){
            for(Subscriber<T> subscriber: subscribers){
                subscriber.getSubscription(message);
            }
        } else
            System.out.println("No subscribers found for "+key);
    }
}
