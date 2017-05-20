/**
 * This is a class that plays the GUI version of the CrazyThirteens game.
 * See accompanying documents for a description of how CrazyThirteens is played.
 */
public class CrazyThirteensGUIRunner
{
	/**
	 * Plays the GUI version of CrazyThirteens.
	 * @param args is not used.
	 */
	public static void main(String[] args) 
	{
		Board board = new CrazyThirteensBoard();
		CardGameGUI gui = new CardGameGUI(board);
		gui.displayGame();
	}
}
