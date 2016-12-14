
public class Boat extends Water implements SteeringWheel {

	//Required Instance data for each vehicle
	private String name;
	private int passengerLimit;
	private String vehicleType;
	
	//Instantiates instance variables and sends parameter values to the parent
	public Boat(String name,int passengerLimit,String vehicleType) {
		
		//Sends values to its parent, the Water class
		super(name,passengerLimit,vehicleType);
		this.name = name;
		this.passengerLimit = passengerLimit;
		this.vehicleType = vehicleType;
		
	}
	
	/**
	 * This method outputs the type of movement the vehicle performs
	 */
	public void move()
	{
		
		System.out.println(name + " is a boat that is floating in the water.");
		
	}
	
	/**
	 * This method prints how the vehicle will turn right
	 */
	public void turnRight()
	{
		
		System.out.println(name + ", the " + vehicleType + ", is turning right using the steering wheel.");
		
	}
	
	/**
	 * This method prints how the vehicle will turn left
	 */
	public void turnLeft()
	{
		
		System.out.println(name + ", the " + vehicleType + ", is turning left using the steering wheel.");
		
	}

}