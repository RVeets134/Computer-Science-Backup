
public class Airplane extends Air{

	private String name;
	private int passengerLimit;
	private String vehicleType;
	
	public Airplane(String name,int passengerLimit,String vehicleType) {
		
		super(name,passengerLimit,vehicleType);
		this.name = name;
		this.passengerLimit = passengerLimit;
		this.vehicleType = vehicleType;
		
	}
	
	public void move()
	{
		
		System.out.println(name + " is an airplane that is flying.");
		
	}

}