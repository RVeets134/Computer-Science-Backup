
public abstract class Ground extends Vehicle{
	
	public Ground(String name,int passengerLimit,String vehicleType) {
		
		super(name,passengerLimit,vehicleType);
		
	}
	
	public abstract void move();

}
