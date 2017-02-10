package graph.salesforce.friends;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lchan39
 */
public class Person {
    private final String name;
    private final Set<Person> friends;

    public Person(String name) {
        this.name = name;
        this.friends = new HashSet<Person>();
    }

    public void addFriends(Set<Person> persons){
        if(persons!=null && !persons.isEmpty()){
            this.friends.addAll(persons);
        }
    }
    public void addFriend(Person person){
        if(person!=null){
            this.friends.add(person);
        }
    }

    public void removeFriends(Set<Person> persons){
        if(persons!=null && !persons.isEmpty()){
            this.friends.removeAll(persons);
        }
    }
    public void removeFriend(Person person){
        if(person!=null){
            this.friends.remove(person);
        }
    }

    public String getName() {
        return name;
    }

    public Set<Person> getFriends() {
        return friends;
    }

    @Override
    public String toString() {
        return "Person{" +
                "friends=" + friends +
                ", name='" + name + '\'' +
                '}';
    }
}
