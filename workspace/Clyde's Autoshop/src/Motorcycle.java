
public class Motorcycle extends Ground{

	private String name;
	private int passengerLimit;
	private String vehicleType;
	
	public Motorcycle(String name,int passengerLimit,String vehicleType) {
		
		super(name,passengerLimit,vehicleType);
		this.name = name;
		this.passengerLimit = passengerLimit;
		this.vehicleType = vehicleType;
		
	}
	
	public void move()
	{
		
		System.out.println(name + " is a motorcycle moving on two wheels.");
		
	}

}