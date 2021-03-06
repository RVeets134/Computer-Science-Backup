import java.util.ArrayList;
import java.util.List;

/**
 * The ThirteensBoard class represents the board in a game of Thirteens.
 */
public class ThirteensBoard extends Board
{

  
    /**
     * The size (number of cards) on the board.
     */
    private static final int BOARD_SIZE = 10;

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
      {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 0};
    
    /**
     * Creates a new <code>ThirteensBoard</code> instance.
     */
    public ThirteensBoard()
    {
      super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
    }

    /**
     * Determines if the selected cards form a valid group for removal.
     * In Thirteens, the legal groups are (1) a pair of non-face cards
     * whose values add to 13, and (2) a king.
     * @param selectedCards the list of the indices of the selected cards.
     * @return true if the selected cards form a valid group for removal;
     *         false otherwise.
     */
    @Override
    public boolean isLegal(List<Integer> selectedCards)
    {
      //checks if the two cards selected added together equal 13
      if(selectedCards.size() == 2)
      {
        if(containsSum13(selectedCards))
        {
        	return true;
        }
      }
      
      //checks if the selected card is a K
      if(selectedCards.size() == 1)
      {
    	return containsK(selectedCards);
      }
      return false;
        
    }

    /**
     * Determine if there are any legal plays left on the board.
     * In Thirteens, there is a legal play if the board contains
     * (1) a pair of non-face cards whose values add to 13, or (2) a king.
     * @return true if there is a legal play left on the board;
     *         false otherwise.
     */
    @Override
    public boolean anotherPlayIsPossible()
    {
    	
      List<Integer> test = cardIndexes();
      return containsSum13(test) || containsK(test);
      
    }
    
    /**
     * Check for an 13-pair in the selected cards.
     * @param selectedCards selects a subset of this board.  It is list
     *                      of indexes into this board that are searched
     *                      to find an 13-pair.
     * @return true if the board entries in selectedCards
     *              contain an 13-pair; false otherwise.
     */
    public boolean containsSum13(List<Integer> selectedCards) 
    {
      //2 loops to check every combination of 2 in selectedCards 
      for(int i = 0;i < selectedCards.size()-1;i++)
      {
        for(int n = i+1;n < selectedCards.size();n++)
        {
        	//checks if 2 cards added together equals 13
        	if(cardAt(selectedCards.get(i)).pointValue()+cardAt(selectedCards.get(n)).pointValue() == 13)
        	{
        		return true;
        	}
        }
      }
      return false;
    }
    
    /**
     * Check for a K in the selected cards.
     * @param selectedCards selects a subset of this board.  It is list
     *                      of indexes into this board that are searched
     *                      to find a K group.
     * @return true if the board entries in selectedCards
     *              include a king; false otherwise.
     */
    public boolean containsK(List<Integer> selectedCards) 
    {
    	for(int i=0;i<selectedCards.size();i++)
    	{
    		if(cardAt(selectedCards.get(i)).rank().equals("king"))
    		{
    			return true;
    		}
      
    	}
    	return false;
    }  

}
