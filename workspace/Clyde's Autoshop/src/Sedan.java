
public class Sedan extends Car{

	private String name;
	private int passengerLimit;
	private String vehicleType;
	
	public Sedan(String name,int passengerLimit,String vehicleType) {
		
		super(name,passengerLimit,vehicleType);
		this.name = name;
		this.passengerLimit = passengerLimit;
		this.vehicleType = vehicleType;
		
	}
	
	public void move()
	{
		
		System.out.println(name + " is a sedan moving on four wheels.");
		
	}

}
