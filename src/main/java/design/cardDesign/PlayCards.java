package design.cardDesign;

/**
 * Created by lchan39 on 1/22/15.
 */
public class PlayCards {
    public static void main(String[] args) {
        Deck deck = new Deck();

        while(deck.hasNext()){
            System.out.println(deck.next());
        }

    }
}
