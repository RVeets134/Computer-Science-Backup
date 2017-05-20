import java.util.List;

//Changes the thirteens game so that three cards are chosen to add up to 13. Kings can be 1 of these cards. 
//Kings can also still be swapped by themselves, though this isn't the best choice.

public class CrazyThirteensBoard extends ThirteensBoard
{
  
  /**
   * contructor for class, just initializes super constructor
   */
public CrazyThirteensBoard()
{
  super();
}

/**
 * Method checks to see whether the selected cards either sum to 13 or is a king by itself. However,
 * if it sums to 13, then 3 cards must be selected in order for the play to be legal in CrazyThirteens.
 */
public boolean isLegal(List<Integer> selectedCards)
{
  //If three cards are selected, then the sum has to equal 13 to be a legal move. This can be checked using super isLegal method
  if (selectedCards.size() == 3)
  {
    boolean legal = containsSum13(selectedCards);
    if(legal)
    {
    	return legal;
    }
  }
  
  //using the new rules the selected card if checked for being a king and if it is removed in the right order
  if(selectedCards.size()==1)
  {
    return containsK(selectedCards);
  }
  return false;  
}

/**
 * Checks to see whether another play is possible to determine whether the game is over or not.
 */
public boolean anotherPlayIsPossible()
{
	List<Integer> test = cardIndexes();
	//uses super to check if cards adding up to 13 is a possible move and uses method in this class to check if a king removed in the right order is possible 
	return containsSum13(test) || containsK(test);
  
}

/**
 * Overrides parent class method to use three cards to determine the sum. If the three numbers sum to 13, then 
 * this method will return true; otherwise, it will return false.
 */
public boolean containsSum13(List<Integer> selectedCards)
{
	
	for(int x = 0;x < selectedCards.size() - 2;x++)
	{
		for(int i = x+1;i < selectedCards.size() - 1;i++)
		{
			for(int n = i+1;n < selectedCards.size();n++)
			{
				//checks if 3 cards added together equals 13
				if(cardAt(selectedCards.get(x)).pointValue() + cardAt(selectedCards.get(i)).pointValue() + cardAt(selectedCards.get(n)).pointValue() == 13)
				{
					return true;
				}
			}
		}
	}
    return false;   
}

}
