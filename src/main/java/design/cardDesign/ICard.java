package design.cardDesign;

/**
 * Created by lchan39 on 1/22/15.
 *
 * The interface specifies the behavior of a card without providing information about how cards are
  implemented. It's a simple way to use cards in the code without having access to a
 card's internals, without being able to create a specific card, and without knowing how cards are
 implemented.
 http://www.cs.duke.edu/csed/ap/cards/cardstuff.pdf
 *

 */
public interface ICard {
    public static final int SPADES=0;
    public static final int HEARTS=1;
    public static final int DIAMONDS=2;
    public static final int CLUBS=3;

    int getRankNumber(); //returns a value in the range of 1 (ace) to 13 (king)
    String getSuit(); // returns a value like ICard.HEARTS

}
