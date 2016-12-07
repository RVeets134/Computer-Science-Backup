
public class Boat extends Water{

	private String name;
	
	public Boat(String name,int passengerLimit,String vehicleType) {
		
		super(name,passengerLimit,vehicleType);
		this.name = name;
		
	}
	
	public void move()
	{
		
		System.out.println(name + " is a boat that is floating in the water.");
		
	}

}