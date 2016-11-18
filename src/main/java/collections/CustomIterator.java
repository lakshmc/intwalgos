package collections;

import java.util.*;

/**
 * Prblm: Implement a custom iterator that overrides hasNext() and next() methods. It should accept <Iterator<Iterator<String>>>.
 * when running the loop(it.hasNext()){print ( it.next() )} it should interweave the items inside the inner iterator.
 * Eg:
 * input: [[a,b,c,d],[e,f],[g],[h,i,j,k,l]]
 * output: a,e,g,h,b,f,i,c,j,d,k,l
 *
 * Apple(Aug 2015)
 * - At first glance, performing <code> outerIt.hasNext(){outerIt.next().hasNext()}</code> seems like the answer. But when the outerIterator
 * reaches the end of first iteration, it will return false for subsequent iteration which is incorrect. One way to get around this is
 * to unpack the outer iterator into a collection and iterator on that collection for hasNext() and next(). We need to keep track of the current index
 * so that for each call we can check the item and then move to the next item.
 *
 * - Choice of collection can simplify the code well.
 *  - Array list: Need to keep track of the current index. Whenever an iterator reaches the end, it needs to be removed from the list so that
 *                  it is not queried again. Remove in list is expensive.
 *  - Queue: Much better option. Since we are only focused on one item of the iterator for each hasNext/next(), just looking at the head would do.
 *          After querying the head check if hasNext of that item is true. If so, add it back into the queue (at the end).
 *          If false, then dont add. This way, no need to keep index of current value. Insertion and delete are O(1) for queue.
 *          Handles varying number of iterators of varying sizes.
*        (down side: additional memory equal to size of outer iterator is needed. Could be an issue for large iterator sizes
 *
 *
 *
 *
 */
public class CustomIterator<E> implements Iterator<E>{

    Queue<Iterator<E>> iteratorQueue = new LinkedList<Iterator<E>>();


     CustomIterator(Iterator<Iterator<E>> it){
        // unpack the outer iterator into a queue
        if(it!=null){
            while (it.hasNext()){
                iteratorQueue.add(it.next());
            }
        }
    }


    public boolean hasNext() {
        return  iteratorQueue.peek()!=null && iteratorQueue.peek().hasNext();
    }

    public E next() {
        if(!hasNext()){
            throw new IllegalStateException("Iterator hasNext returned false!!");
        }
        Iterator<E> iterator = iteratorQueue.poll();
        E value = iterator.next();
        if(iterator.hasNext()){
            iteratorQueue.add(iterator);
        }
        return value;
    }

    public void remove() {
        iteratorQueue.poll();
    }

    public static void main(String[] args) {

        Iterator<String> arr1 = Arrays.asList("a","b","c","d").iterator();
        Iterator<String> arr2 = Arrays.asList("e","f","g","h").iterator();

        Iterator<Iterator<String>> outIterator = Arrays.asList(arr1, arr2).iterator();

        printIterator(outIterator);

        arr1 = Arrays.asList("a","b","c","d").iterator();
        arr2 = Arrays.asList("e","f").iterator();
        Iterator<String> arr3 = Arrays.asList("g").iterator();
        Iterator<String> arr4 = Arrays.asList("h","i","j","k","l").iterator();

        outIterator = Arrays.asList(arr1, arr2, arr3, arr4).iterator();
        printIterator(outIterator);

    }

    private static <E> void printIterator(Iterator<Iterator<E>> outIterator) {
        CustomIterator<E> myIterator = new CustomIterator<E>(outIterator);

        while(myIterator.hasNext()){
            System.out.print(myIterator.next() + " ");
        }
        System.out.println();
    }
}
