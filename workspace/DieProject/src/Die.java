
public class Die {

	private final int MIN = 1;
	
	private int side = 0;
	
	private int newNumberOfSides = 0;
	
	private int max = newNumberOfSides;
	
	public int roll(){
		
		side = (int) ((Math.random() * max - MIN + 1) + MIN);
		return side;
		
	}
	
	public String toString(){
		
		return "Face Value: " + side;
		
	}
	
	public int clearRoll(){
		
		side = 0;
		return side;
		
	}
	
	public int setNumberOfSides(int numberOfSides){
		
		newNumberOfSides = numberOfSides;
		return newNumberOfSides;
		
	}

}
