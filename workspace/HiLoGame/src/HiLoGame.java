/*
 * Rakesh Veetekat
 * Period 6 Computer Science
 * HiLo Summer Project
 */

import java.util.Scanner;

public class HiLoGame {

	public static void main(String[] args) {
		
		//Keeps count of number of rounds
		int gameCounter = 0;
		
		//Will keep track of round scores
		int[] scores = new int[5];
		
		System.out.println("Guess the number between 1 and 100. Entering any number "
				+ "outside this range will end the respective round.");
		
		//Will allow user to play game five times
		while(gameCounter < 5)
		{
		
		//Computer randomly picks number
		int randomNumber = getRandomNumber();
		
		Scanner in = new Scanner(System.in);
		int userGuess = in.nextInt();
		
		//Counts the number of guesses the user makes in a round
		int guessCounter = 0;
		boolean guessCorrect = false;
		
		//Checks each guess user makes
		while(userGuess >= 1 && userGuess <= 100 && guessCorrect == false)
		{
			
			//Stores info on whether user's guess is hi or low
			String hiOrLow;
			
			//Will check whether the user guess is correct
			guessCorrect = checkGuess(userGuess,randomNumber);
			
			//Determines whether user guess is too high or too low
			if(userGuess > randomNumber)
				{
					hiOrLow = "is too high";
				}
			else
				{
					hiOrLow = "is too low";
				}

			//Informs user about whether their guess was too hi or low
			if(guessCorrect == false)
				{
					System.out.println("Wrong. Your guess is " + hiOrLow + ". Try again.");
				}
			
			guessCounter++;
			if(guessCorrect == false)
				{
					userGuess = in.nextInt();
				}
		}
		
		//Informs user the round is over or the game is over
		if(gameCounter < 4)
			{
				System.out.println("Round over. Proceed to guess for next round.");	
			}
		else
			{
				System.out.println("Game over. Here are your results:");
			}
		
		//Updates the list of scores for each round
		scores[gameCounter] = guessCounter;
		gameCounter++;
		
		}
		
		//Finds the user's best score in all of the rounds
		int highScore = bestScore(scores);
		
		System.out.print("Round 1     " + "Round 2     "
		+ "Round 3     " + "Round 4     " + "Round 5");
		
		System.out.println();

		for(int x = 0;x < 5;x++)
			
			{
			
				System.out.print(scores[x] + "           ");
		
			}
		
		System.out.println();
		System.out.println();
		System.out.println("Your best score was: " + highScore);
		
	}

	public static int getRandomNumber()
	{
		
		return (1 + (int)(Math.random() * 100)); 
		
	}
	
	public static boolean checkGuess(int guess,int number)
	{
		
		if(guess == number)
			{
				return true;
			}
		else
			{
				return false;
			}
		
	}
	
	public static int bestScore(int[] scores)
	{
		
		int bestScore = scores[0];
		for(int n = 0;n < 5;n++)
			{
			
				if(bestScore > scores[n])
					{
						bestScore = scores[n];
					}
			
			}
		
		return bestScore;
		
	}
	
}
