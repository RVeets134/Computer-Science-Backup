
public abstract class Vehicle implements Military {

	private String name;
	private int passengerLimit;
	private String vehicleType;
	
	public Vehicle(String name,int passengerLimit,String vehicleType) {

		this.name = name;
		this.passengerLimit = passengerLimit;
		this.vehicleType = vehicleType;
		
	}
	
	public abstract void move();
	
	public String getName()
	{
		
		return name;
		
	}
	
	public int getPassengerLimit()
	{
		
		return passengerLimit;
		
	}
	
	public String toString()
	{
		
		return "Type of Vehicle: " + vehicleType + "\n" + "Name of Vehicle: " + name + "\n" + "Maximum holding capacity: " + passengerLimit;
		
	}

}
