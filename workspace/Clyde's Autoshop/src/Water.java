
public abstract class Water extends Vehicle{

	private String name;
	private int passengerLimit;
	private String vehicleType;
	
	public Water(String name,int passengerLimit,String vehicleType) {
		
		super(name,passengerLimit,vehicleType);
		this.name = name;
		this.passengerLimit = passengerLimit;
		this.vehicleType = vehicleType;
		
	}
	
	public abstract void move();
	
}