
public class Jet extends Airplane{

	//Required Instance data for each vehicle
	private String name;
	private int passengerLimit;
	private String vehicleType;
	
	//Instantiates instance variables and sends parameter values to the parent
	public Jet(String name,int passengerLimit,String vehicleType) {
		
		//Sends values to its parent, the Airplane class
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
		
		System.out.println(name + " is an airplane that is flying using jets.");
		
	}

}