
public class Helicopter extends Air{

	private String name;
	
	public Helicopter(String name,int passengerLimit,String vehicleType) {
		
		super(name,passengerLimit,vehicleType);
		this.name = name;
		
	}
	
	public void move()
	{
		
		System.out.println(name + " is a helicopter that is hovering in the air.");
		
	}

}