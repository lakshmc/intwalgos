package publishSubscribe;

/**
 * Created on 4/30/14.
 */
public class MainRunner {
    public static void main(String[] args){
        Publisher<String> publisher = new PublisherImpl<String>();
        Subscriber<String> subscriber1=new SubscriberImpl<String>("sub1");
        Subscriber<String> subscriber2=new SubscriberImpl<String>("sub2");

        publisher.register("123",subscriber1);
        publisher.register("123",subscriber2);
        publisher.register("987",subscriber2);

        publisher.publish("123", "this is 123");
        publisher.publish("987", "this is 987");
        publisher.publish("1000", "this is a 1000");
        publisher.publish("987", "this is a 987");


        publisher.unSubsribe("123", subscriber2);

        publisher.publish("123", "this is 123");
    }

}
