import java.util.Scanner;

public class DieClient {

	public static void main(String[] args) {

		Die die = new Die();
		
		System.out.println("How many sides should your die have?");
		Scanner in = new Scanner(System.in);
		int userDecision = in.nextInt();
		
		if(userDecision > 0)
		{
			die.setNumberOfSides(userDecision);
		}
		
		die.roll();
		die.toString();

	}

}
