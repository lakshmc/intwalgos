package design.cardDesign;

import java.util.*;

/**
 * Created by lchan39 on 1/22/15.
 *
 * basically a factory for creating and obtaining cards.
 * A Deck object stores 52 cards --- these cards can be obtained from a Deck
 object via iteration, but a Deck object cannot be reshuffled and re-used.
 Instead, a new Deck object must be created to deal new cards. This keeps
 things simple and provides an easy-to-follow example of a class that
 implements the Iterator interface. The method remove() is optional --- for
 the Deck class calling this method throws an exception
 */
public class Deck implements Iterator<ICard> {
    private List<ICard> cards;
    private int index;

    public Deck() {
        cards = new ArrayList<ICard>();
        for(int suit=ICard.SPADES; suit<ICard.CLUBS; suit++){
            for(int rank=1; rank<=13; rank++){
                cards.add(new Card(rank, suit));
            }
        }
        shuffle();
    }

    public void shuffle(){
        Collections.shuffle(cards);
        index=0;
    }

    @Override
    public boolean hasNext() {
        return index < cards.size(); // could simply check for <52
    }

    @Override
    public ICard next() {
        return cards.get(index++);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Cannot remove from deck!");
    }


    // implementation for each card. Rank 1-13, Suit S,D,C,H

    /**
     * The Card class is a private class
     declared within the Deck class. There's actually no good reason to declare it within
     the Deck (the Deck.java file). However, by declaring it private, we make it
     impossible for any code class ; it could just as easily be declared as a non-public class within
     methods other than the Deck class to construct Card objects. This helps meet our original goal.
     Client programs can obtain cards from a Deck, but cannot create cards. Since the Deck supplies
     ICard objects, it's not possible to change a card once it's obtained from the Deck since the
     ICard interfaced doesn't support modification of a card
     */
    private class Card implements ICard {
        private int rank;
        private int suit;
        private String name;

        String[] suitArray = new String[]{"SPADES", "DIAMONDS", "CLUBS", "HEARTS"};
        String[] rankArray = new String[]{"invalid", "ace","two","three","four","five","six","seven","eight","nine",
                "ten","JACK","QUEEN","KING"};

        public Card(int rank, int suit) {
            this.rank=rank;
            this.suit=suit;
            this.name = rankArray[this.rank]+" of "+suitArray[this.suit];
        }

        public String toString(){
            return name;
        }

        @Override
        public int getRank() {
            return rank;
        }

        @Override
        public int getSuit() {
            return suit;
        }
    }
}
