
public abstract class Ground extends Vehicle{
	
	public Ground(String name,int passengerLimit,String vehicleType) {
		
		//Sends values to its parent, the vehicle class
		super(name,passengerLimit,vehicleType);
		
	}
	
	public abstract void move();

}
