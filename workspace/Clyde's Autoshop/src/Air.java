
public abstract class Air extends Vehicle{
	
	public Air(String name,int passengerLimit,String vehicleType) {
		
		super(name,passengerLimit,vehicleType);
		
	}
	
	public abstract void move();
	
}
