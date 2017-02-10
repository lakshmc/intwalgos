package graph.salesforce.friends;

import java.util.*;

/**
 * Created by lchan39
 */
public class FriendManager /*implements FriendsInterface */{

    private Map<String, Person> personMap;

    public FriendManager(){
        personMap = new HashMap<String, Person>();
    }


    public void makeFriends(String personName, Set<String> persons) {
        if(validPersonName(personName)){
            Person person = getOrAddPerson(personName);

            if(persons!=null){
                for(String friendName: persons){
                    if(validPersonName(friendName)){
                        person.addFriend(getOrAddPerson(friendName));
                    }
                }
            }else {
                throw new IllegalArgumentException("Friends set may not be null");
            }
        } else {
            throw new IllegalArgumentException("Person Name may not be null or empty");
        }

    }

    private Person getOrAddPerson(String personName){
        Person person;
        if(personMap.containsKey(personName)){
            person = personMap.get(personName);
        } else {
            person = new Person(personName);
            personMap.put(personName,person);
        }
        return person;
    }

    private boolean validPersonName(String personName) {
        return personName!=null && personName.length()>0;
    }
    private boolean personExists(String personName) {
        return personName!=null && personName.length()>0 && personMap.containsKey(personName);
    }

    public void removeFriends(String personName, Set<String> persons) {
        if(personExists(personName)){
            Person person = personMap.get(personName);

            if(persons!=null){
                for(String friendName: persons){
                    if(personExists(friendName)){
                        person.removeFriend(personMap.get(friendName));
                    }
                }
            }
        }
    }

    public Set<String> getDirectFriends(String personName) {
        Set<String> friends = new HashSet<String>();
        if(personExists(personName)){
            for(Person person: personMap.get(personName).getFriends()){
                friends.add(person.getName());
            }
        } else {
            throw new IllegalArgumentException("Person Name may not be null or empty");
        }
        return friends;
    }

    public void getIndirectFriends(String personName, int level) {

        Set<Person> currentLevel = new HashSet<Person>();
        Set<Person> nextLevel = new HashSet<Person>();
        Set<String> visitedPersons = new HashSet<String>();
        if(personExists(personName)) {
            currentLevel.addAll(personMap.get(personName).getFriends());
            int friendLevel = 0;
            while(!currentLevel.isEmpty()){
                Person currentperson = currentLevel.iterator().next();
                currentLevel.remove(currentperson);
                if(!visitedPersons.contains(currentperson.getName())){
                    nextLevel.addAll(currentperson.getFriends());
                    System.out.print(" " + currentperson.getName() + " ");
                }
                visitedPersons.add(currentperson.getName());
                if(currentLevel.isEmpty() && !nextLevel.isEmpty() && (level<0 || friendLevel<level)){
                    friendLevel++;
                    currentLevel.addAll(nextLevel);
                    nextLevel.clear();
                    System.out.print("\nLevel: " + friendLevel + " | No.Of Friends: " + currentLevel.size() + ": ");
                }
            }
        } else {
            throw new IllegalArgumentException(personName + " is not a valid person name");
        }
    }
}
