import java.util.List;
import java.util.ArrayList;

/**
 * The ElevensBoard class represents the board in a game of Elevens.
 */
public class ElevensBoard extends Board {

	/**
	 * The size (number of cards) on the board.
	 */
	private static final int BOARD_SIZE = 9;

	/**
	 * The ranks of the cards for this game to be sent to the deck.
	 */
	private static final String[] RANKS =
		{"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

	/**
	 * The suits of the cards for this game to be sent to the deck.
	 */
	private static final String[] SUITS =
		{"spades", "hearts", "diamonds", "clubs"};

	/**
	 * The values of the cards for this game to be sent to the deck.
	 */
	private static final int[] POINT_VALUES =
		{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};

	/**
	 * Flag used to control debugging print statements.
	 */
	private static final boolean I_AM_DEBUGGING = false;


	/**
	 * Creates a new <code>ElevensBoard</code> instance.
	 */
	 public ElevensBoard() {
	 	super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
	 }

	/**
	 * Determines if the selected cards form a valid group for removal.
	 * In Elevens, the legal groups are (1) a pair of non-face cards
	 * whose values add to 11, and (2) a group of three cards consisting of
	 * a jack, a queen, and a king in some order.
	 * @param selectedCards the list of the indices of the selected cards.
	 * @return true if the selected cards form a valid group for removal;
	 *         false otherwise.
	 */
	@Override
	public boolean isLegal(List<Integer> selectedCards) {
	  
	//checks if the two cards selected added together equal 13
	  if (selectedCards.size()==2)
	  { boolean legal=containsPairSum11(selectedCards);
    if(legal==true)
    {
      return true;
    }
	  }
	  
	//checks if the 3 selected cards are a JKQ in some order
	  if(selectedCards.size()==3)
    {
	    boolean legal=containsJQK(selectedCards);
    if(legal==true)
    {
      return true;
    }
    }
    return false;
	}

	/**
	 * Determine if there are any legal plays left on the board.
	 * In Elevens, there is a legal play if the board contains
	 * (1) a pair of non-face cards whose values add to 11, or (2) a group
	 * of three cards consisting of a jack, a queen, and a king in some order.
	 * @return true if there is a legal play left on the board;
	 *         false otherwise.
	 */
	@Override
	public boolean anotherPlayIsPossible() {
	  List<Integer> test=cardIndexes();
	  return containsPairSum11(test) || containsJQK(test);
	  
	}

	/**
	 * Check for an 11-pair in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find an 11-pair.
	 * @return true if the board entries in selectedCards
	 *              contain an 11-pair; false otherwise.
	 */
	private boolean containsPairSum11(List<Integer> selectedCards) {
	//2 loops to check every combination of 2 in selectedCards 
	  for(int i=0;i<selectedCards.size()-1;i++)
    {
	    for(int n=i+1;n<selectedCards.size();n++)
	    //checks if 2 cards added together equals 11
      if(cardAt(selectedCards.get(i)).pointValue()+cardAt(selectedCards.get(n)).pointValue()==11)
      {
        return true;
      }
    }
    return false;
	}

	/**
	 * Check for a JQK in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find a JQK group.
	 * @return true if the board entries in selectedCards
	 *              include a jack, a queen, and a king; false otherwise.
	 */
	private boolean containsJQK(List<Integer> selectedCards) {
	 //changes the variable to true if in the sublist one of the rank is found
	    boolean king=false;
	    boolean queen=false;
	    boolean jack=false;
	    for(int i=0;i<selectedCards.size();i++)
      {
        if(cardAt(selectedCards.get(i)).rank().equals("king"))
        {
          king=true;
        }
        if(cardAt(selectedCards.get(i)).rank().equals("queen"))
        {
          queen=true;
        }
        if(cardAt(selectedCards.get(i)).rank().equals("jack"))
        {
          jack=true;
        }
      }
    
	    //if all three are present in the sublist then true is returned
	    if(king && queen && jack)
	    {
      return true;
	    }
      else
      {
      return false;
      }
	  
	}
}
