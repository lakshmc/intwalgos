package graph.salesforce.friends;

import java.util.Set;

/**
 * Created by lchan39
 */
public interface FriendsInterface {
    void makeFriends(Person person1, Set<Person> persons);
    void removeFriends(Person person1, Set<Person> persons);
    void getDirectFriends(Person person);
    void getIndirectFriends(Person person);

}
